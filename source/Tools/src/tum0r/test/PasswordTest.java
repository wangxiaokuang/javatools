package tum0r.test;

import tum0r.error.ConvertException;
import tum0r.misc.ToolsConfig;
import tum0r.password.Hash;

public class PasswordTest {
	public static void test() {
		// Caesar caesar = new Caesar();
				// try {
				// System.out.println(caesar.decryption("def", 4));
				// } catch (ConvertException e) {
				// e.printStackTrace();
				// }

				// Bacon bacon = new Bacon();
				// try {
				// System.out.println(bacon.decryption("aaaaa aaaab", 1));
				// } catch (ConvertException e) {
				// e.printStackTrace();
				// }
				// RailFence railFence =new RailFence();
				// try {
				// System.out.println(railFence.decryption("yuaebatflo r euiu", 2));
				// } catch (ConvertException e) {
				// e.printStackTrace();
				// }

				Hash hash = new Hash();
				try {
					System.out.println(hash.encryption("N3i17523", ToolsConfig.MD5));
					// 202cb962ac59075b964b07152d234b70
				} catch (ConvertException e) {
					e.printStackTrace();
				}

				// Virginia virginia =new Virginia();
				// try {
				// System.out.println(virginia.decryption("KSMEHZ BBLKS MEMPO GAJXS EJCSF LZSY",
				// "RELATIONS"));
				// } catch (ConvertException e) {
				// e.printStackTrace();
				// }

				// Affine affine = new Affine();
				// System.out.println(affine.decryption("axg", 7, 3));
	}
}
