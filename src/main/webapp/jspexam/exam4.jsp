<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--&amp;는 &를 의미한다 --%>
<h1>Query 문자열 추출(GET&amp;POST)</h1>
<hr>
<%
	//post로 요청을 하게 되면 문자열 인코딩 설정을 맞춰주는 코드
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>당신의 이름은 <%= request.getParameter("name") %> 이군요!!</h2>
<h2>요청방식: <%= request.getMethod() %></h2>
<a href="<%= request.getHeader("referer") %>"> 입력 화면으로 </a>
</body>
</html>









