package com.servlet.operationToPerform;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.implementationOfEmployee.EmployeeServiceImplementation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private static void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Set content type to HTML
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Start HTML document and add CSS for vertical layout & message box
        out.print("<!DOCTYPE html>");
        out.print("<html><head><title>Delete Result</title>");
        out.print("<style>");
        out.print("body {"
                + "display: flex;"
                + "flex-direction: column;"
                + "align-items: center;"
                + "justify-content: flex-start;"
                + "font-family: Arial, sans-serif;"
                + "background-color: #f9f9f9;"
                + "padding-top: 30px;"
                + "margin: 0;"
                + "}");
        out.print(".message-box {"
                + "background: #fff;"
                + "border-radius: 8px;"
                + "box-shadow: 0 2px 8px rgba(0,0,0,0.1);"
                + "padding: 20px 40px;"
                + "margin-bottom: 30px;"
                + "max-width: 500px;"
                + "width: 100%;"
                + "text-align: center;"
                + "}");
        out.print(".message-box h2 { margin: 0; }");
        out.print("</style>");
        out.print("</head><body>");

        // Message box container
        out.print("<div class='message-box'>");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int deleteData = new EmployeeServiceImplementation().deleteData(id);

            if (deleteData > 0) {
                out.print("<h2 style='color: green;'>Data Deleted Successfully.</h2>");
            } else {
                out.print("<h2 style='color: red;'>Employee with ID " + id + " Not Found Or Not Available.</h2>");
            }
        } catch (NumberFormatException e) {
            out.print("<h2 style='color: red;'>Invalid ID format. Please enter a valid number.</h2>");
        } catch (Exception e) {
            out.print("<h2 style='color: red;'>An unexpected error occurred: " + e.getMessage() + "</h2>");
        }

        out.print("</div>"); // Close message box

        // Include your index.html below message box
        request.getRequestDispatcher("index.html").include(request, response);

        out.print("</body></html>");
    }
}
