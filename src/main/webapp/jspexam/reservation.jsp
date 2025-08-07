<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP실습1</title>
</head>
<body>
	<%
	response.setContentType("text/html;charset=utf-8");
	
	request.setCharacterEncoding("utf-8"); //post 방식일 때 꼭 있어야 한다. 안 그러면 한글 값이 출려될 때 다 깨진다
	
	String name = request.getParameter("name");
	String room = request.getParameter("room");
	String option[] = request.getParameterValues("option");
	
	String bookDate = request.getParameter("bookDate");
	%>
	
	<h1 style="color: blue"><%= name %>님의 예약 내용</h1>
	<hr />
	<ul>선택된 룸: <%= room %></ul>
	<ul>
		추가 요청 사항: <%
		if (option != null && option.length != 0) {
			for(String o : option)
				out.print(o + " ");			
		}
		else {
			out.print("선택 안함");
		}
		%>
	</ul>
	<ul>예약 날짜: <%= bookDate %> </ul>
	
</body>
</html>