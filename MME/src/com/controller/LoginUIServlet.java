package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itf.OtherELE;
import com.util.SessionMgmt;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/LoginUI")
public class LoginUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		String nextPage = "mainpage/login.jsp";
		
		SessionMgmt se = new SessionMgmt(request);
		if(se.getUdto() == null)
		{
			request.setAttribute("title", "로그인");
			request.setAttribute("login_type", OtherELE.getJson(OtherELE.LOGIN_TYPE));
			nextPage = "mainpage/login.jsp";
		}
		else
		{
			se.setUdto();
			nextPage = "MyPageUI";
		}
		
		
		RequestDispatcher dis=
				request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
