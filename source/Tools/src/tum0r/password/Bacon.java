package tum0r.password;

import java.util.HashMap;

import tum0r.error.ConvertException;
import tum0r.misc.ToolsConfig;

public class Bacon {

	public static String encryption(String plainText, int mode) throws ConvertException {
		HashMap<Character, String> encode = new HashMap<Character, String>();
		encode.put('A', "aaaaa");
		encode.put('B', "aaaab");
		encode.put('C', "aaaba");
		encode.put('D', "aaabb");
		encode.put('E', "aabaa");
		encode.put('F', "aabab");
		encode.put('G', "aabba");
		encode.put('H', "aabbb");
		encode.put('I', "abaaa");
		if (mode == ToolsConfig.FIRST_MODE) {
			encode.put('J', "abaab");
			encode.put('K', "ababa");
			encode.put('L', "ababb");
			encode.put('M', "abbaa");
			encode.put('N', "abbab");
			encode.put('O', "abbba");
			encode.put('P', "abbbb");
			encode.put('Q', "baaaa");
			encode.put('R', "baaab");
			encode.put('S', "baaba");
			encode.put('T', "baabb");
			encode.put('U', "babaa");
			encode.put('V', "babab");
			encode.put('W', "babba");
			encode.put('X', "babbb");
			encode.put('Y', "bbaaa");
			encode.put('Z', "bbaab");
		} else if (mode == ToolsConfig.SECOND_MODE) {
			encode.put('J', "abaaa");
			encode.put('K', "abaab");
			encode.put('L', "ababa");
			encode.put('M', "ababb");
			encode.put('N', "abbaa");
			encode.put('O', "abbab");
			encode.put('P', "abbba");
			encode.put('Q', "abbbb");
			encode.put('R', "baaaa");
			encode.put('S', "baaab");
			encode.put('T', "baaba");
			encode.put('U', "baabb");
			encode.put('V', "baabb");
			encode.put('W', "babaa");
			encode.put('X', "babab");
			encode.put('Y', "babba");
			encode.put('Z', "babbb");
		} else {
			throw new ConvertException("mode error");
		}
		char[] temp = plainText.toUpperCase().toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int count = 0; count < temp.length; count++) {
			stringBuilder.append(encode.get(temp[count])).append(" ");
		}
		return stringBuilder.toString();
	}

	public static String decryption(String cipherText, int mode) throws ConvertException {
		HashMap<String, String> decode = new HashMap<String, String>();
		decode.put("aaaaa", "A");
		decode.put("aaaab", "B");
		decode.put("aaaba", "C");
		decode.put("aaabb", "D");
		decode.put("aabaa", "E");
		decode.put("aabab", "F");
		decode.put("aabba", "G");
		decode.put("aabbb", "H");
		decode.put("abaaa", "I");
		if (mode == ToolsConfig.FIRST_MODE) {
			decode.put("abaab", "J");
			decode.put("ababa", "K");
			decode.put("ababb", "L");
			decode.put("abbaa", "M");
			decode.put("abbab", "N");
			decode.put("abbba", "O");
			decode.put("abbbb", "P");
			decode.put("baaaa", "Q");
			decode.put("baaab", "R");
			decode.put("baaba", "S");
			decode.put("baabb", "T");
			decode.put("babaa", "U");
			decode.put("babab", "V");
			decode.put("babba", "W");
			decode.put("babbb", "X");
			decode.put("bbaaa", "Y");
			decode.put("bbaab", "Z");
		} else if (mode == ToolsConfig.SECOND_MODE) {
			decode.put("abaaa", "J");
			decode.put("abaab", "K");
			decode.put("ababa", "L");
			decode.put("ababb", "M");
			decode.put("abbaa", "N");
			decode.put("abbab", "O");
			decode.put("abbba", "P");
			decode.put("abbbb", "Q");
			decode.put("baaaa", "R");
			decode.put("baaab", "S");
			decode.put("baaba", "T");
			decode.put("baabb", "U");
			decode.put("baabb", "V");
			decode.put("babaa", "W");
			decode.put("babab", "X");
			decode.put("babba", "Y");
			decode.put("babbb", "Z");
		} else {
			throw new ConvertException("mode error");
		}
		cipherText = cipherText.toLowerCase().replaceAll("[^A-Za-z]", "");
		if (cipherText.length() % 5 != 0 || cipherText.length() == 0) {
			throw new ConvertException("the cipher's length is not true ");
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int count = 0; count < cipherText.length(); count += 5) {
			stringBuilder.append(decode.get(cipherText.substring(count, count + 5))).append(" ");
		}
		return stringBuilder.toString();
	}

}
