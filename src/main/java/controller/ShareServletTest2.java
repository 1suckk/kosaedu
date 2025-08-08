package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CountDto;

@WebServlet("/sharetest2")
public class ShareServletTest2 extends HttpServlet {
	//doGet() 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int param = Integer.parseInt(request.getParameter("num")); //쿼리 스트링을 파라미터로 받아오는 부분
		HttpSession session = request.getSession();
		
		//세션이 톰캣에 보관되어 있지 않은 경우 dto에 할당
		if(session.getAttribute("objsession") == null) {
			session.setAttribute("objsession", new CountDto());
		}
		
		CountDto dto = (CountDto)session.getAttribute("objsession");
		dto.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share2.jsp").forward(request, response);
	}
}