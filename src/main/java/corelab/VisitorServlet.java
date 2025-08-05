package corelab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/visitorServlet")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8"); //post 방식일 때 꼭 있어야 한다. 안 그러면 한글 값이 출려될 때 다 깨진다
		
		String userName = request.getParameter("guestname");
		String content = request.getParameter("content");
	
		LocalDate now = LocalDate.now();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		
		out.print("<h1>" + userName + "님이 " + year + "년 " 
					+ month + "월 " + day
					+ "일에 남긴 글입니다.</h1>");
		out.print("<hr/>");
		out.print("<h2>" + content + "</h2>");
		
		out.close();
	}

}
