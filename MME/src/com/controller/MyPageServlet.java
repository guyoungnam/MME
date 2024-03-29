package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.SellerDTO;
import com.dto.UserDTO;
import com.service.SellerService;
import com.service.UserService;
import com.util.SessionMgmt;
import com.yeoutil.Util;


@WebServlet("/MyPage")
public class MyPageServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
			SessionMgmt se = new SessionMgmt(request);
				
				new Util(MyPageServlet.class);
				
				String nextPath = "MyPageUI";
				
				if(se.getUdto()==null)
				{
					nextPath = "LoginUI";
				}
				else
				{
					String opt = request.getParameter("opt");
					System.out.println("opt 테스트"+opt);
					if(opt.equals("1")) //수정하기
					{
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
				        		user_mobile1, 
				        		user_mobile2, 
				        		user_mobile3, 
				        		user_address, 
				        		user_brand);
						
						
						UserService service = new UserService();
						String seller_check = request.getParameter("seller_check").trim();
					if(seller_check.equals("0"))
					{
						int checkNum = service.mypage(uDTO);
					}
					else
					{
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
			            
			            SellerService sService = new SellerService();
			            
			            int checkNum = sService.sellerUpdate(uDTO, sDTO);
			            new Util(MyPageServlet.class);
					}
					}
					else if(opt.equals("2")) //삭제
					{
				}
				}
					RequestDispatcher dis = request.getRequestDispatcher(nextPath);
					dis.forward(request, response);
					}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
