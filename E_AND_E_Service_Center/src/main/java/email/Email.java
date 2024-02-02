package email;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class Email {
    private static Email email;
    private Session session;
    private Email(){

    }
    public static Email getInstance(){
        return email!=null ? email:(email=new Email());
    }
    public Session getSession(){
        return session!=null ? session : (session=createSession());
    }
    private Session createSession(){
        // SMTP server configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Sender and recipient configuration
        String senderEmail = "2021physicsclass@gmail.com";
        String senderPassword = "2001Thimira";

        // Create a session with the SMTP server
        return session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });
    }
}