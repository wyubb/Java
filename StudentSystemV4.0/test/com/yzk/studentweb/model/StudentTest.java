package com.yzk.studentweb.model;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yzk.studentweb.util.HibernateUtils;

public class StudentTest {
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
		Student student = new Student("1", 1, "男", "java", "1.jpg");
		session.save(student);
	}

}
