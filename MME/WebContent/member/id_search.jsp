<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<style>  

.userjoininfo
{
	border-collapse:collapse; 
}
.userinfo th, .userinfo td { border:0px solid black; }
</style>



<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<script type="text/javascript">

var httpRequest = new XMLHttpRequest();
function selecOne()
{
	httpRequest.onreadystatechange = responseFun;
	var user_name = document.getElementById("user_name");
	var user_mobile1 = document.getElementById("user_mobile1");
	var user_mobile2 = document.getElementById("user_mobile2");
	var user_mobile3 = document.getElementById("user_mobile3");
	
	var queryString = 'Search?user_name=' + user_name
	+"&user_mobile1="+user_mobile1
	+"&user_mobile2="+user_mobile2
	+"&user_mobile3="+user_mobile3;

httpRequest.open("get", queryString, true);
httpRequest.send(null);

	}

function responseFun()
{
	consloe.log('${search.user_id}');
	consloe.log('${search.user_name}');
	var findCompl = "당신의 아이디는 ${search.user_id} ";
	}

</script>

</head>
<body>
<form name="useridsearch" id="useridsearch" action="IdSearch" method="get">

<table class="useridsearach">
	<tr>
		<td style="text-align:right;width:180px;">이름&nbsp;:&nbsp;&nbsp;</td><td><input type="text" name="user_name" id="user_name" value="${login.user_name}" /></td>
	</tr>

	<tr>
		<td style="text-align:right;width:180px;">전화번호&nbsp;:&nbsp;&nbsp;</td>
		<td>
			<input type="text" name="user_mobile1" id="user_mobile1" value="${login.user_mobile1}" size="3" maxlength="3" />
			-<input type="text" name="user_mobile2" id="user_mobile2" value="${login.user_mobile2}" size="5" maxlength="4" />
			-<input type="text" name="user_mobile3" id="user_mobile3" value="${login.user_mobile3}" size="5" maxlength="4" />
		</td>
	</tr>
	<tr>
		<td style="text-align:right;width:180px;"></td>
		<td>
			<input type="submit" value="ID 찾기" onclick="selectOne()" />&nbsp;&nbsp;<input type="button" onclick="user_reset()" value="취소" />
		</td>
	</tr>
	
</table>
</form>

<form name="passwdsearach" id="passwdsearach" action="IdSearch" method="get">
<table class="passwdsearach">
	<tr>
		<td style="text-align:right;width:180px;">아이디&nbsp;:&nbsp;&nbsp;</td><td><input type="text" name="user_id" id="user_id" value="${login.user_id}" /></td>
	</tr>

	<tr>
		<td style="text-align:right;width:180px;">전화번호&nbsp;:&nbsp;&nbsp;</td>
		<td>
			<input type="text" name="user_mobile1" id="user_mobile1" value="${login.user_mobile1}" size="3" maxlength="3" />
			-<input type="text" name="user_mobile2" id="user_mobile2" value="${login.user_mobile2}" size="5" maxlength="4" />
			-<input type="text" name="user_mobile3" id="user_mobile3" value="${login.user_mobile3}" size="5" maxlength="4" />
		</td>
	</tr>
	<tr>
		<td style="text-align:right;width:180px;"></td>
		<td>
			<input type="submit" value="비밀번호 찾기" />&nbsp;&nbsp;<input type="button" onclick="user_reset()" value="취소" />
		</td>
	</tr>
	
</table>
</form>

