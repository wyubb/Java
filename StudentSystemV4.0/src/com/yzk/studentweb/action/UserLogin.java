package com.yzk.studentweb.action;

import java.util.List;

import com.yzk.studentweb.BaseAction;
import com.yzk.studentweb.model.User;
import com.yzk.studentweb.server.UserServer;
import com.yzk.studentweb.serverimp.UserServerImp;

@SuppressWarnings("serial")

public class UserLogin extends BaseAction {
	private User user = new User();
	private UserServer userServer = new UserServerImp();
	
	public String execute() throws Exception {
		// System.out.println("执行");
		// System.out.println(user);
		// System.out.println(userServer.UserChek(user));
		List<User> list = userServer.showAllUser();
		System.out.println(list);
//		for (User temp : list) {
//			if (temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
//				session.setAttribute("user", "user");
//				session.setMaxInactiveInterval(60);
//				return SUCCESS;
//			}
//		}
		// if (userServer.UserChek(user)) {
		// session.setAttribute("user", "user");
		// session.setMaxInactiveInterval(60);
		// return SUCCESS;
		// }
		request.setAttribute("error", "用户名或密码错误");
		return INPUT;
	}

	public String exeitLogin() {
		session.removeAttribute("user");
		return "exeit";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
