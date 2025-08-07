package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CountDto;

@WebServlet("/sharetest1")
public class ShareServletTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num")); //쿼리 스트링을 파라미터로 받아오는 부분
		CountDto dto = new CountDto();
		
		dto.setNumber(param);
		
		request.setAttribute("objreq", dto); //참조값이 보관됨
		request.getRequestDispatcher("/jspexam/share1.jsp").forward(request, response);
	}
}