package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querypost") 
public class QueryServletPost extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //다른 부분	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>요청 데이터 추출(POST)</h1>"); 
		
		request.setCharacterEncoding("utf-8"); //post 방식일 때 꼭 있어야 한다. 안 그러면 한글 값이 출려될 때 다 깨진다
		
		String userName = request.getParameter("guestname");
		String strNum = request.getParameter("num");
		String food[] = request.getParameterValues("food");
		
		if (food != null && food.length != 0) {
			out.print("<h2>좋아하는 음식</h2>");
			out.print("<ul>");
			for(String f : food)
				out.print("<li>"+f+"</li>");
			out.print("</ul>");			
		}
		else {
			out.print("<h2>좋아하는 음식이 없군요</h2>");
		}
		
		out.print("<h2>요청 방식 : " + request.getMethod() + "</h2>");
		out.print("<h2>요청 URI : " + request.getRequestURI() + "</h2>");
		out.print("<h2>당신의 이름은 "+
		                  userName+"이군요!</h2>");
		out.print("<h2>당신이 좋아하는 숫자는 "+
                strNum+"이군요!</h2>");
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		
		out.close();
	}
}



