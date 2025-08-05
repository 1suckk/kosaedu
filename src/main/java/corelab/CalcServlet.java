package corelab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //post 방식일 때 꼭 있어야 한다. 안 그러면 한글 값이 출려될 때 다 깨진다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			int a = Integer.parseInt(request.getParameter("a"));
			int b = Integer.parseInt(request.getParameter("b"));
			String calc = request.getParameter("calc");
			
			int result = 0;
			
			if(calc.equals("+"))
			    result = a + b;
			else if(calc.equals("-"))
			    result = a - b;
			else if(calc.equals("*"))
			    result = a * b;
			else if(calc.equals("/"))
			    result = a / b;
			
			System.out.println("결과값:" + result);
			
			out.print("<h1>GET 방식으로 요청한 사칙 연산</h1>");
			out.print("<hr />");
			out.print("<h2>결과 : "+ result + "</h2>");
			out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로</a>");
		} catch (Exception e) {
			
		} finally {
			out.close();
		}
	}
}