package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CountDto;

@WebServlet("/sharetest3")
public class ShareServletTest3 extends HttpServlet {
	//doGet() 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int param = Integer.parseInt(request.getParameter("num")); //쿼리 스트링을 파라미터로 받아오는 부분
		ServletContext context = getServletContext();
		
		//세션이 톰캣에 보관되어 있지 않은 경우 dto에 할당
		if(context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountDto());
		}
		
		CountDto dto = (CountDto)context.getAttribute("objapp");
		dto.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share3.jsp").forward(request, response);
	}
}