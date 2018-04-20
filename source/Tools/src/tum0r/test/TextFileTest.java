package tum0r.test;

import tum0r.file.TextFile;
import tum0r.misc.ToolsConfig;

public class TextFileTest {
	public static void test() {
		TextFile.byteWrite("byte.txt", TextFile.byteRead("test.txt", 1024), false);
		TextFile.charWrite("char.txt", TextFile.charRead("test.txt", "utf-8", ToolsConfig.CR), "utf-8", false);
	}
}
