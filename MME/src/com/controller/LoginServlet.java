package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserDTO;
import com.service.UserService;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id",user_id );
		map.put("user_pw",user_pw);
		
	
		UserService service = new UserService();
		UserDTO dto = service.login(map);
		
	
	HttpSession session=request.getSession();
	
	String nextPage=null;	
	if(dto == null) {
		nextPage= "LoginUI";
		session.setAttribute("meg", "�α��ν���");
		
	}else {
		nextPage= "Main";

		session.setAttribute("login", dto);
		session.setAttribute("meg", "�α��μ���");
	}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
