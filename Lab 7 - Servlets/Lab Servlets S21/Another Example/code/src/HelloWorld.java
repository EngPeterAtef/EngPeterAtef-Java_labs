import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
  // Set response content type
  //response.setContentType("text/html");

  // Actual logic goes here.
  PrintWriter out = response.getWriter();
  out.println("<h1>Hello World</h1>");
  out.println("<p>This is our first servlet application</p>");

  }

}
