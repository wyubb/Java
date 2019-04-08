package com.yzk.studentweb.util;

import org.hibernate.Session;

public class CloseSession {
	public void closeSession(Session session) {
		session.getTransaction().commit();
		session.getSessionFactory().close();
	}
}
