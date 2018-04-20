package tum0r.password;

public class Affine {

	public static String encryption(String plainText, int m, int n) {
		char[] temp = plainText.toCharArray();
		StringBuilder cipherText = new StringBuilder();
		for (int count = 0; count < temp.length; count++) {
			if ((temp[count] >= 65 && temp[count] <= 90)) {
				cipherText.append((char) (((temp[count] - 'A') * m + n) % 26 + 'A'));
			} else if ((temp[count] >= 97 && temp[count] <= 122)) {
				cipherText.append((char) (((temp[count] - 'a') * m + n) % 26 + 'a'));
			}
		}
		return cipherText.toString();
	}

	public static String decryption(String cipherText, int m, int n) {
		char[] temp = cipherText.toCharArray();
		StringBuilder plainText = new StringBuilder();
		for (int count = 0; count <= 26; count++) {
			if ((m * count) % 26 == 1) {
				m = count;
			}
		}
		for (int count = 0; count < temp.length; count++) {
			if ((temp[count] >= 65 && temp[count] <= 90)) {
				plainText.append((char) (((temp[count] - 'A' - n + 26) * m) % 26 + 'A'));
			} else if ((temp[count] >= 97 && temp[count] <= 122)) {
				plainText.append((char) (Math.abs(((temp[count] - 'a' - n + 26) * m) % 26) + 'a'));
			}
		}
		return plainText.toString();
	}

}
