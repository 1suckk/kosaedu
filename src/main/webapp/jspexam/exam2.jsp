<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 선언문 태그(%!)로 선언하는 변수는 멤버변수이며 계속해서 증가한다
다른 브라우저에서 열어도 연속적으로 증가한다 --%>
<%! int member_v = 0; %>

<%--로컬 변수는 실행할 때마다 계속해서 0에서 10으로 증가하는 반복만 수행된다 --%>
<%
      	int local_v = 0;
    	member_v += 10;
    	local_v += 10;
%>
<h1>JSP의 멤버 번수와 지역 변수</h1>
<hr>
<ul>
	<li> 멤버 변수 : <%= member_v %></li> 
	<li> 지역 변수 : <%= local_v %></li> 
</ul>
</body>
</html>