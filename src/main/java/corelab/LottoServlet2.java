package corelab;

import java.io.IOException;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	//1. doGet() 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-1. 랜덤 추출 수에 대한 객체 생성
		Random r = new Random();
		//1부터 6까지의 랜덤 수 rnd 변수 생성
		int rnd = r.nextInt(6) + 1;
		
		//1-2. 세션을 새로 생성하고 관리하기 위한 객체 생성
		HttpSession session = request.getSession();
		
		// 세션에 "cnt" 속성이 없을 경우, int 타입 0으로 초기화합니다.
		//setAttribute 메서드를 이ㅛㅇㅇ하여 각 브라우저의 세션 호출 횟수를 저장한다.
		if (session.getAttribute("cnt") == null)
			session.setAttribute("cnt", new int[1]);
		
		// 세션에서 카운트 값을 가져와 Integer로 형변환합니다.
		// 이전 코드가 배열이었던 문제를 해결하기 위해 타입을 Integer로 통일합니다.
		int[] count = (int[]) session.getAttribute("cnt");
		count[0]++;
		
		int input = Integer.parseInt(request.getParameter("input"));
		
		//호출되는 카운트 수를 서버 console에서 보기 위한 로그
		System.out.println("전달된 값: " + input + ", " + "추출된 값: " + rnd + " 호출된 횟수: " + count[0]);
		
		// 카운트가 4 이상일 경우(4회차부터) impossible.html로 포워드합니다.
		if (count[0] > 3)
		{
			RequestDispatcher rd = request.getRequestDispatcher("./impossible.html");
			rd.forward(request, response);
		}
		
		// 카운트가 4가 되기 이전 rnd와 input을 비교하는 부분
		else
		{
			//같으면 성공 창으로 포워드
			if (rnd == input)
			{
				RequestDispatcher rd = request.getRequestDispatcher("./success.html");
				rd.forward(request, response);
			}
			
			//다르면 실패 창으로 포워드
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("./fail.html");
				rd.forward(request, response);
			}
		}
	}
}