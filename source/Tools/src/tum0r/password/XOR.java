package tum0r.password;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import tum0r.error.CountShortException;
import tum0r.misc.ToolsConfig;

public class XOR {
	
	private static String getKey(int length) throws CountShortException {
		if (length >= ToolsConfig.MIN && length <= ToolsConfig.MAX) {
			Random random = new Random();
			char[] key = new char[length];
			int x = 0;
			int temp = 'A';
			for (int count = 0; count < length; count++) {
				x = random.nextInt(2);
				temp = x == 0 ? 'A' : 'a';
				key[count] = (char) (random.nextInt(26) + temp);
			}
			return new String(key);
		} else {
			throw new CountShortException("the key length is between "+ToolsConfig.MIN+" and "+ToolsConfig.MAX);
		}
	}

	public static String[] encryption(String plainText, int length) {
		try {
			String[] result = new String[2];
			result[1] = getKey(length);
			char[] key = result[1].toCharArray();
			String encode = new String(key).substring(14, 15).compareToIgnoreCase("m") <= 0 ? "utf-8" : "gb2312";
			char[] plain = URLEncoder.encode(plainText, encode).toCharArray();
			String temp = new String(key).substring(20, 21);
			int interval = temp.compareToIgnoreCase("m") < 0 ? 6 : temp.compareToIgnoreCase("m") > 0 ? 10 : 12;
			for (int count = 0; count < plain.length; count++) {
				for (int keyIndex = 0; keyIndex < key.length; keyIndex += interval) {
					if ((plain[count] ^ key[keyIndex]) >32 && (plain[count] ^ key[keyIndex]) <126) {
						plain[count] = (char) (plain[count] ^ key[keyIndex]);
					}
				}
			}
			result[0] = new String(plain);
			return result;
		} catch (CountShortException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String decryption(String cipherText,String key) throws CountShortException {
		int length = key.length();
		if(length>=ToolsConfig.MIN&&length<=ToolsConfig.MAX) {
			char[] keyArray = key.toCharArray();
			String temp = key.substring(20, 21);
			int interval = temp.compareToIgnoreCase("m") < 0 ? 6 : temp.compareToIgnoreCase("m") > 0 ? 10 : 12;
			char[] cipher = cipherText.toCharArray();
			for(int count = 0;count<cipher.length;count++) {
				for(int keyIndex=keyArray.length-keyArray.length%interval;keyIndex>=0;keyIndex-=interval) {
					if((cipher[count]^keyArray[keyIndex])>32&&(cipher[count]^keyArray[keyIndex])<126) {
						cipher[count]=(char)(cipher[count]^keyArray[keyIndex]);
					}
				}
			}
			String encode=key.substring(14, 15).compareToIgnoreCase("m") <= 0 ? "utf-8" : "gb2312";
			String result = new String(cipher);
			try {
				return URLDecoder.decode(result,encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			throw new CountShortException("the key's length is not right");
		}
	}
}
