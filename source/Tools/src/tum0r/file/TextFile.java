package tum0r.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import tum0r.misc.ToolsConfig;

public class TextFile {

	public static byte[] byteRead(String path, int length) {
		return byteRead(new File(path), length);
	}
	
	public static byte[] byteRead(File file, int length) {
		try {
			FileInputStream inputStream = new FileInputStream(file);
			byte[] result = new byte[length];
			int temp = inputStream.read(result);
			inputStream.close();
			if (temp != -1) {
				return result;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String charRead(String path, String encode, int end) {
		return charRead(new File(path), encode, end);
	}
	
	public static String charRead(File file, String encode, int end) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, encode);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder stringBuilder = new StringBuilder();
			String Line;
			while ((Line = bufferedReader.readLine()) != null) {
				stringBuilder.append(Line).append(end == ToolsConfig.CRLF ? "\r\n" : end == ToolsConfig.LF ? "\n" : end == ToolsConfig.CR ? "\r" : "");
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			return stringBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean byteWrite(String path, byte[] data, boolean append) {
		return byteWrite(new File(path), data, append);
	}
	
	public static boolean byteWrite(File file, byte[] data, boolean append) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file, append);
			fileOutputStream.write(data);
			fileOutputStream.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean charWrite(String path, String data, String encode, boolean append) {
		return charWrite(new File(path), data, encode, append);
	}
	
	public static boolean charWrite(File file, String data, String encode, boolean append) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file, append);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, encode);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(data);
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
