package com.prowings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetrieveStudent")
public class RetrieveStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the roll number from the query string
        String rollNumber = request.getParameter("rollNumber");

        // Set the content type for the response
        response.setContentType("text/html");

        // Output the roll number to the response
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Retrieve Student Info</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Retrieve Student Info</h1>");
        if (rollNumber != null && !rollNumber.isEmpty()) {
            response.getWriter().println("<p>Roll Number: " + rollNumber + "</p>");
            // You can add logic here to fetch student details from a database using the roll number
            response.getWriter().println("<p>Name: " + "Shri Ram" + "</p>");
            response.getWriter().println("<p>Email: " + "shri.ram@gmail.com" + "</p>");
            response.getWriter().println("<p>Age: " + 34 + "</p>");

        } else {
            response.getWriter().println("<p>No roll number provided!</p>");
        }
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

	
}
