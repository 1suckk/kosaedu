package corelab;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8"); //post 방식일 때 꼭 있어야 한다. 안 그러면 한글 값이 출려될 때 다 깨진다
		
		String name = request.getParameter("name");
		String room = request.getParameter("room");
		String option[] = request.getParameterValues("option");
		
		String bookDate = request.getParameter("bookDate");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strNowDate = simpleDateFormat.format(bookDate);
		
		out.print("<h1 style='color:blue'>" + name + "님의 예약 내용" + "</h1>");
		out.print("<hr/>");
		out.print("<ul>선택한 룸: " + room + "</ul>");
		out.print("<ul>추가 요청 사항: ");
		if (option != null && option.length != 0) {
			for(String o : option)
				out.print(o + ",");			
		}
		else {
			out.print("선택 안함");
		}
		out.print("</ul>");
		out.print("<ul>예약날짜: " + strNowDate + "</ul>");
		
		out.close();
	}
}