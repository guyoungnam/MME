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

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id",user_id );
		map.put("user_pw",user_pw);
		
		System.out.println("테스트: 넘어오나?");
	
		
		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);
		
		
		
	String nextPage=null;	
	if(dto == null) {
		nextPage= "LoginUI";
		
	}else {
		nextPage= "Main";
		HttpSession session=request.getSession();
		session.setAttribute("login", dto);
	}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
