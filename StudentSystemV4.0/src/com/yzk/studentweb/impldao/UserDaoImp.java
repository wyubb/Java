package com.yzk.studentweb.impldao;

import java.util.List;

import org.hibernate.Session;

import com.yzk.studentweb.dao.UserDao;
import com.yzk.studentweb.model.User;
import com.yzk.studentweb.util.CloseSession;
import com.yzk.studentweb.util.HibernateUtils;
import com.yzk.studentweb.util.MysqlConnection;

public class UserDaoImp extends MysqlConnection implements UserDao {
	private final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	private final CloseSession closeSession = new CloseSession();

	@Override
	public boolean UserChek(User user) {
		List<User> list = showAllUser();
		for (User temp : list) {
			if (temp.getName().equals(user.getName())) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> showAllUser() {
		session.beginTransaction();
		List<User> list = session.createQuery("FROM User").list();
		closeSession.closeSession(session);
		return list;
	}

	@Override
	public void deleteUer(int id) {
		session.beginTransaction();
		User temp = new User();
		temp.setId(id);
		session.delete(temp);
		closeSession.closeSession(session);
	}

	@Override
	public void updateUser(User user, int id) {
		session.beginTransaction();
		User temp = (User) session.get(User.class, id);
		// temp.setId(user.getId());
		temp.setName(user.getName());
		temp.setPassword(user.getPassword());
		temp.setUsername(user.getUsername());

		session.update(temp);
		closeSession.closeSession(session);
	}

	@Override
	public boolean addUser(User user) {
		session.beginTransaction();
		session.save(user);
		closeSession.closeSession(session);
		return false;
	}

}
