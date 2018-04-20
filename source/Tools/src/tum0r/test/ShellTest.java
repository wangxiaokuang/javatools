package tum0r.test;

import tum0r.misc.ToolsConfig;
import tum0r.shell.Execute;

public class ShellTest {
	public static void test() {
		System.out.println(Execute.execute("ifconfig", "utf-8", ToolsConfig.CR));
	}
}
