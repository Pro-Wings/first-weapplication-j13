package com.prowings;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.entity.Student;
import com.prowings.util.HibernateUtils;

@WebServlet("/RetrieveStudent")
public class RetrieveStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the roll number from the query string
        String rollNumber = request.getParameter("rollNumber");

        System.out.println("Received request to fetch details of id : "+rollNumber);
        
        // Set the content type for the response
        response.setContentType("text/html");

        if (rollNumber != null && !rollNumber.isEmpty()) {

            SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction txn = session.beginTransaction();
            Student fetchedStudent = session.get(Student.class, Long.parseLong(rollNumber));
            System.out.println("---- Fetched Student object from DB successfully!! ----");
            System.out.println(fetchedStudent);
            txn.commit();
            session.close();

            // Set the student object as a request attribute
            request.setAttribute("student", fetchedStudent);

            // Forward the request back to register.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentRegistration.jsp");
            dispatcher.forward(request, response);
        	
        } else {
            response.getWriter().println("<p>No roll number provided!</p>");
        }
    }

	
}
