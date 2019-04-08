package chapter1.diary.main;

import javax.swing.UIManager;

import chapter1.diary.bean.User;
import chapter1.diary.gui.DiaryWindow;

public class DiaryMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		User user = new User("javaweb°®ºÃÕß","ÄÐ",20);
		DiaryWindow diarywindow = new DiaryWindow(user);
		diarywindow.setVisible(true);
				
	}
}
