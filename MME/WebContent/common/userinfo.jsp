<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 


 <c:if test="${!empty mesg}">
	 <script>alert("${mesg}");</script>
</c:if> 
 	
 <c:if test="${empty uDTO}">
 	<table class="userinfo">
 		<tr>
 			<td><a href="LoginUI">로그인</a></td>
 			<td><a href="MemberUI">회원가입</a> </td>
 			<td><a href="IdSearchUI">아이디/비번 찾기</a> </td>
 			<td><a href="BoardUi">게시판</a></td>
 			<td><span style="font-size:30px;">&nbsp;${title}</span></td>

 		</tr>
 	</table>
</c:if>  
    
 <c:if test="${!empty uDTO}">
 
 	<table class="userinfo">
 		<tr>
 			<td> </td>
 			<td><a href="LogoutUI">로그아웃</a> </td>
 			<td><a href="MyPageUI">마이페이지</a></td>
 			<td><span style="font-size:30px;">${uDTO.user_name}</span>회원님</td>
 		</tr>
 	</table>
 	
</c:if>  
 