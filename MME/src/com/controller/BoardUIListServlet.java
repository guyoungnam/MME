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
import com.dto.PageDTO;
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
		PageDTO DTO = service.selectAllPageBoard(Integer.parseInt(curPage));
		
		List<BoardDTO> list = DTO.getList();
		int perPage = DTO.getPerPage();
		int totalCount = DTO.getTotalCount();
		int totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) totalPage++;
		
		request.setAttribute("list", list);
		
		System.out.println("totalCount > " + totalCount);
		System.out.println("totalPage > " + totalPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("mainpage/board.jsp");
		dis.forward(request, response);			

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
