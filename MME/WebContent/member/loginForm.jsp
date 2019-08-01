<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 


 <script type="text/javascript">

        function checkValue(){
        	inputForm= eval("document.loginInfo");
        	if(!inputForm.user_id.value)
        		{
        		alert("아이디를 입력하세요");
        		inputForm.user_id.focus();
        		return false;
        		}
        	if(!inputForm.user_pw.value)
        		{alert("비밀번호를 입력하세요");
        		inputForm.user_pw.focus();
        		return false;
        		}
        	if(inputForm.user_id.value.indexOf(" ")>=0)
        		{alert("아이디에 공백을 사용할 수 없습니다.");
        		inputForm.user_id.focus();
        		inputForm.user_id.select();
        		return false;
        		
            	if(inputForm.user_id.value.length<4 ||inputForm.user_id.value.length4>12)
        		{alert("아이디를 4~12자까지 입력해주세요");
        		inputForm.user_id.focus();
        		inputForm.user_id.select();
        		return false;
        		
        		}
      
 
  
        	}			
        
 
		function goJoinForm(){
			location.href="MemberUI";
		}
		
 </script>
<form name="loginInfo" action="Login" method="post" onsubmit="return checkValue()">
아이디:<input type="text" name="user_id"><br>
비밀번호:<input type="password" name="user_pw"><br>
<input type="submit" value="로그인"><br>
<input type="button" value="회원가입" onclick="goJoinForm()"><br>
<input type="button" value="아이디/비밀번호 찾기" onclick="goidcheckForm"><br>
</form>