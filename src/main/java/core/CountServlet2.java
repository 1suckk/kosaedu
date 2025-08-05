package core;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/count2")
public class CountServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int[] count = new int[1];
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		count[0]++;
		out.print("<h1>멤버변수</h1><hr>");		
		out.print("<h3>당신은 "+ count[0] + "번째 방문입니다.</h3>");		
		out.close();
	}
}



