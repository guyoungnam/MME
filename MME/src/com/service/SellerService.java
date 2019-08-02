package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.SellerDAO;
import com.dto.UserDTO;
import com.dto.SellerDTO;

public class SellerService {

	public int sellerAdd(UserDTO mDTO, SellerDTO sDTO) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		int result =0;
		try
		{
			SellerDAO dao = new SellerDAO();
			
			result = dao.sellerAdd(session, mDTO, sDTO); //���� ����
			
			if(result > 0)
			{
				session.commit();
			}
			else
			{
				session.rollback();
			}
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public SellerDTO checkSellernum(String seller_num) {
		SqlSession session = MySqlSessionFactory.getSession();
		SellerDTO result =null;
		
		try
		{
			SellerDAO dao = new SellerDAO();
			
			result = dao.checkSellernum(session, seller_num);
			
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	public int sellerUpdate(UserDTO mDTO, SellerDTO sDTO) {
		SqlSession session = MySqlSessionFactory.getSession();
		int result =0;
		try
		{
			SellerDAO dao = new SellerDAO();
			
			result = dao.sellerUpdate(session, mDTO, sDTO); //���� ����
			
			if(result > 0)
			{
				session.commit();
			}
			else
			{
				session.rollback();
			}
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	}


