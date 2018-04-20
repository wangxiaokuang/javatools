package tum0r.password;

public class RailFence {

	public static String encryption(String plainText, int num) {
		char[] temp = plainText.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int count = 0; count < num; count++) {
			for (int now = count; now < temp.length; now += num) {
				stringBuilder.append(temp[now]);
			}
		}
		return stringBuilder.toString();
	}

	public static String decryption(String cipherText, int num) {
		char[] temp = cipherText.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		int length = temp.length;
		for (int count = 0; count < (int) (length / 2.0 + 0.5); count++) {
			for (int now = count; now < length; now += (int) (length / 2.0 + 0.5)) {
				stringBuilder.append(temp[now]);
			}
		}
		return stringBuilder.toString();
	}

}
