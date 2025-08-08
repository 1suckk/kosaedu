package corelab;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String pid = request.getParameter("pid");
		
		if (pid != null && pid.equals("empty")) {
			session.removeAttribute("cart");
		} else if (pid != null) {
			Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
			if (cart == null) {
				cart = new HashMap<>();
				session.setAttribute("cart", cart);
			}
			cart.put(pid, cart.getOrDefault(pid, 0) + 1);
		}
		
		response.sendRedirect("jspexam/basketResult.jsp");
	}
}