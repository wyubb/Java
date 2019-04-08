package learning1021;

import java.io.File;

public class Exercise3 {
	public static void main(String[] args) {
		try {
			Runtime ce =Runtime.getRuntime();
			File file = new File("c:/windows","Notepad.exe");
			ce.exec(file.getAbsolutePath());
			file = new File("C:\\Program Files (x86)\\Tencent\\QQBrowser","QQBrowser.exe");
			ce.exec(file.getAbsolutePath());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
