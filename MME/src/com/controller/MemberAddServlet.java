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



@WebServlet("/MemberAdd")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	    String nextpage="";
	      
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_alias = request.getParameter("user_alias");
		String user_mobile1 = request.getParameter("user_mobile1");
		String user_mobile2 = request.getParameter("user_mobile2");
		String user_mobile3 = request.getParameter("user_mobile3");
		String user_address = request.getParameter("user_address");
		String user_brand = request.getParameter("user_brand");
		
	
		  UserDTO uDTO = new UserDTO(user_id, user_pw, user_name, user_alias, 
	        		Integer.parseInt(user_mobile1), 
	        		Integer.parseInt(user_mobile2), 
	        		Integer.parseInt(user_mobile3), 
	        		user_address, 
	        		user_brand);
		  
		  String seller_check = request.getParameter("seller_check");
	        
	        UserService service = new UserService();
		     
	        
	        System.out.println("seller_check 확인중"+seller_check);
	       
	        if(seller_check.equals("0")) //
	        {
	        	int checkNum = service.userAdd(uDTO);
	        	
	        	System.out.println("uDTO 확인중"+uDTO);
	        	System.out.println("checkNum 확인중"+checkNum);
	        	
	        	if(checkNum > 0)
	        	{
	        		
	        		request.setAttribute("alert", "사용자 저장 완료 ");	
	        		request.setAttribute("title", "회원정보");
	        		nextpage ="mainpage/mypage.jsp"; //마이 페이지 이동
	        		
	        	}
	        	else
	        	{
	        
	        		request.setAttribute("alert", "사용자 저장 실패 ");
	        		nextpage = "mainpage/main.jsp";  //메인 페이지 이동
	        	}
	        }
	        else  //사업자
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
	            
	            uDTO.setSeller_num(seller_num);
	            
	            int checkNum = sService.sellerAdd(uDTO, sDTO); 
	           
   		
	        
	        	if(checkNum > 0) {
	        		
	        		request.setAttribute("alert", "Seller 저장 완료 ");	
	        		request.setAttribute("title", "Seller 페이지");
	        		
	        	    uDTO.setUser_pw(null);	
	        	
	        		
	        	}else {
	        		
	        		request.setAttribute("uDTO", uDTO);
        			request.setAttribute("sDTO", sDTO);
        	
	        }
	        	
	        	nextpage = "mainpage/mypage.jsp";
	        	
	}  
	        
	        RequestDispatcher dis = request.getRequestDispatcher(nextpage);
			dis.forward(request, response);
	}	
	       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
