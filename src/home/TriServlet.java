package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tri")
public class TriServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int height = Integer.parseInt(request.getParameter("height"));
		
		for(int i = 1; i <= height; i++) {
			int space = height - i;
			
			for(int j = 0; j < space; j++) {
				out.println("&nbsp");
			}
			
			for(int j = 0; j < i; j++) {
				out.println("*");
			}
			out.println("<br>");
		}
		
	}

}
