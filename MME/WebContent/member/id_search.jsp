<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    









    
<form name="loginInfo" action="Login" method="post" onsubmit="return checkValue()">
이름:<input type="text" name="user_id"><br>
휴대폰:<input type="text" name="user_mobile1">
<input type="text" name="user_mobile2">
<input type="text" name="user_mobile3">
<input type="submit" value="로그인"><br>
<input type="button" value="회원가입" onclick="goJoinForm()"><br>
<input type="button" value="아이디/비밀번호 찾기" onclick="goidcheckForm"><br>
</form>