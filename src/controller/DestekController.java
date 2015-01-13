/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.read.DestekUserMailCekQuery;
import model.update.UserUpdateQuery;

/**
 * FXML Controller class
 *
 * @author ASUS-PC
 */
public class DestekController implements Initializable {
    @FXML
    private TextField tfGenelArama;
    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnMusteriler;
    @FXML
    private Button btnAnasayfa;
    @FXML
    private Button btnKategori;
    @FXML
    private Button btnUrun;
    @FXML
    private Button btnSatisGecmisi;
    @FXML
    private Button btnStokTakip;
    @FXML
    private Button btnDestek;
    @FXML
    private Button btnSepet;
    
     
    @FXML
    private TextField tfKonuBaslik;
    @FXML
    private TextArea tfKonuAciklama;
    @FXML
    private ChoiceBox<String> cbDepartman;
    @FXML
    private TextField tfTelNo;
    @FXML
    private Label uyarıLabel;
    @FXML
    private Label mesajGonderildiLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList <String> items = FXCollections.observableArrayList(
        "Genel Bilgi",
        "Teknik Destek", 
        "Güvenlik"
        );
        
        cbDepartman.getItems().addAll(items);
    }    

    @FXML
    private void menuAdminGuncelle(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Admin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuMusteriler(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Musteriler.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuAnasayfa(ActionEvent event) throws IOException {
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Anasayfa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuKategori(ActionEvent event) throws IOException {
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Kategori.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuUrun(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Urun.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuSatisGecmisi(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/SatisGecmisi.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuStokTakip(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/StokTakip.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuDestek(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Destek.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();  
        
    }

    @FXML
    private void menuSepet(ActionEvent event) throws IOException {
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Sepet.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gonderAction(ActionEvent event) {
        
        DestekUserMailCekQuery dumcq = new DestekUserMailCekQuery();
        String uMail = dumcq.userMailAl();
        
        String option = cbDepartman.getValue();
        
        if(tfKonuAciklama.getText().equals("") ||
           tfKonuBaslik.getText().equals("") ||
           (cbDepartman.getValue().isEmpty())){
            
            uyarıLabel.setText("Lütfen ilgili alanları doldurunuz..");
        }
        
        else{
            
            sistemeMailGonder(uMail);
        }
   
    }
    
    
    public void sistemeMailGonder(String uMail){
        
        final String username = "systemtest3434@gmail.com";
        final String pass = "xlite2873";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass); //To change body of generated methods, choose Tools | Templates.
            }     
        });
    
        
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("systemtest3434@gmail.com"));
            message.setSubject(tfKonuBaslik.getText());
            message.setText("Musteri E-POSTA :"+ uMail +"\n"+
                            "AÇIKLAMA \n"+tfKonuAciklama.getText()+"\n\n"+
                            "İLGİLİ DEPARTMAN \n"+cbDepartman.getSelectionModel().getSelectedItem()+"\n\n"+
                            "TELEFON NO :" + tfTelNo.getText()+"\n");
            Transport.send(message);
        
            mesajGonderildiLabel.setText("Mesajınız Gonderildi..");
            uyarıLabel.setText("");
            
            
            if(cbDepartman.getSelectionModel().getSelectedItem().equals("Güvenlik")){
            
            String yeniUserName = yeniKullaniciAdiUret();
            String yeniUserPass = yeniKullaniciPassUret();
            
            anindaHizmet(uMail, yeniUserName, yeniUserPass);
            
             UserUpdateQuery uuq = new UserUpdateQuery();
             uuq.userNamePassGuncelle(yeniUserName, yeniUserPass);
        }
        
        } catch (AddressException ex) {

            ex.printStackTrace();
            uyarıLabel.setText("Mesajınız İletilemedi..");
            
        } catch (MessagingException ex) {

            ex.printStackTrace();
            uyarıLabel.setText("Mesajınız İletilemedi..");
        }
    }
    
    
    public void anindaHizmet(String uMail, String yeniUserName, String yeniUserPass){
        
        final String username = "systemtest3434@gmail.com";
        final String pass = "xlite2873";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass); //To change body of generated methods, choose Tools | Templates.
            }     
        });
    
        
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(uMail));
            message.setSubject("CODEAMAN GÜVENLİK");
            message.setText("   Sayın Musterimiz,\n\n"+
                            "     Yeni Kullanıcı Adınız :"+yeniUserName+"\n"+
                            "     Yeni Kullanıcı Şifreniz :"+ yeniUserPass+"\n\n"+
                            "     Siz degerli müşteriler için sunulan sistemimizi iyi günlerde kullanmanızı dileriz.\n"+
                            "     Codeaman Ekibi");
            Transport.send(message);
        
        
        } catch (AddressException ex) {
           
            ex.printStackTrace();
            
        } catch (MessagingException ex) {

            ex.printStackTrace();
        }    
    }
    
    public String yeniKullaniciAdiUret(){
        
        Random rnd = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String yeniKullaniciAdi = "";
    
        for(int i=0; i<10; i++){
            int index = rnd.nextInt(characters.length());
            yeniKullaniciAdi += characters.charAt(index);
        }
        
        System.out.println(yeniKullaniciAdi);
        return yeniKullaniciAdi;
    } 
    
    
    public String yeniKullaniciPassUret(){
        
        Random rnd = new Random();
        String mix = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-";
        String yeniKullaniciPass = "";
    
        for(int i=0; i<10; i++){
            int index = rnd.nextInt(mix.length());
            yeniKullaniciPass += mix.charAt(index);
        }
        
        System.out.println(yeniKullaniciPass);
        return yeniKullaniciPass;
    } 
}
