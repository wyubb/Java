package com.yzk.studentweb.test;

import java.util.List;

import com.yzk.studentweb.dao.UserDao;
import com.yzk.studentweb.impldao.UserDaoImp;
import com.yzk.studentweb.model.User;

public class Main {
	public static void main(String[] args) {
		UserDao dao = new UserDaoImp();
		User user = new User("1", "1", "1");
		List<User> list = dao.showAllUser();
		System.out.println(list);
	}
}
