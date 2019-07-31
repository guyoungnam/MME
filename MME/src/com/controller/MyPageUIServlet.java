package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.itf.CarELE;
import com.itf.OtherELE;

@WebServlet("/MyPageUI")
public class MyPageUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("title", "����������");
		
		/**
		 * ���� ���� ����
		 */
		request.setAttribute("area_info", OtherELE.getJson(OtherELE.AREA_ELE));
		/**
		 * �ڵ��� ��ȣ �귣��
		 */
		request.setAttribute("brand_info", OtherELE.getJson(CarELE.BRAND_ELE));
		
		/**
		 * ���� ���� ���� ����
		 */
		request.setAttribute("product_info", OtherELE.getJson(CarELE.NEW_CAR_ELE));
		
		
		RequestDispatcher dis = request.getRequestDispatcher("mainpage/mypage.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
