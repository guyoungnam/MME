package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardService {

	public List<BoardDTO> listAll(HashMap<String, String> map) {
	
		SqlSession session =MySqlSessionFactory.getSession();
		List<BoardDTO> list = null;
		BoardDAO dao = new BoardDAO();
		
		try {
			list = dao.listAll(session,map);
		}finally {
			session.close();
		}
		return list;

	}

}
