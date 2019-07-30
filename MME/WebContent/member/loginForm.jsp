<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
 <script type="text/javascript">

		function goJoinForm(){
			location.href="MemberUI";
		}
		
 </script>
<form action="LoginServlet" method="get">
아이디:<input type="text" name="userid"><br>
비밀번호:<input type="text" name="passwd"><br>
<input type="submit" value="로그인"><br>
<input type="button" value="회원가입" onclick="goJoinForm()"><br>
<input type="button" value="아이디/비밀번호 찾기" onclick="goidcheckForm"><br>
</form>