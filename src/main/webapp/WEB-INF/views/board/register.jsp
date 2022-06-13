<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
	제목: <input type="text" name = "title"> <br>
	내용: <br> 
	<textarea rows="30" cols="50" name="content"></textarea><br>
	작성자:<input type="text" name = "writer"> <br>
	<button>등록</button>
</form>
</body>
</html>