package tum0r.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import tum0r.error.ConvertException;

public class Hash {

	public static String encryption(String plainText, String mode) throws ConvertException {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			MessageDigest hash = MessageDigest.getInstance(mode);
			byte[] temp = hash.digest(plainText.getBytes());
			for (int count = 0; count < temp.length; count++) {
				String val = Integer.toHexString((int) temp[count] & 0xff);
				if (val.length() == 1) {
					val = "0" + val;
				}
				stringBuilder.append(val);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
}
