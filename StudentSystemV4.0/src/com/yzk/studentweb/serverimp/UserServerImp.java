package com.yzk.studentweb.serverimp;

import java.util.List;

import com.yzk.studentweb.dao.UserDao;
import com.yzk.studentweb.impldao.UserDaoImp;
import com.yzk.studentweb.model.User;
import com.yzk.studentweb.server.UserServer;

public class UserServerImp implements UserServer {
	private final UserDao dao = new UserDaoImp();

	@Override
	public boolean UserChek(User user) {
		return dao.UserChek(user);
	}

	@Override
	public List<User> showAllUser() {

		return dao.showAllUser();
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUer(id);
	}

	@Override
	public void updateUser(User user, int id) {
dao.updateUser(user, id);
	}

	@Override
	public boolean addUser(User user) {
		dao.addUser(user);
		return true;
	}

}
