package tum0r.test;

import tum0r.network.GetAddress;

public class AddressTest {
	public static void test() {
		String[] result = GetAddress.getAddress();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + "\t");
		}
	}
}
