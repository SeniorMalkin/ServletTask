package mail;

import mail.Mail;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Mail mail = new Mail(req.getParameter("email"),req.getParameter("subject"));
        Mail.setFile(req.getParameter("file"));
        mail.sendMessage(req.getParameter("text"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
