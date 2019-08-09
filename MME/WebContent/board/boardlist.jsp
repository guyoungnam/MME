<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
<table border="1">
	<tr>
	 <td colspan="5">
	  <form action="BoardList">
	 검색
	   <select name="searchName">
	    <option value="title">제목</option>
	    <option value="author">작성자</option>
	   </select>
	    <input type="text" name="searchValue">
	    <input type="submit" value="검색">
	 </form>  
	 </td> 
	</tr>
	<tr>
	  <th>글번호</th>
	  <th>제목</th>
	  <th>작성자</th>
	  <th>작성일</th>
	  <th>조회수</th>
	</tr>
<c:forEach var="dto" items="${list}">
	<tr>
	  <th>${dto.num }</th>
	  <th><a href="BoardRetrieve?num=${dto.num }">${dto.title }</a></th>
	  <th>${dto.author }</th>
	  <th>${dto.writeday }</th>
	  <th>${dto.readCnt }</th>
	</tr>
</c:forEach>
</table>

<br>
    <div id="pageForm">
        <c:if test="${startPage != 1}">
            <a href='BoardList?page=${startPage-1}'>[ 이전 ]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='BoardList?page=${pageNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='BoardList?page=${endPage+1 }'>[다음]</a>
        </c:if>
    </div>


<a href="<c:url value='/BoardWriteUI'/>">글쓰기</a>


</body>
</html>
