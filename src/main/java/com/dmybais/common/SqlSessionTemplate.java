package com.dmybais.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jakarta.websocket.Session;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		// SessionFactoryBuider -> SessionFactory -> session
		
		String resource = "mybatis-config.xml";
		InputStream is;
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return session;
	}
}
