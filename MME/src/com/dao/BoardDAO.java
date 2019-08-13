package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {

	public List<BoardDTO> listAll(SqlSession session, HashMap<String, String> map) {
		List<BoardDTO> list =
				session.selectList("BoardMapper.listAll",map);
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
		
		int totalCount = totalCount(session);  //전체리스트
		int curPag = curPage;	 //현재페이지
		int contentNum = 3; // 페이지당 보여줄 갯수= 3개
		int totalPage = 
				totalCount/contentNum; //전체 페이지 갯수
			if(totalCount%contentNum!=0) totalPage++; 
		
		int offSet = (curPag-1) * contentNum; //건너 띌 갯수, 전부다 훑어본다.
		List<BoardDTO> list = session.selectList //해당 페이지에 보여줄 게시물 데이터
					("BoradMapper.selectAllPageBoard", null, new RowBounds(offSet, contentNum));
		
		
		int pageGroupSize = 5;
		int startPage = (curPag-1)/pageGroupSize * pageGroupSize + 1;
		int endPage = startPage + pageGroupSize - 1;
		if(endPage>totalPage) endPage = totalPage;
		
		
		int prev = (curPag-pageGroupSize-1)/pageGroupSize * pageGroupSize + 1;
		int next = (curPag+pageGroupSize-1)/pageGroupSize * pageGroupSize + 1;
		
		
		DTO.setTotalCount(totalCount);
		DTO.setCurPage(curPag);
		DTO.setContentNum(contentNum);
		DTO.setTotalPage(totalPage);
		DTO.setList(list);
		DTO.setPageGroupSize(pageGroupSize);
		DTO.setStartPage(startPage);
		DTO.setEndPage(endPage);
		DTO.setPrev(prev);
		DTO.setNext(next);
		return DTO;

	}

	private int totalCount(SqlSession session) {
		return session.selectOne("totalCount");
	}
}
