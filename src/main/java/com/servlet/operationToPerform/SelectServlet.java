package com.servlet.operationToPerform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.servlet.implementationOfEmployee.EmployeeServiceImplementation;
import com.servlet.interfaceOperation.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet mapped to /SelectServlet URL for selecting/displaying employee data
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Handles POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Common method to process both GET and POST requests
    private static void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Set content type to HTML
        response.setContentType("text/html");
        
        // Get the PrintWriter to write response content
        PrintWriter out = response.getWriter();

        // Write the HTML page structure and include inline CSS styles
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>User Management System</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; "
                + "display: flex; flex-direction: column; align-items: center; padding-top: 50px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println("table { border-collapse: collapse; width: 50%; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ccc; padding: 12px; text-align: center; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
        out.println(".btn { margin-top: 30px; text-decoration: none; padding: 10px 20px; "
                + "background-color: #007BFF; color: white; border-radius: 6px; display: inline-block; }");
        out.println(".btn:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Fetch the list of Employee objects from the service layer
        List<Employee> empList = new EmployeeServiceImplementation().selectData();

        // Check if list contains any records
        if (!empList.isEmpty()) {
            out.println("<h3>Employee Details :</h3>");
            
            // Build the HTML table headers
            out.println("<table border='2'>");
            out.println("<tr><th>Name</th><th>ID</th><th>AdharNo</th></tr>");
            
            // Iterate over the list and add each employee as a row in the table
            for (Employee emp : empList) {
                out.println("<tr>");
                out.println("<td>" + emp.getName() + "</td>");
                out.println("<td>" + emp.getId() + "</td>");
                out.println("<td>" + emp.getAadharNo() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            // Display message if no employee records found
            out.print("<h4>No records are there</h4>");
            
            // Include the index.html page content below the message
            request.getRequestDispatcher("index.html").include(request, response);
        }

        // Add a "Back to Home" button linking to the index page
        out.println("<a class='btn' href='index.html'>Back to Home</a>");

        // Close body and html tags
        out.println("</body>");
        out.println("</html>");
    }
}
