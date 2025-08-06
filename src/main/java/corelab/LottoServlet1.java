package corelab;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	
	//1. doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//랜덤값을 생성하기
		Random r = new Random();
		//1부터 6까지의 값을 불러오기 위해 Random 객체에서 nextInt를 사용
		int rnd = r.nextInt(6)+1;
		
		//입력값을 받아오기
		int input = Integer.parseInt(request.getParameter("input"));
		
		//동일할 경우에 포워드
		if (rnd == input)
		{
			RequestDispatcher rd = request.getRequestDispatcher("./success.html");
			rd.forward(request, response);
		}
		
		//동일하지 않은 경우, 즉 실패한 경우 포워드
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("./fail.html");
			rd.forward(request, response);
		}
		
		//서버 콘솔에 전달된 값과 랜덤으로 추출된 값을 전달
		System.out.println("전달된 값: " + input + ", " + "추출된 값: " + rnd);
	}
}
