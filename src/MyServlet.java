import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    String password = "javarulit";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        String title = "Login page";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        if( password.equals(req.getParameter("password"))) {
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<p align = \"center\"> Hello "
                    + "<b>" + req.getParameter("login") + "</b>" + " how are you?" + "<br>" +
                    "You know the correct password: "
                    + "<b>" + req.getParameter("password") + "</b>" + "</p>" +
                    "</body>" +
                    "</html>"
            );
        }else{
            title ="THIS PASSWORD IS INCORRECT!";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<p align =\"center\"><img  src=\"image.jpg\"></p>" +
                    "</body>" +
                    "</html>"
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
