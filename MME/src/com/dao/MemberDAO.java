package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public int memberAdd(SqlSession session, MemberDTO mDTO) {
		int n = session.insert("MemberMapper.memberAdd", mDTO);
		return n;
	}

	public MemberDTO checkUserid(SqlSession session, String user_id) {
		
		return session.selectOne("MemberMapper.checkUserid", user_id);
	}

	public MemberDTO checkUseralias(SqlSession session, String user_alias) {
	
		return session.selectOne("MemberMapper.checkUseralias", user_alias);
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto =
				session.selectOne("MemberMapper.login", map);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String user_id) {
		MemberDTO dto =
				session.selectOne("MemberMapper.mypage", user_id);
		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO mDTO) {
		int n = session.insert("MemberMapper.memberUpdate", mDTO);

		return n;
	}

	public int idSearch(SqlSession session, MemberDTO iDTO) {
		int n = session.selectOne("MemberMapper.idSearch", iDTO);
		return n;
	}
	}

	

