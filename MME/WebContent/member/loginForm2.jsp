<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>  

.userjoininfo
{
	border-collapse:collapse; 
}
.userinfo th, .userinfo td { border:0px solid black; }
</style>

<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/GuUtil.js"></script>
<script type="text/javascript">
 
	var util = new GuUtil();
	
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
            	
       
         		
            		$(document).ready(function()
            		{
            			$("#userCheck").on("click", function()
            			{
            				var userid = $("#user_id").val();
            				var userpw = $("#user_pw").val();
            				var logintype = $("#login_type").val(); 
            				
            				var param =  "opt=100&user_id="+userid+"&user_pw="+userpw+"&login_type="+logintype;
            				
            				util.getHttp("post","MemberUtil", param, "text", function (data){
            					
            					if(data == "0")
            					{
            						alert("일반 회원");
            						location.href = "MainPage";
            					}
            					else if(data == "1")
            					{
            						alert("판매자");
            						location.href = "MainPage";
            					}
            					else if(data == "2")
            					{
            						alert("관리자");
            						location.href = "MainPage";
            					}
            					else
            					{
            						alert("입력 하신 로그인 정보가 올바른지 확인 바랍니다.");
            						$("#user_id").focus();
            					}
            				});
            			});
            		});

      
 
  
        	}			
        
 
		function goJoinForm(){
			location.href="MemberUI";
		}
		
		</script>
		</head>
 <body>
<table class="userjoininfo">
	<tr>
		<td colspan="2">
			<select name="login_type" id="login_type"></select>
				<script type="text/javascript">
					var orgProduct = $.parseJSON('${login_type}') ;
					var mesgProduct = "";
					
					$(document).ready(function() {
						$.each(orgProduct,function(key1,value2){
							mesgProduct += "<option value='"+ key1+"'>"+ value2+"</option>";
					   	});
						$("#login_type").html(mesgProduct);
					});
			</script>
			
					
		</td>
	</tr>
	<tr>
		<td align="right" width="100">아이디&nbsp;:&nbsp;</td>
		<td><input type="text" name="user_id" id="user_id" /></td>
	</tr>
	<tr>
		<td align="right">패스워드&nbsp;:&nbsp;</td>
		<td><input type="password" name="user_pw" id="user_pw" /></td>
	</tr>
	<tr>
		<td colspan="2"><button id="userCheck">로그인</button></td>
	</tr>
</table>
</body>
</html>