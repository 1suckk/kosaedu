package corelab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	
	//1. doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//파라미터 만들기
		String action = request.getParameter("action");
		
		if("naver".equals(action))
			response.sendRedirect("https://www.naver.com");
		else if("daum".equals(action))
			response.sendRedirect("https://www.daum.net");
		else if("google".equals(action))
			response.sendRedirect("https://www.google.com");
		else
			out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니다.</h2>");
			System.out.println("쿼리값: " + action);
		
		out.close();	
	}
}