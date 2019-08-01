package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MyPage")
public class MyPageServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = 
				(MemberDTO)session.getAttribute("login");
		
		String nextPage= null;
		
		if(dto==null) {
			nextPage="LoginUI";
	    
		}else {
			nextPage="mainpage/mypage.jsp";
			
			//DB접속
			String user_id = dto.getUser_id();
			MemberService service = 
					new MemberService();
			MemberDTO xxx = service.mypage(user_id);
			session.setAttribute("login", xxx);
			
			System.out.println("확인중xxxx "+xxx);
			System.out.println("확인중xxxxx ");
		}
		
		
	
		if(dto == null) {
			nextPage= "LoginUI";
	
		
		}else {
			nextPage= "Main";
			session.setAttribute("login", dto);
		}
			
			response.sendRedirect(nextPage);
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
