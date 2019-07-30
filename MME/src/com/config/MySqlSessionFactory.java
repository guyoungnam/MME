package com.config;

import java.io.IOException;
import java.io.InputStream;



public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/config/Configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =
		new SqlSessionFactoryBuilder().build(inputStream);
	}//end class
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	
	
}//end class

