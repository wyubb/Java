package learning1021;

import java.io.*;

public class Exercise5 {
	public static void main(String args[]) {
		byte [] a = "新年快乐".getBytes();
		byte [] b = "Happy New Year".getBytes();
		File file = new File("a.txt");				 //1.输出目的地
		try {
			OutputStream out = new FileOutputStream(file);		//2.指向目的地的输出流
			System.out.println(file.getName() + "的大小： "+ file.length() +"字节");    //a.txt 的大小： 0字节
			out.write(a);									//4.向目的地写入数据
			out.close();										//5.关闭输入流
			out = new FileOutputStream(file,true);  //准备向文件尾加内容
			System.out.println(file.getName() + "的大小： " + file.length() + "字节");	//a.txt的大小：8字节
			out.write(b,0,b.length);
			System.out.println(file.getName() + "的大小： " + file.length() + "字节");  //a.txt的1大小：22字节
			 out.close();
			
		}
		catch(IOException e){
			System.out.println("Error " + e);
		}
		
	}
}
