package chapter1.diary.bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class User {
	private String name;
	private String gender;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public User() {
		super();
	}

	public static void main(String[] args) {
		//用带参数的构造函数创建一个User类的对象
		User user = new User("Javaweb爱好者","男",20);
		//创建一个ArrayList,用于容纳Diary
		ArrayList<Diary> diaries = new ArrayList<Diary>();
		//依次创建5个Diary放入diaries中
		for(int i = 1;i < 4;++i) {
			String authorName = user.getName();
			String title = "第" + i + "篇日记";
			String content ="第" + i + "篇日记的内容";
			GregorianCalendar time = new GregorianCalendar();
			//创建一个日记
			Diary diary = new Diary(authorName,content,time,title);
			//将日记放在diaries中
			diaries.add(diary);
					
		}
		for(Diary diary : diaries) {
			System.out.println("日记作者：" + diary.getAuthorName());
			System.out.println("日记标题：" + diary.getTitle());
			System.out.println("日记内容：" + diary.getContent());
			//得到创建日记的年月日时分
			GregorianCalendar time = diary.getTime();
			int year = time.get(GregorianCalendar.YEAR);
			int month = time.get(GregorianCalendar.MONTH) + 1;
			int day = time.get(GregorianCalendar.DATE);
			int hour = time.get(GregorianCalendar.HOUR_OF_DAY);
			int minute = time.get(GregorianCalendar.MINUTE);
			
			System.out.println("日记时间：" + year + "-" + month + "-" + day + "-" + hour + ":" + minute);
			System.out.println("****************************************");
			
			
		}
		
	}
}
