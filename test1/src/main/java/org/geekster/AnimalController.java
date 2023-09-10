package org.geekster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.Session;
import java.util.Properties;


@RestController
public class AnimalController {
    @Autowired
    private Dog dog;

    @GetMapping("avi/getDog")
    public String getDog(){
        String dogString=dog.toString();

        sendEmail("Dog as a String", dogString);
        return dogString;
    }

    private void sendEmail(String dogAsAString, String dogString) {
        String fromEmail = "singh.ankit424@gmail.com";
        String password = "zooywyshmurjymyp";

        // Recipient's email address
        String toEmail = "singh.ankit424@gmail.com";

        // Setup mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");

        // Create a session with the Gmail SMTP server
        Session mailSession = Session.getInstance(sysPropertiesMap, mailAuthenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setSubject("Geekster Mailing class");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("singh.ankit424@gmail.com"));
            mailMessage.setText("Mainak is trying to teach mailing through java!!!");

            Transport.send(mailMessage);

            System.out.println("Mail sent !!!");
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }

    }



}
