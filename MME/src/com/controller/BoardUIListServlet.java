package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardUIList")
public class BoardUIListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String curPage = request.getParameter("curPage");
		if(curPage == null) {
			curPage = "1";
		}
		
		BoardService service = new BoardService();
		BoardDTO pDTO = service.selectAllPageBoard(Integer.parseInt(curPage));
		
		List<BoardDTO> list = DTO.getList();


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
