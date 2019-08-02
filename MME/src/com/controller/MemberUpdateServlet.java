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



@WebServlet("/MemberUpdate")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		UserDTO dto = 
				(UserDTO)session.getAttribute("login");
		
		String nextPage= null;
		
		if(dto==null) {
			nextPage="LoginUI";
			session.setAttribute("mesg", "다시시도.");
		}else {
			nextPage="MyPage";
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			String user_name = request.getParameter("user_name");
			String user_alias = request.getParameter("user_alias");
			String user_mobile1 = request.getParameter("user_mobile1");
			String user_mobile2 = request.getParameter("user_mobile2");
			String user_mobile3 = request.getParameter("user_mobile3");
			String user_address = request.getParameter("user_address");
			String user_brand = request.getParameter("user_brand");
		
			
			  UserDTO mDTO = new UserDTO(user_id, user_pw, user_name, user_alias, 
		        		Integer.parseInt(user_mobile1), 
		        		Integer.parseInt(user_mobile2), 
		        		Integer.parseInt(user_mobile3), 
		        		user_address, 
		        		user_brand);
			
	        
			UserService service = new UserService();

			
			String seller_check = request.getParameter("seller_check");
		
	        if(seller_check.equals("0")) 
	        {
	        	int checkNum = service.userUpdate(mDTO);
	        	if(checkNum > 0)
	        	{
	        		RequestDispatcher dis=
		    				request.getRequestDispatcher("mainpage/main.jsp");
	        		dis.forward(request, response);	
	        	}
	        	else
	        	{
	        		request.setAttribute("alert", "확인 ");
	        	}
	        }
	        else
	        {
	        	
	
	        	SellerService sService = new SellerService();

	        	String seller_num = request.getParameter("seller_num");
	        	String seller_name = request.getParameter("seller_name");
	            String seller_post = request.getParameter("seller_post");
	            String seller_address1 = request.getParameter("seller_address1");
	            String seller_address2 = request.getParameter("seller_address2");
	            String seller_product_type = request.getParameter("seller_product_type");

	            
	            SellerDTO sDTO = new SellerDTO(seller_num, 
	            		seller_name, 
	            		seller_post, 
	            		seller_address1,
	            		seller_address2, 
	            		seller_product_type
	            		);
	            
	            mDTO.setSeller_num(seller_num);
	            
	            int checkNum = sService.sellerUpdate(mDTO, sDTO);
	            
	            

	            if(checkNum > 0)
	        	{
	            	RequestDispatcher dis=
		    				request.getRequestDispatcher("mainpage/main.jsp");
	        		dis.forward(request, response);
	        	}
	        	else
	        	{
	        		request.setAttribute("alert", "확인 ");
	        	}
	        	
	            
	        }
	        
		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response); 
	}

}
