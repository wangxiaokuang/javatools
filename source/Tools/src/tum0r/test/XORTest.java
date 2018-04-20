package tum0r.test;

import tum0r.error.CountShortException;
import tum0r.password.XOR;

public class XORTest {
	public static void test() {
		XOR xor = new XOR();
//		String[] result=xor.encryption("this is a test text message", 64);
		String[] result=xor.encryption("这是一段测试文本", 64);
		for(int count = 0;count<result.length;count++) {
			System.out.print(result[count]+"    ");
		}
		System.out.println();
		try {
			System.out.println(xor.decryption(result[0], result[1]));
		} catch (CountShortException e) {
			e.printStackTrace();
		}
	}
}
