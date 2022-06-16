<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>
<div class="jumbotron">
	<h3>회원목록</h3>
</div>
<div class="container">
	<table class="table">
	<tr>
			<th>회원아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>비밀번호</th>
		
	</tr>
	<c:forEach items="${memberlist}" var = "m">
	<tr>
			<td>${m.id}</td>
			<td>${m.userName}</td>
			<td>${m.email}</td>
			<td>${m.password}</td>
	
	</tr>
	</c:forEach>
</table>
</div>