<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 
 function updateBoard(e,f){
	 e.preventDefault();
	 f.action="BoardUpdate";
	 f.submit();
 }
 function deleteBoard(e,num){
	 e.preventDefault();
	 location.href="BoardDelete?num="+num;
 }
 
</script>
</head>
<body>
<h1>게시판 자세히 보기</h1>

 
 
<form name="myForm">
<input type="hidden" name="num" value="${retrieve.num}">
글번호:${retrieve.num}&nbsp;작성일:${retrieve.writeday}
조횟수:${retrieve.readCnt}<br>
제목:<input type="text" name="title" value="${retrieve.title}"><br>
작성자:<input type="text" name="author" value="${retrieve.author}"><br>
내용:<textarea rows="10" cols="10" name="content">
${retrieve.content}</textarea>
 
 
<button onclick="updateBoard(event ,myForm)">수정</button>
<button onclick="deleteBoard(event,${retrieve.num})">삭제</button>
 
 
 
 
</form>
<a href="BoardList">목록</a>
</body>
</html>
 