package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/count3")
public class CountServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//1. doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//WAS가 내부적으로 session 객체를 만들어준다
		HttpSession session = request.getSession();
		
		//어떤 브라우저에서 만약 세션 객체가 없다면 숫자 하나인 배열로 그 세션의 cnt라는 속성을 통해서 방문 횟수를 카운팅한다
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]);
		}
		
		//int[]으로 강제 형변환이 된 이유는 브라우저별로 count가 달리 나오기 때문이다
		int[] count = (int[])session.getAttribute("cnt");
		count[0]++;
		
		//이 부분은 각 세션을 가진 브라우저마다 각각 저장이 되는 것이다
		out.print("<h1>세션객체</h1><hr>");	
		out.print("<h3>당신은 "+ count[0] + "번째 방문입니다.</h3>");		
		
		//출력부 닫기
		out.close();
	}
}