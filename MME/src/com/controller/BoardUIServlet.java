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
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.itf.CarELE;
import com.itf.OtherELE;
import com.service.BoardService;

@WebServlet("/BoardUI")
public class BoardUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		HashMap<String,String> map =
				new HashMap<String, String>();
		map.put("searchName" , searchName);
		map.put("searchValue" , searchValue);
		
		BoardService service = new BoardService();
		List<BoardDTO> list= service.listAll(map);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dis =
				request.getRequestDispatcher("mainpage/board.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
