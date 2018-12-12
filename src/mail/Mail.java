package mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mail {
    private Message message;
    private static  String   server    = "smtp.gmail.com";
    private static  String   port      = "465";
    private static  String   from =  "testalexalex9918@gmail.com";
    private static  String   user = "testalexalex9918";
    private static  String   password = "poiuytrewq0987654321";

    private static  String   file     = null;

    public static void setFile(String file) {
        if(!"".equals(file))
        Mail.file = file;
    }

    public Mail(final String emailTo, final String thema)
    {
        // Настройка SMTP SSL
        Properties properties = new Properties();
        properties.put("mail.smtp.host", server);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");
        //properties.put("mail.smtp.starttls.enable","true");
        try {

            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,password);
                }
            };
            Session session = Session.getDefaultInstance(properties,auth);
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("m4lckin.d@yandex.ru"));
            message.setSubject(thema);
        } catch (AddressException e) {
            System.err.println(e.getMessage());
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        }
    }
    private MimeBodyPart createFile(String filepath) throws MessagingException
    {
        MimeBodyPart mbp = new MimeBodyPart();

        FileDataSource fds = new FileDataSource(filepath);
        mbp.setDataHandler(new DataHandler(fds));
        mbp.setFileName(fds.getName());
        return mbp;
    }

    public boolean sendMessage (final String text)
    {
        boolean result = false;
        try {

            Multipart mmp = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(text, "text/plain; charset=utf-8");
            mmp.addBodyPart(bodyPart);

            if (file != null) {
                MimeBodyPart mbr = createFile(file);
                mmp.addBodyPart(mbr);
            }

            message.setContent(mmp);
            Transport.send(message);
            result = true;

        } catch (MessagingException e){
            System.err.println(e.getMessage());
        }
        return result;
    }
}

