package tum0r.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import tum0r.misc.ToolsConfig;

public class HTTP {

	private HttpURLConnection connection;

	private CookieManager manager;

	private void initCookieManager() {
		manager = new CookieManager();
		CookieHandler.setDefault(manager);
	}

	public String get(String urlString, String[][] header, HttpCookie[] cookies, String encode, int end) {
		try {
			initCookieManager();
			URL url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			setParameter(header, null, cookies);
			connection.connect();
			return getResult(encode, end);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String post(String urlString, String[][] header, String parameter, HttpCookie[] cookies, String encode,
			int end) {
		try {
			initCookieManager();
			URL url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			setParameter(header, parameter, cookies);
			connection.connect();
			return getResult(encode, end);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private void setParameter(String[][] header, String parameter, HttpCookie[] cookies) {
		try {
			if (header != null) {
				for (String[] temp : header) {
					if (temp.length == 2) {
						connection.setDefaultRequestProperty(temp[0], temp[1]);
					}
				}
			}
			if (parameter != null) {
				PrintWriter out = new PrintWriter(connection.getOutputStream());
				out.print(parameter);
				out.flush();
			}
			if (cookies != null) {
				for (HttpCookie cookie : cookies) {
					connection.setRequestProperty(cookie.getName(), cookie.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getResult(String encode, int end) {
		InputStream inputStream;
		try {
			inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
					encode == null ? Charset.defaultCharset().displayName() : encode);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String Line;
			StringBuilder result = new StringBuilder();
			while ((Line = bufferedReader.readLine()) != null) {
				result.append(Line).append(end == ToolsConfig.CRLF ? "\r\n" : end == ToolsConfig.LF ? "\n" : end == ToolsConfig.CR ? "\r" : "");
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public HttpCookie[] getCookies() {
		CookieStore cookieStore = manager.getCookieStore();
		List<HttpCookie> temp = cookieStore.getCookies();
		if (temp.size() != 0) {
			HttpCookie[] cookies = new HttpCookie[temp.size()];
			for (int count = 0; count < cookies.length; count++) {
				cookies[count] = temp.get(count);
			}
			return cookies;
		}
		return null;
	}
}
