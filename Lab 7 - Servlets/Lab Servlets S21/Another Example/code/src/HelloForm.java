// Import required java libraries
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Extend HttpServlet class
public class HelloForm extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
  // Set response content type
  response.setContentType("text/html");

  PrintWriter out = response.getWriter();
  String title = "Using GET/POST Method to Read Form Data";
  String docType =
  "<!doctype html public \"-//w3c//dtd html 4.0 " +
  "transitional//en\">\n";
  out.println(docType +
  "<html>\n" +
  "<head><title>" + title + "</title></head>\n" +
  "<body bgcolor=\"#f0f0f0\">\n" +
  "<h1 align=\"center\">" + title + "</h1>\n" +
  "<ul>\n" +
  "  <li><b>First Name</b>: "
  + request.getParameter("first_name") + "\n" +
  "  <li><b>Last Name</b>: "
  + request.getParameter("last_name") + "\n" +
  "</ul>\n" +
  "</body></html>");
  }
   // Method to handle POST method request.
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
     doGet(request, response);
  }
}
