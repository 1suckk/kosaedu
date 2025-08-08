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

	//카트가 비워져 있을 때는
	if (cart == null || cart.isEmpty()) {
%>
	<h1>선택한 상품이 없어요.</h1><br>
	<a href="../clientexam/productlog.html">상품선택하기</a>
<%
	}
	
	//카트에 하나 이상의 제품이 채워져 있을 때에
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
	<!--
	html 경로가 webapp->clientexam->productlog.html 이기 때문에,
	현재 경로인 webapp->jspexam->basketResult.jsp에서는 
	../clientexam/productlog.html으로 표현해야 매핑이 된다
	../은 이전 디렉토리이므로 여기서는 jspexam의 직전 디렉토리인 webapp이다.
	-->
	<a href="../clientexam/productlog.html">상품선택하기</a>
<%
	}
%>
</body>
</html>