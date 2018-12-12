import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        String title = "Info";
        Date dateNow = new Date();
        SimpleDateFormat DateNow = new SimpleDateFormat(" ' Date:'  yyyy.MM.dd ");
        SimpleDateFormat TimeNow = new SimpleDateFormat(" ' Time:' hh:mm:ss ");
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title><style type=\"text/css\">\n" +
                " p {\n" +
                "    font-family: Helvetica, sans-serif;\n" +
                "    font-size: 16pt;\n" +
                "    font-weight: bold;\n" +
                "    color: #0C898B" +
                "}" +
                "  </style></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<p align = \"center\">" +
                DateNow.format(dateNow) + "<br>" + TimeNow.format(dateNow) + "<br>" + "<br>" +
                "<img src=\"pc.png\">" + "<br>" + "<br>" +
                "Your browser: " + "<br>" +
                 req.getHeader("User-Agent") + "</p>" +
                "</body>" +
                "</html>"
        );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
