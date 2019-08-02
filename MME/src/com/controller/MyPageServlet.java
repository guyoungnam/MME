package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserDTO;
import com.service.UserService;


@WebServlet("/MyPage")
public class MyPageServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserDTO dto = 
				(UserDTO)session.getAttribute("login");
		
		String nextPage= null;
		
		if(dto==null) {
			nextPage="LoginUI";
	    
		}else {
			nextPage="mainpage/mypage.jsp";
			
			//DB����
			String user_id = dto.getUser_id();
			UserService service = 
					new UserService();
			UserDTO xxx = service.mypage(user_id);
			session.setAttribute("login", xxx);
			
			System.out.println("Ȯ����xxxx "+xxx);
			System.out.println("Ȯ����xxxxx ");
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
