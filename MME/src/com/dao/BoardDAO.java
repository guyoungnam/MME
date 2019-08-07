package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {

	public List<BoardDTO> listAll(SqlSession session, HashMap<String, String> map) {
		List<BoardDTO> list =
				session.selectList("BoardMapper.listAll",map);
		return list;
	}

}
