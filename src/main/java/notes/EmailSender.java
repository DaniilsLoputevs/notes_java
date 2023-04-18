package notes;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.val;

public class EmailSender {
//    private static final String FROM = "alenkayledark@gmail.com";
//private static final String FROM = "lev-vel_01@mail.ru";
    private static final String FROM = "sirenj97@gmail.com";
//    private static final String PASSWORD = "ippyZDB8ixzgsXeyVaj2";
    private static final String PASSWORD = "edlrnbiayhgbfxak";
//    private static final Authenticator AUTHENTICATOR = new AuthenticatorMy(FROM, "hellsing1712");
//    private static final Authenticator AUTHENTICATOR = new AuthenticatorMy(FROM, "deTM2yPyuqT8zguyDnxk");
    private static final Authenticator AUTHENTICATOR = new AuthenticatorMy(FROM, PASSWORD);
    
//    public static void main(String[] args) {
//
//        // Sender's email ID needs to be mentioned
//        String from = FROM;
//
//        // Recipient's email ID needs to be mentioned.
//        String to = "laiwiense@gmail.com";
//
//
//        // Assuming you are sending email from through gmails smtp
//        String host = "smtp.gmail.com";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        // Get the Session object.// and pass username and password
//        Session session = Session.getInstance(properties, AUTHENTICATOR);
//
//        // Used to debug SMTP issues
//        session.setDebug(true);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
////            InternetAddress a[] = parse(address, true);
////            val o = a[1];
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("This is the Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            System.out.println("sending...");
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//
//    }
    
    
//
//    public static void main(String[] args) {
//        String from = "alenkayledark@gmail.com"; //change accordingly
//        String to = "alenkayledark@gmail.com"; //change accordingly
//        String host = "smtp.gmail.com"; //or IP address
//
//        //Get the session object
//        val properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//        val session = Session.getDefaultInstance(properties, AUTHENTICATOR);
//        session.setDebug(true);
//
//        //compose the message
//        try {
//            val message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("Ping");
//            message.setText("Hello, this is example of sending email  ");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("message sent successfully....");
//
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
    
    public static void main(String[] args) {
        String from = FROM; //change accordingly
        String to = FROM; //change accordingly
//        String host = "smtp.mail.ru"; //or IP address
        String host = "smtp.gmail.com"; //or IP address

        //Get the session object
        val properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.user", FROM);
    
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", 465);
//        props.put("mail.smtp.socketFactory.port", 465);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
        
        val session = Session.getDefaultInstance(properties, AUTHENTICATOR);
//        val session = Session.getDefaultInstance(properties, AUTHENTICATOR);
        session.setDebug(true);
        
        //compose the message
        try {
            val message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");
            
            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private static class AuthenticatorMy extends Authenticator {
        private final String email, password;
    
        public AuthenticatorMy(String email, String password) {
            this.email = email;
            this.password = password;
        }
        @Override protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(email, password);
        }
    }
}
