package learning1021;

import java.io.File;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File dirFile = new File(".");
		FileAccept fileAccept = new FileAccept();
		fileAccept.setExtendName("java");
		String fileName[] = dirFile.list(fileAccept);
		for(String name : fileName) {
			System.out.println(name);
		}
	}

}
