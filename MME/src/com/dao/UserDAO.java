package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.UserDTO;

public class UserDAO {
	
	public int userAdd(SqlSession session, UserDTO mDTO) {
		int n = session.insert("UserMapper.UserAdd", mDTO);
		return n;
	}

	public UserDTO checkUserid(SqlSession session, String user_id) {
		
		return session.selectOne("UserMapper.checkUserid", user_id);
	}

	public UserDTO checkUseralias(SqlSession session, String user_alias) {
	
		return session.selectOne("UserMapper.checkUseralias", user_alias);
	}

	public UserDTO login(SqlSession session, HashMap<String, String> map) {
		UserDTO dto =
				session.selectOne("UserMapper.login", map);
		return dto;
	}

	public UserDTO mypage(SqlSession session, String user_id) {
		UserDTO dto =
				session.selectOne("UserMapper.mypage", user_id);
		return dto;
	}

	public int userUpdate(SqlSession session, UserDTO mDTO) {
		int n = session.insert("UserMapper.UserUpdate", mDTO);

		return n;
	}

	public UserDTO idSearch(SqlSession session, UserDTO iDTO) {
		UserDTO dto = session.selectOne("UserMapper.idSearch", iDTO);
		  System.out.println("dao dto:확인중"+dto);
		return dto;
	}

	public UserDTO getSession(SqlSession session, String user_id) {
		UserDTO dto = session.selectOne("UserMapper.idSearch", user_id);
		return dto;
	}
	}

	

