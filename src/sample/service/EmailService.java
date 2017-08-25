package sample.service;



import java.io.IOException;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@SuppressWarnings("serial")
public class EmailService extends HttpServlet {
 
    protected static void send(String to , String message) {
       
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
 
     
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("teambob.cloud@gmail.com",
                    "HealthPlus Admin"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                   to));
            msg.setSubject("Notification");
            msg.setText(message);
            Transport.send(msg);
 
        } catch (Exception e) {
          
            throw new RuntimeException(e);
        }
 
    }
}