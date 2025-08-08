<%@page import="model.CountDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿이 전달된 객체(session)</h2>
<hr>
<%
	CountDto dto = (CountDto)request.getAttribute("objsession"); //세션 객체가 가져와짐
	if(dto != null) {
%>
		추출된 값: <%= dto.getNumber() %><br>
<%
	}
	else {
%>
		추출된 객체가 없습니다!
<%		
	}
%>		
</body>
</html>