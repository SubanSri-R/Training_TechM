package javaservelet;	

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/display")  
public class Display extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Simple Servlet Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, welcome to my Servlet!</h1>");
        out.println("<p>This is a simple Java Servlet that displays HTML content.</p>");
        out.println("<p>Today's date: " + new java.util.Date() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}


