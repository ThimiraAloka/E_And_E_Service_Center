package controller;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Setter;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
@Setter
public class PasswordFormController {


    public JFXTextField txtEmail;
    public JFXTextField txtOTP;
    public AnchorPane panePswrd;

    //private String otpCode;

    @FXML
    void backLogInButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) panePswrd.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void checkOTPButtonOnAction(ActionEvent event) {

    }

    @FXML
    void sendOTPButtonOnAction(ActionEvent event) {

    }

//    public void genOtp(){
//        Random random=new Random();
//        otpCode.setText(""+random.nextInt(1000+1));
//    }
//
//    public void sendOtp(){
//        Properties props=new Properties();
//        props.put("mail.smtp.host","smtp.gmail.com");
//        props.put("mail.smtp.port",465);
//        props.put("mail.smtp.user","2021physicsclass@gmail.com");
//        props.put("mail.smtp.auth",true);
//        props.put("mail.smtp.starttls.enable",true);
//        props.put("mail.smtp.debug",true);
//        props.put("mail.smtp.socketFactory.port",465);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback",false);
//
//        try {
//            Session session = Session.getDefaultInstance(props, null);
//            session.setDebug(true);
//            MimeMessage message = new MimeMessage(session);
//            message.setText("Your OTP is " + otpCode.getText());
//            message.setSubject("OTP For your E and E Shop Account");
//            message.setFrom(new InternetAddress("2021physicsclass@gmail.com"));
//            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(jTextField3.getText().trim()));
//            message.saveChanges();
//            try
//            {
//                Transport transport = session.getTransport("smtp");
//                transport.connect("smtp.gmail.com","2021physicsclass@gmail.com","2001Thimira");
//                transport.sendMessage(message, message.getAllRecipients());
//                transport.close();
//
//                jTextField8.setEditable(true);
//                jPanel4.setVisible(false);
//                jPanel6.setVisible(true);
//
//                JOptionPane.showMessageDialog(null,"OTP has send to your Email id");
//            }catch(Exception e)
//            {
//                JOptionPane.showMessageDialog(null,"Please check your internet connection");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,e);
//        }
//    }

}
