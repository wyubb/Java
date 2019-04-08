package learning1021;
import java.io.*;

public class FileAccept  implements FilenameFilter{
	private String extendName;

	public void setExtendName(String s) {
		extendName ="." +s;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO 自动生成的方法存根
		return name.endsWith(extendName);
	}
}
