package chapter1.diary.bean;

public class Student {
	String name;
	int age;
	String sex;
	
	void takeNote() {
		System.out.println("我是"+name);
		System.out.println("今年"+age);
		System.out.println("性别"+sex);
		System.out.println("我开始记笔记了。");
	}
	
	public static void main(String[] args) {
		//建立一个名为zhouxingxing的Student对象
		Student zhouxingxing = new Student();
		//为该对象的属性赋值
		zhouxingxing.name = "Javaweb爱好者";
		zhouxingxing.age = 20;
		zhouxingxing.sex ="男";
		//调用该对象的takeNote方法
		zhouxingxing.takeNote();
				
		
		
	}
}
