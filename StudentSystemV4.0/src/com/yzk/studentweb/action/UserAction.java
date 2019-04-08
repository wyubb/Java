package com.yzk.studentweb.action;

import java.util.ArrayList;
import com.yzk.studentweb.BaseAction;
import com.yzk.studentweb.model.User;
import com.yzk.studentweb.server.UserServer;
import com.yzk.studentweb.serverimp.UserServerImp;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {
	private UserServer userServer = new UserServerImp();
	private User user = new User();
	ArrayList<User> list = new ArrayList<User>();
	@SuppressWarnings("unused")
	private UserServer server = new UserServerImp();

	public String addUser() {
		if (userServer.UserChek(user)) {
			request.setAttribute("error", "用户已经存在");
			return INPUT;
		} else {
			userServer.addUser(user);
			list = (ArrayList<User>) userServer.showAllUser();
			request.setAttribute("lists", list);
			return SUCCESS;
		}
	}

	public String showUser() {
		list = (ArrayList<User>) userServer.showAllUser();
		request.setAttribute("lists", list);
		return SUCCESS;
	}

	public String deleteUser() {
		String temp = request.getParameter("id");
		int id = Integer.parseInt(temp);
		userServer.deleteUser(id);
		list = (ArrayList<User>) userServer.showAllUser();
		request.setAttribute("lists", list);
		return SUCCESS;
	}

	public String updataUser() {
		String temp = request.getParameter("id");
		int id = Integer.parseInt(temp);
		userServer.updateUser(user, id);
		list = (ArrayList<User>) userServer.showAllUser();
		request.setAttribute("lists", list);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
