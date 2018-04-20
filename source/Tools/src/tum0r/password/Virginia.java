package tum0r.password;

import tum0r.error.ConvertException;

public class Virginia {

	public static String encryption(String plainText, String key) throws ConvertException {
		char[] plainTemp = plainText.toUpperCase().replace(" ", "").toCharArray();
		char[] keyTemp = key.toUpperCase().replace(" ", "").toCharArray();
		StringBuilder temp = new StringBuilder();
		for (int count = 0; count < plainTemp.length; count++) {
			temp.append(keyTemp[count % keyTemp.length]);
		}
		keyTemp = temp.toString().toCharArray();
		temp = new StringBuilder();
		for (int count = 0; count < plainTemp.length; count++) {
			temp.append((char) ((plainTemp[count] + keyTemp[count]) % 26 + 'A'));
			if (count % 5 == 0 && count != 0) {
				temp.append(" ");
			}
		}
		return temp.toString();
	}

	public static String decryption(String cipherText, String key) throws ConvertException {
		char[] cipherTemp = cipherText.toUpperCase().replace(" ", "").toCharArray();
		char[] keyTemp = key.toUpperCase().replace(" ", "").toCharArray();
		StringBuilder temp = new StringBuilder();
		for (int count = 0; count < cipherTemp.length; count++) {
			temp.append(keyTemp[count % keyTemp.length]);
		}
		keyTemp = temp.toString().toCharArray();
		temp = new StringBuilder();
		for (int count = 0; count < cipherTemp.length; count++) {
			temp.append((char) ((26 + cipherTemp[count] - keyTemp[count]) % 26 + 'A'));
			if (count % 5 == 0 && count != 0) {
				temp.append(" ");
			}
		}
		return temp.toString();
	}

}
