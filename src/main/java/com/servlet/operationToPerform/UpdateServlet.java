package com.servlet.operationToPerform;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.implementationOfEmployee.EmployeeServiceImplementation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}
	
	private static void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {

	    // Set the response content type to HTML
	    response.setContentType("text/html");
	    
	    // Get the PrintWriter to write the HTML response
	    PrintWriter out = response.getWriter();

	    // Start the HTML document and include CSS styles for layout and message box
	    out.print("<!DOCTYPE html>");
	    out.print("<html><head><title>Update Result</title>");
	    out.print("<style>");
	    // Body uses flexbox for vertical stacking and centering
	    out.print("body { display: flex; flex-direction: column; align-items: center; justify-content: flex-start; "
	            + "font-family: Arial, sans-serif; background-color: #f9f9f9; padding-top: 30px; }");
	    // Style for the message container box
	    out.print(".message-box { background: #fff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); "
	            + "padding: 20px 40px; margin-bottom: 30px; max-width: 500px; width: 100%; text-align: center; }");
	    out.print(".message-box h2 { margin: 0; }");
	    out.print("</style>");
	    out.print("</head><body>");

	    // Start message box container
	    out.print("<div class='message-box'>");

	    try {
	        // Parse the 'id' parameter from request
	        int id = Integer.parseInt(request.getParameter("id"));

	        // Get the old and new Aadhar numbers from the request
	        String oldAadhar = request.getParameter("oldaadhar");
	        String newAadhar = request.getParameter("newaadhar");

	        // Validate old Aadhar number is not null or blank
	        if (oldAadhar != null && !oldAadhar.isBlank()) {
	            // Call the update method from service layer
	            boolean flag = new EmployeeServiceImplementation().updateData(id, oldAadhar, newAadhar);

	            // Show success message if update was successful
	            if (flag) {
	                out.print("<h2 style='color: green;'>Data Updated Successfully.</h2>");
	            } else {
	                // Show failure message if update did not succeed
	                out.print("<h2 style='color: red;'>Something went wrong while updating data.</h2>");
	            }
	        } else {
	            // Show validation error if old Aadhar is empty or null
	            out.print("<h2 style='color: red;'>Old Aadhar Number cannot be empty or null.</h2>");
	        }
	    } catch (NumberFormatException e) {
	        // Handle error if 'id' parameter is not a valid integer
	        out.print("<h2 style='color: red;'>Invalid ID format. Please enter a valid number.</h2>");
	    } catch (Exception e) {
	        // Catch any unexpected exceptions and display a message
	        out.print("<h2 style='color: red;'>An unexpected error occurred: " + e.getMessage() + "</h2>");
	    }

	    // Close the message box container div
	    out.print("</div>");

	    // Include the content of index.html below the message box
	    request.getRequestDispatcher("index.html").include(request, response);

	    // Close body and html tags
	    out.print("</body></html>");
	}

}
