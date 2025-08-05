package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empselect")
public class EmpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//1.doGet 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답을 utf-8 로 깨지지 않도록
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//db에 점속하기 전에 드라이버 연결 여부부터 확인; class Not Found 여부 확인
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			response.sendError(500, "JDBC 드라이버가 존재하지 않습니다.");
			return;
		}
		
		//DB 정보
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String passwd = "TIGER";
		
		out.print("<h2>직원명단</h2><hr><ul>");
		
		//쿼리를 실행하고 해당되는 db를 select
		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select ename, sal  from emp");
			)
		{	
			//해당되는 직원이 나올 때까지 html 화면 단에 출력하는 부분
			while (rs.next()) {
				out.printf("<li>%10s (급여: %dUSD)</li>", rs.getString("ename"), rs.getInt("sal"));
			}
			out.print("</ul>");
		}
		//드라이버는 WEB_INF/lib 내부에 존재하지만 DB의 정보가 잘못 입력되었을 때 이러한 메시지가 출력된다
		catch(SQLException e) {
			response.sendError(500, "DB 연동 오류");
			return;	
		}		
	}
}
