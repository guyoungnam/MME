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
	
		String boardUI = request.getParameter("boardUI");
		
		System.out.println("나오나boardUI>>>>"+boardUI);
		
		if(boardUI.equals("boardList"))
		{
		String curPage = request.getParameter("curPage");
		if(curPage == null) curPage="1";
		
		BoardService service = new BoardService();
		PageDTO DTO = service.selectAllPageBoard(Integer.parseInt(curPage));
		
		request.setAttribute("DTO", DTO);
		
<<<<<<< HEAD
		request.setAttribute("list", list);
	
=======
>>>>>>> branch 'master' of https://github.com/guyoungnam/MME.git
		
		RequestDispatcher dis = request.getRequestDispatcher("mainpage/board.jsp");
		dis.forward(request, response);	
		
		}
		else {
			
			RequestDispatcher dis = request.getRequestDispatcher("mainpage/board.jsp");
			dis.forward(request, response);	
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
