package chapter1.diary.bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Test {
	
	public static void main(String[] args) {
		
		// 用带参数的构造函数创建一个User类的对象
		User user = new User("java爱好者","男",20);
		
		// 创建一个ArrayList，用于容纳Diary
		ArrayList<Diary> diaries = new ArrayList<Diary>();
		
		for(int i=1;i<4;i++){
			// 作者姓名
			String authorName = user.getName();
			// 日记标题
			String title = "第" + i + "篇日记";
			// 日记内容
			String content = "第" + i + "篇日记的内容";
			// 日记时间
			GregorianCalendar time = new GregorianCalendar();

			// 创建一个日记
			Diary diary = new Diary(authorName, content, time, title);
			// 将日记放入diaries中
			diaries.add(diary);

		}
		
		// 依次输出diaries中所有日记的信息
		for (Diary diary : diaries) {
			System.out.println("日记作者:" + diary.getAuthorName());
			System.out.println("日记标题:" + diary.getTitle());
			System.out.println("日记内容:" + diary.getContent());

			// 得到创建日记时间的年、月、日、时、分
			GregorianCalendar time = diary.getTime();
			int year = time.get(GregorianCalendar.YEAR);
			int month = time.get(GregorianCalendar.MONTH)+1;
			int day = time.get(GregorianCalendar.DATE);
			int hour = time.get(GregorianCalendar.HOUR_OF_DAY);
			int minute = time.get(GregorianCalendar.MINUTE);

			System.out.println("日记时间:" + year + "-" + month + "-" + day + " " + hour + ":" + minute);
			System.out.println("****************************");
	}

	}
}
