package com.servlet.operationToPerform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.implementationOfEmployee.EmployeeServiceImplementation;
import com.servlet.interfaceOperation.Employee;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
										throws ServletException, IOException
	{
		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
										throws ServletException, IOException 
	{
		processRequest(request, response);
	}
	
	private static void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    // Begin HTML
	    out.print("<!DOCTYPE html>");
	    out.print("<html><head><title>Insert Result</title>");

	    // Inline CSS to center items vertically
	    out.print("<style>");
	    out.print("body { display: flex; flex-direction: column; align-items: center; justify-content: center; font-family: Arial; background-color: #f5f5f5; }");
	    out.print(".message { margin: 20px auto; padding: 20px 40px; background: white; border-radius: 10px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }");
	    out.print("</style>");

	    out.print("</head><body>");

	    // Success message block
	    out.print("<div class='message'>");

	    String name = request.getParameter("name");
	    String idStr = request.getParameter("id");
	    String aadhar = request.getParameter("aadhar");

	    try {
	        int id = Integer.parseInt(idStr);

	        if ((name != null && !name.isBlank()) && (aadhar != null && !aadhar.isBlank())) {
	            boolean flag = new EmployeeServiceImplementation().insertData(new Employee(name, id, aadhar));

	            if (flag) {
	                out.print("<h2 style='color: green;'>Data Inserted Successfully.</h2>");
	            } else {
	                out.print("<h2 style='color: red;'>Something went wrong while inserting data.</h2>");
	            }

	        } else {
	            out.print("<h2 style='color: red;'>Name or Aadhar number cannot be empty or null.</h2>");
	        }

	    } catch (NumberFormatException e) {
	        out.print("<h2 style='color: red;'>Invalid ID format. Please enter a numeric value.</h2>");
	    } catch (Exception e) {
	        out.print("<h2 style='color: red;'>Unexpected error: " + e.getMessage() + "</h2>");
	    }

	    out.print("</div>"); // Close message

	    // Include index.html right after message block
	    request.getRequestDispatcher("index.html").include(request, response);

	    out.print("</body></html>");
	}

}
