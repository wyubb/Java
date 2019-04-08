package learning1021;
import java.io.*;
//使用文件字节流读取文件的内容

public class Exercise4 {

	public static void main(String args[]) {
		// TODO 自动生成的方法存根
		int n = -1;
		byte [] a = new byte[100];
		
		try {
				File f = new File("Exercise4.java");
				System.out.println("文件名： " +f.getName());
				System.out.println("路径："+ f.getAbsolutePath());
				//要使用相对路径
				InputStream in = new FileInputStream("src\\learning1021\\Exercise4.java");
				//FileInputStream in = new FileInputStream(f);
				while((n = in.read(a,0,100)) != -1) {
					String s = new String(a,0,n);
					System.out.print(s);
				}
				in.close();
		}
		catch(IOException e){
			System.out.println("File read Error " + e);
		}
	}

}
