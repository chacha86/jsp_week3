package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		
		String[] colors = {"blue", "brown", "cyan", "green", "indigo", "lime", "pink", "red"};
		//구구단
		out.println("====== <h1>구구단</h1> =======<br>");
		for(int i = 2; i <= 9; i++) {
			
			out.println("<div style='background: " + colors[i - 2]+ "'>");
			for(int j = 1; j <= 9; j++) {
				out.println(i + " X " + j + " = " + i * j + "<br>");
			}
			out.println("</div>");
		}
	}
}
