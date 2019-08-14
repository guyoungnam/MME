package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {

	public List<BoardDTO> listAll(SqlSession session) {
		List<BoardDTO> list =
				session.selectList("BoardMapper.listAll");
		return list;
	}

	public void write(SqlSession session, BoardDTO dto) {
		int num = 
			session.insert("BoardMapper.write", dto);
		
	}

	public BoardDTO selectByNum(SqlSession session, String num) {
		//
		readCnt(session, num);
		BoardDTO dto =
	session.selectOne("BoardMapper.selectByNum",
			Integer.parseInt(num));
		return dto;
	}
	private void readCnt(SqlSession session, String num) {
		session.update("BoardMapper.readCnt",
				Integer.parseInt(num));
	}

	public void deleteByNum(SqlSession session, String num) {
		int x = 
	session.delete("BoardMapper.deleteByNum", 
			Integer.parseInt(num));
		
	}

	public void updateByNum(SqlSession session, BoardDTO dto) {
		int x = 
	session.update("BoardMapper.updateByNum",dto);
		
	}

	public PageDTO selectAllPageBoard(SqlSession session, int curPage) {
		PageDTO DTO = new PageDTO();
		int perPage = 3;
		int offset = (curPage-1)*perPage;
		
		List<BoardDTO> list = session.selectList("selectAllStudent",null, new RowBounds(offset, perPage));
		DTO.setPerPage(perPage);
		DTO.setCurPage(curPage);
		DTO.setList(list);
		DTO.setTotalCount(totalCount(session));
		return DTO;

	}

	private int totalCount(SqlSession session) {
		return session.selectOne("totalCount");
	}
}
