package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.UserDTO;
import com.dto.SellerDTO;

public class SellerDAO {

	public int sellerAdd(SqlSession session, UserDTO mDTO, SellerDTO sDTO) {
		int n = session.insert("SellerMapper.sellerAdd", sDTO); 
		if(n > 0)
		{
			n = session.insert("MemberMapper.memberAdd", mDTO);
		}
		return n;
	}

	public SellerDTO checkSellernum(SqlSession session, String seller_num) {
		return session.selectOne("SellerMapper.checkSellernum",seller_num);
	
	}

	public int sellerUpdate(SqlSession session, UserDTO mDTO, SellerDTO sDTO) {
		int n = session.insert("SellerMapper.sellerUpdate", sDTO); 
		if(n > 0)
		{
			n = session.insert("MemberMapper.memberUpdate", mDTO);
		}
		return n;
	}

}
