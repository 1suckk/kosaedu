package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL 매핑 정보
@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//클래스 전체에서 사용할 수 있는 변수;
	//새로고침을 할 수록 증가한다;
	//non-static 멤버변수는 객체 생성 시 메모리 할당 -> 사라지기 전까지는 유지가 된다;
	int member_v = 0; 

	//1. doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int local_v = 0; //새로고침을 몇번을 하던지 언제나 0에서 1로 증가한다
		member_v++;
		local_v++;
		
		//out.print() 메서드는 브라우저 화면단에 렌더링할 html 태그를 담는다.
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}
}