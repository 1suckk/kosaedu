<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 결과</title>
</head>
<body>
<%
	Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
	if (cart == null || cart.isEmpty()) {
%>
	<h1>선택한 상품이 없어요.</h1><br>
	<a href="../clientexam/productlog.html">상품선택하기</a>
<%
	}
	else
	{
%>

<h1>선택한 상품 리스트</h1><hr>
	<ul>
	<%
		Set<String> keys = cart.keySet();
		for(String key : keys) {
			out.println("<li>" + key + " 상품 " + cart.get(key) + "개</li>");
		}
	%>
	</ul>
	<br>
	<a href="/sedu/basket?pid=empty">상품비우기</a><br>
	<a href="../clientexam/productlog.html">상품선택하기</a>
<%
	}
%>
</body>
</html>