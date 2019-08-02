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

import org.apache.catalina.tribes.MembershipService;

import com.dto.UserDTO;
import com.dto.SellerDTO;
import com.service.UserService;
import com.service.SellerService;

@WebServlet("/IdSearch")
public class IdSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String user_name = request.getParameter("user_name");
		String user_mobile1 = request.getParameter("user_mobile1");
		String user_mobile2 = request.getParameter("user_mobile2");
		String user_mobile3 = request.getParameter("user_mobile3");
		
	
			
			  UserDTO iDTO = new UserDTO(user_name, 
		        		Integer.parseInt(user_mobile1), 
		        		Integer.parseInt(user_mobile2), 
		        		Integer.parseInt(user_mobile3) 
		        		);
		
			  System.out.println("iDTO를 담았다."+iDTO);
			  
			UserService service = new UserService();
			
			UserDTO idresult = service.idSearch(iDTO);
			
			System.out.println("idresult:확인중"+idresult);
			
			RequestDispatcher dis=
    				request.getRequestDispatcher("member/id_search.jsp");
    		dis.forward(request, response);
			
        	
	}
			
	           
	
	      


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response); 
	}

}
