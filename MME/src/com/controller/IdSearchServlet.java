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

import com.dto.MemberDTO;
import com.dto.SellerDTO;
import com.service.MemberService;
import com.service.SellerService;

@WebServlet("/IdSearch")
public class IdSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String user_name = request.getParameter("user_name");
		String user_mobile1 = request.getParameter("user_mobile1");
		String user_mobile2 = request.getParameter("user_mobile2");
		String user_mobile3 = request.getParameter("user_mobile3");
		
	
			
			  MemberDTO iDTO = new MemberDTO(user_name, 
		        		Integer.parseInt(user_mobile1), 
		        		Integer.parseInt(user_mobile2), 
		        		Integer.parseInt(user_mobile3) 
		        		);
			
	        
		
			MemberService service = new MemberService();
			
			int checkNum = service.idSearch(iDTO);
        	if(checkNum > 0)
        	{
        		RequestDispatcher dis=
	    				request.getRequestDispatcher("member/id_search_form.jsp");
        		dis.forward(request, response);
        		

        	}
        	else
        	{
				response.sendRedirect("IdSearch");
			}
	}
			
	           
	
	      


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response); 
	}

}
