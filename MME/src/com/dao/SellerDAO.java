package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;
import com.dto.SellerDTO;

public class SellerDAO {

	public int sellerAdd(SqlSession session, MemberDTO mDTO, SellerDTO sDTO) {
		int n = session.insert("SellerMapper.SellerAdd", sDTO); //에러 원인
		if(n > 0)
		{
			n = session.insert("MemberMapper.memberAdd", mDTO);
		}
		return n;
	}

	public SellerDTO checkSellernum(SqlSession session, String seller_num) {
		return session.selectOne("SellerMapper.checkSellernum",seller_num);
	
	}

}
