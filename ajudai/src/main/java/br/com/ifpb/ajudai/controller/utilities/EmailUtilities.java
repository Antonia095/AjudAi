package br.com.ifpb.ajudai.controller.utilities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailUtilities {
    private InputStream input;
    private Properties propertiesFile;
    private String assuntoMensagem;
    private String corpoMensagem;

    public EmailUtilities(String codigo){
        this.input = EmailUtilities.class.getClassLoader().getResourceAsStream("configuration/config" +
                ".properties");
        propertiesFile = new Properties();
        assuntoMensagem = "Código de Acesso" ;
        corpoMensagem = "<h3>Seu código de acesso é " +codigo.toUpperCase()+"</h3>";
    }

    public void enviarEmail(String destinatario) throws IOException{
        Properties props = new Properties();
        propertiesFile.load(input);

        props.put(propertiesFile.get("email.ajudai.host"), propertiesFile.getProperty("email.ajudai.tipo"));
        props.put(propertiesFile.get("email.ajudai.socketPort"), Integer.parseInt(propertiesFile.getProperty("email.ajudai.valPort")));
        props.put(propertiesFile.getProperty("email.ajudai.socketClass"), propertiesFile.getProperty("email.ajudai.ssl"));
        props.put(propertiesFile.getProperty("email.ajudai.auth"), true);
        props.put(propertiesFile.getProperty("email.ajudai.port"), Integer.parseInt(propertiesFile.getProperty("email.ajudai.valPort")));

        Session session = Session.getDefaultInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(propertiesFile.getProperty("email.ajudai.email"),
                        propertiesFile.getProperty("email.ajudai.senha"));
            }
        });

        try{
            MimeMessage mensagem = new MimeMessage(session);
            mensagem.setFrom(new InternetAddress(propertiesFile.getProperty("email.ajudai.email")));
            mensagem.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensagem.setSubject(assuntoMensagem); //Assunto da mensagem
            mensagem.setText(corpoMensagem,"utf-8","html"); //Corpo da mensagem

            Transport.send(mensagem);

        }catch (MessagingException e){
            e.printStackTrace();
        }


    }
}
