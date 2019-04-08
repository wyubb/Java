package com.yzk.studentweb.dao;

import java.util.List;

import com.yzk.studentweb.model.User;

public interface UserDao {
	boolean UserChek(User user);
	List<User> showAllUser();// 显示所有管理

	void deleteUer(int id);// 删除管理员

	void updateUser(User user, int id);// 修改管理员信息

	boolean addUser(User user);// add管理员
}
