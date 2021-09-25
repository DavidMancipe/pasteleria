/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emails;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author usuario
 */
public class Email {
    
    public void enviarCorreo()  throws AddressException, MessagingException {
//        int documento = current.getIdCiudades();
        
        String correoRemitente = "jrcastellanos20@misena.edu.co";
        String passwordRemitente = "";
        String correoDestino = "richarmoreno001@gmail.com";        
        
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", correoRemitente);
        props.put("mail.smtp.clave", passwordRemitente);
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        String asunto = "Registro en el sistema de información GAES12";
        String mensaje = "Mensaje de prueba para el GAES12";

        try {
//            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
            message.setSubject(asunto);
            message.setText(mensaje); // , "ISO-8859-1", "html"

            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("Mensaje enviado");
        } catch (Exception e) {
            System.out.println("Error = " + e);
        }
    }

}
