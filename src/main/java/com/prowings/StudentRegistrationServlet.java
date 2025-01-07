package com.prowings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        // Set response type
        response.setContentType("text/html");

        // Display confirmation page
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Registration Successful!</h1>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Age: " + age + "</p>");
        response.getWriter().println("</body></html>");

		
	}

	
	
}
