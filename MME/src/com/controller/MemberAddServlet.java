package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.MembershipService;

import com.dto.MemberDTO;
import com.dto.SellerDTO;
import com.service.MemberService;
import com.service.SellerService;



@WebServlet("/MemberAdd")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_alias = request.getParameter("user_alias");
		String user_mobile1 = request.getParameter("user_mobile1");
		String user_mobile2 = request.getParameter("user_mobile2");
		String user_mobile3 = request.getParameter("user_mobile3");
		String user_address = request.getParameter("user_address");
		String user_brand = request.getParameter("user_brand");
		
		
		
//		MemberAdd?user_id=1
//				&user_pw=2
//				&user_name=3
//				&user_alias=4
//				&user_mobile1=5
//				&user_mobile2=6
//				&user_mobile3=7
//				&user_address=N61
//				&user_brand=B01
//				
//				& seller_check=0
//				
//				&seller_num=
//				&seller_name=
//				&seller_post=
//				&seller_address1=
//				&seller_address2=
//				&seller_product_type=NC2
		
		

		
		  MemberDTO mDTO = new MemberDTO(user_id, user_pw, user_name, user_alias, 
	        		Integer.parseInt(user_mobile1), 
	        		Integer.parseInt(user_mobile2), 
	        		Integer.parseInt(user_mobile3), 
	        		user_address, 
	        		user_brand);
		  
		  String seller_check = request.getParameter("seller_check");
	        
	        MemberService service = new MemberService();
		
	        if(seller_check.equals("0")) //에러?
	        {
	        	int checkNum = service.memberAdd(mDTO);
	        	if(checkNum > 0)
	        	{
	        		request.setAttribute("alert", "메시지1 ");	
	        	}
	        	else
	        	{
	        		request.setAttribute("alert", "메시지2 ");
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
	            
	            int checkNum = sService.sellerAdd(mDTO, sDTO); //에러	원인
	            
	            if(checkNum > 0)
	        	{
	        		request.setAttribute("alert", "성공 ");	
	        	}
	        	else
	        	{
	        		request.setAttribute("alert", "실패 ");
	        	}
	        	
	            
	        }
	        
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response); //에러원인
	}

}
