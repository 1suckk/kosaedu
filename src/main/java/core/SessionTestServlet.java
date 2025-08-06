package core;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontest")
public class SessionTestServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//출력부에 대한 설정을 정의; utf-8과 PrintWriter
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 명령의 종류를 쿼리 파라미터로 받아오기
		//2. 세션 객체 새로 생성
		//3. 문자열 형태의 메시지를 초기화("")한다
		String command = request.getParameter("comm");
		HttpSession session = request.getSession();		
		String msg="";
		
		//세션의 시간과 구분하기 위한 id 값을 받아온다.
		long time = session.getCreationTime();
		String id = session.getId();
	    
		//쿼리 파라미터인 명령어가 null이 아니면서 view를 명령어로 가지는 경우
		if(command != null && command.equals("view")) {
			if(session.isNew()) {
				msg = "세션 객체 생성 : "; 
			} else {
				msg = "세션 객체 추출 : "; 
			}
			msg += "<br>id : " + id + " <br>time : " +
			                new Date(time);
		}
		
		//쿼리 파라미터인 멸령어가 null이 아니면서 delete를 명령어로 가지는 경우
		else if (command != null && command.equals("delete")) {
			session.invalidate();
			msg = id + "을 id로 갖는 세션 객체 삭제!!";
		}
		
		//view나 delete가 아닌 경우
		else {
			msg = "요청시 Query 문자열로 comm=view 또는 comm=delete 를 "
					+ "전달해주세요!!";
		}
		
		//메시지를 화면단에 출력
	    out.print("<h2>"+ msg+"</h2>");
		
	    //화면단 출력 종료
	    out.close();
	}
}