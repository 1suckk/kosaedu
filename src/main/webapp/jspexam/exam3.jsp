<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현식 태그 점검</h1>
<hr>
<%--지역 변수 --%>
<% int num = 10; %>
<ul>
	<%-- (<%= %>으로 된 부분은 표현식 태그에 해당한다 --%>
	<%-- 100이 그대로 출력이 된다 --%>
	<li><%= 100 %></li>
	
	<%-- 지역 변수인 10이 나온다 --%>
	<li><%= num %></li>
	<%-- 다음 행에서 11이 된다 --%>
	<li><%= ++num %></li>
	<%-- 11의 2배인 22 --%>
	<li><%= num*2 %></li>
	<%-- 세 글자이므로 3이 나온다 --%>
	<li><%= "가나다".length() %></li>
	<%-- num은 11이므로 2로 나눴을 때 1이므로 0이라고 비교한 해당 문장은 false  --%>
	<li><%= num % 2 == 0 %></li>
	
	<%-- 쿼리 파라미터를 받아와서 보여주는 부분
	쿼리문자열을 경로에서 부여하면 해당 이름이 출력이 되고
	그게 아니면 null로 나온다 --%>
	<li><%= request.getParameter("stname") %></li>
	<%-- 세션을 부여받은 시간을 출력 
	서블릿에서와 다르게 HttpSession에서 새로 선언할 필요 x--%>
	<li><%= new java.util.Date(session.getCreationTime()) %></li>
	
	<%-- 서버의 종류와 버젼을 출력 --%>
	<li><%= application.getServerInfo() %></li>
	<%-- 현재 수행중인 프로젝트의 상위 path --%>
	<li><%= application.getContextPath() %></li>
</ul>
</body>
</html>