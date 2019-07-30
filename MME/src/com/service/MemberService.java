package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {

	public int memberAdd(MemberDTO mdto) {
		
	SqlSession session = MySqlSessionFactory.getSession();
	int result =0;

	try {
		MemberDAO dao = new MemberDAO();
		result=dao.memberAdd(session,mdto);
		session.commit();
	}finally {
		session.close();
	}
	return result;
}//end memberAdd

	public MemberDTO checkUserid(String user_id)
	{
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO result = null;
		
		try
		{
			MemberDAO dao = new MemberDAO();
			result = dao.checkUserid(session, user_id);
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public MemberDTO checkUseralias(String user_alias) {
        SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO result = null;
		
		try
		{
			MemberDAO dao = new MemberDAO();
			result = dao.checkUseralias(session, user_alias);
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public MemberDTO login(HashMap<String, String> map) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto =null;
		MemberDAO dao =new MemberDAO();
		System.out.println("map³ª¿À³ª1"+map);
		try {
			dto = dao.login(session,map);
		}finally {
			session.close();
			
		}
		return dto;

	}



}