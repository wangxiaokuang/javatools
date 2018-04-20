package tum0r.password;

public class Caesar {

	public static String encryption(String plainText, int num) {
		char[] temp = plainText.toCharArray();
		for (int count = 0; count < temp.length; count++) {
			if (temp[count] >= '0' && temp[count] <= '9') {
				temp[count] = (char) (((temp[count] - '0') + num) % 10 + '0');
			} else if (temp[count] >= 'a' && temp[count] <= 'z') {
				temp[count] = (char) (((temp[count] - 'a') + num) % 26 + 'a');
			} else if (temp[count] >= 'A' && temp[count] <= 'Z') {
				temp[count] = (char) (((temp[count] - 'A') + num) % 26 + 'A');
			}
		}
		return new String(temp);
	}

	public static String decryption(String cipherText, int num) {
		char[] temp = cipherText.toCharArray();
		for (int count = 0; count < temp.length; count++) {
			if (temp[count] >= '0' && temp[count] <= '9') {
				temp[count] = (char) (((temp[count] - '9') - num) % 10 + '9');
			} else if (temp[count] >= 'a' && temp[count] <= 'z') {
				temp[count] = (char) (((temp[count] - 'z') - num) % 26 + 'z');
			} else if (temp[count] >= 'A' && temp[count] <= 'Z') {
				temp[count] = (char) (((temp[count] - 'Z') - num) % 26 + 'Z');
			}
		}
		return new String(temp);
	}
}
