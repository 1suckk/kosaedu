<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 결과</title>
</head>
<body>
<%
	// request 객체에 "msg" 라는 이름으로 전달된 객체를 추출하여 출력한다.
	String msg = (String) request.getAttribute("msg");
	out.println("<h2>" + msg + "</h2>");
	
	// request 객체에 "srcinfo” 라는 이름으로 전달된 객체가 있는지 채크하고 있으면
	String srcinfo = (String) request.getAttribute("imginfo");
	if (srcinfo != null) {
		// 이미지를 출력한다.
		out.println("<img src='" + srcinfo + "'>");
	}

	// 실패의 상황에서만 요청 링크를 출력한다.
	//Servlet 코드에서 받아온 실패에 대한 flag를 사용한다.
	Boolean isFail = (Boolean) request.getAttribute("isFail");
	if (isFail != null && isFail) {
		out.println("<p><a href='./lottoForm3.html'>다시 도전</a></p>");
	}
%>
</body>
</html>