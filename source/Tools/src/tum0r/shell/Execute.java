package tum0r.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tum0r.misc.ToolsConfig;

public class Execute {

	public static String execute(String command, String encode, int end) {
		try {
			Process process = Runtime.getRuntime().exec(command);
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, encode);

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder stringBuilder = new StringBuilder();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append(end == ToolsConfig.CRLF ? "\r\n" : end == ToolsConfig.LF ? "\n" : end == ToolsConfig.CR ? "\r" : "");
			}
			return stringBuilder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
