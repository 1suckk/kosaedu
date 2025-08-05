package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/count1")
public class CountServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//1. doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); //html 화면단에 출력하기 위한 객체 새롭게 생성
		
		//요소가 한 개 뿐인 배열을 count 라는 이름으로 생성
		int[] count = new int[1];
		count[0]++; //지역변수이기 때문에 doGet 메서드가 호출될 때마다 0으로 초기화된다
		
		//출력부
		out.print("<h1>지역변수</h1><hr>");		
		out.print("<h3>당신은 "+ count[0] + "번째 방문입니다.</h3>");		
		//출력 닫기
		out.close();
	}
}



