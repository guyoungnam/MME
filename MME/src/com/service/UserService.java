package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.UserDAO;
import com.dto.UserDTO;


public class UserService {

	public int userAdd(UserDTO mDTO) {
		
	SqlSession session = MySqlSessionFactory.getSession();
	int result =0;

	try {
		UserDAO dao = new UserDAO();
		result=dao.userAdd(session,mDTO);
		session.commit();
	}finally {
		session.close();
	}
	return result;
}//end userAdd

	public UserDTO checkUserid(String user_id)
	{
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO result = null;
		
		try
		{
			UserDAO dao = new UserDAO();
			result = dao.checkUserid(session, user_id);
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public UserDTO checkUseralias(String user_alias) {
        SqlSession session = MySqlSessionFactory.getSession();
        UserDTO result = null;
		
		try
		{
			UserDAO dao = new UserDAO();
			result = dao.checkUseralias(session, user_alias);
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public UserDTO login(HashMap<String, String> map) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO dto =null;
		UserDAO dao =new UserDAO();
		System.out.println("map������"+map);
		try {
			dto = dao.login(session,map);
		}finally {
			session.close();
			
		}
		return dto;

	}

	public UserDTO mypage(String user_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO dto =null;
		
		try {
			UserDAO dao =new UserDAO();
			dto = dao.mypage(session,user_id);
		}finally {
			session.close();
			
		}
		return dto;
		
		
	}

	public int userUpdate(UserDTO mDTO) {
		SqlSession session = MySqlSessionFactory.getSession();
		int result =0;

		try {
			UserDAO dao = new UserDAO();
			result=dao.userUpdate(session,mDTO);
			
			session.commit();
		}finally {
			session.close();
		}
		return result;
	}

	public UserDTO idSearch(UserDTO iDTO) {
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO dto =null;
		
		  System.out.println("service1"+iDTO);
		try {
			UserDAO dao = new UserDAO();
			dto =dao.idSearch(session,iDTO);
	
			  System.out.println("service2:확인중"+iDTO);
			  System.out.println("service2:확인중"+dto);
			session.commit();
		}finally {
			session.close();
		}
		  System.out.println("dto:확인중"+dto);
		return dto;
	
	}

	public UserDTO getSession(String user_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO result =null;
		
		try
		{
			UserDAO dao = new UserDAO();
			result = dao.getSession(session, user_id);
		}
		finally
		{
			session.close();
		}
		
		return result;
	}



}