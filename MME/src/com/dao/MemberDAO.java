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
		System.out.println("map나오나DAO"+map);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String user_id) {
		MemberDTO dto =
				session.selectOne("MemberMapper.mypage", user_id);
		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO mDTO) {
		int n = session.insert("MemberMapper.memberUpdate", mDTO);
		System.out.println("********테스트DAO********");
		System.out.println("mDTO 확인"+mDTO);
		return n;
	}
	}

	

