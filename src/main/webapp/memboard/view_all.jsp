<%@page import="db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버관리시스템</title>
</head>
<body>
	<%-- index.jsp 페이지 포함 --%>
	<jsp:include page="index.jsp"/>
	
	<br> <hr> <br>
	
	<%-- DB 사용 준비 --%>
	<%
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		conn = DBConnect.getConnection();

		String sql = "select * from member";
		
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	%>
	
    <%-- HTML 화면 처리 --%> 
	<h1 style = "text-align:center" >member 테이블의 전체 데이터</h1>
	<table>
		<thead>
			<tr>
				<th>회원번호</th> 
				<th>아이디</th> 
				<th>비밀번호</th> 
				<th>이름</th> 
				<th>나이</th> 
				<th>주소</th> 
				<th>가입일</th> 
			</tr>
		</thead>
		<tbody>
	 		<tr>
            	<%-- 조건문으로 처리할 데이터가 없다면 없음을, 있으면 데이터를 가져와 출력 --%>
	 			<%if(!rs.next()){ %>
	 				<td colspan="7">member 데이터가 없습니다.</td>
	 			<%}else{
	 				do{%>
	 					<tr>
	 						<td><%= rs.getInt(1) %> </td>			
	 						<td><%= rs.getString(2) %> </td>			
	 						<td><%= rs.getString(3) %> </td>			
	 						<td><%= rs.getString(4) %> </td>			
	 						<td><%= rs.getInt(5) %> </td>			
	 						<td><%= rs.getString(6) %> </td>			
	 						<td><%= rs.getDate(7) %> </td>			
	 					</tr>
	 				<%}while(rs.next());%>
	 			<%}%>
	 		</tr>
		</tbody>
	</table>
	<%		
	// 예외 처리
	} catch (Exception e) {
		e.printStackTrace();	
		try {
			conn.rollback();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}finally {
		try {
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	%>
</body>
</html>