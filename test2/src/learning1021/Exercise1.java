package learning1021;

import java.io.*;


public class Exercise1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File file = new File("Exercise1.java");
		System.out.println(file.getName() +"是可读的吗：" + file.canRead());
		System.out.println(file.getName() + "的长度： " +file.length());
		System.out.println(file.getName() + "的绝对路径" + file.getAbsolutePath());
		File file2 = new File("E:\\code","new.txt");
		System.out.println("在当前目录下创建新文件" + file2.getName());
		if(!file2.exists()) {
			try {
				file2.createNewFile();
				System.out.println("创建成功！");
			}
			catch(IOException exp) {
				System.out.println("error");
			}
			
		}
		file2.delete();
		if(file2.exists()) {
			System.out.println("我还在！");
		}else {
			System.out.println(file2.getName()+"不在");
		}
		
		
	}

}
