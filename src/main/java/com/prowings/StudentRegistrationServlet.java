package com.prowings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.entity.Student;
import com.prowings.util.HibernateUtils;

public class StudentRegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // Retrieve form data and initialize student object
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        
        //code to save the student object to DB using hibernate
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        session.save(student);
        System.out.println("---- Student Object saved to DB successfully!! ----");
        txn.commit();
        session.close();
        
        // Set response type
        response.setContentType("text/html");

        // Display confirmation page
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Registration Successful!</h1>");
        response.getWriter().println("<p>Name: " + student.getName()+ "</p>");
        response.getWriter().println("<p>Email: " + student.getEmail() + "</p>");
        response.getWriter().println("<p>Age: " + student.getAge() + "</p>");
        response.getWriter().println("</body></html>");
	}
	
}
