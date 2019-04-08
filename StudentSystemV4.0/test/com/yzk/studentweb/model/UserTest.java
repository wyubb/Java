package com.yzk.studentweb.model;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yzk.studentweb.util.HibernateUtils;

public class UserTest {
	Session session;

	@Before
	public void setUp() throws Exception {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();
	}

	@Test
	public void test() {
		User user = new User("admin", "admin", "yzk");
		session.save(user);
//		Student student = new Student("zy", 13, "男", "java", "1.jpg");
//		session.save(student);
	}

}
