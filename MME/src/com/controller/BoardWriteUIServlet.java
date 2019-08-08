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

@WebServlet("/BoardWriteUI")
public class BoardWriteUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("title", "게시판");
		
		RequestDispatcher dis =
				request.getRequestDispatcher("mainpage/boardwrite.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
