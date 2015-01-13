/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.read.AdminQuery;
import model.update.UserUpdateQuery;

/**
 * FXML Controller class
 *
 * @author ASUS-PC
 */
public class AdminController implements Initializable {
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
    private TextField tfUserName;
    @FXML
    private TextField tfUserMail;
    @FXML
    private PasswordField tfUserPass;
    @FXML
    private PasswordField tfUserPassAgain;
    @FXML
    private Label uyarıLabel;
    @FXML
    private Label bilgiUserName;
    @FXML
    private Label bilgiUserPass;
    @FXML
    private Label bilgiUserMail;
    @FXML
    private Label guncellendiLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AdminQuery aq = new AdminQuery();
        
        bilgiUserName.setText(aq.userNameAl());
        
        String userPass = aq.userPassAl();
        String pass = "";
        
        for(int i=0; i<userPass.length(); i++)
            pass = pass + "* ";
        
        bilgiUserPass.setText(pass);
        
        bilgiUserMail.setText(aq.userMailAl());
        
        
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
    private void kaydetAction(ActionEvent event) {
        
        UserUpdateQuery uuq = new UserUpdateQuery();
        boolean bos = true;
        
  
            if((tfUserName.getText() == null || tfUserName.getText().equals("")) ||
               (tfUserPass.getText() == null || tfUserPass.getText().equals("")) ||
               (tfUserPassAgain.getText() == null || tfUserPassAgain.getText().equals("")) ||     
               (tfUserMail.getText() == null || tfUserMail.getText().equals(""))){
            
                uyarıLabel.setText("Lütfen ilgili alanları doldurunuz.");
            }
            
            else if(tfUserPass.getText().equals(tfUserPassAgain.getText())){
            
            uuq.userGuncelle(tfUserName.getText(), tfUserPass.getText(), tfUserMail.getText());
            guncellendiLabel.setText("Hesap Bilgileriniz Güncellendi.");
            uyarıLabel.setText("");
            }
        
            else{
                uyarıLabel.setText("Şifreniz birbiriyle uyuşmuyor.");  
            }
                
        
        
        AdminQuery aq = new AdminQuery();
        
        bilgiUserName.setText(aq.userNameAl());
        
        String userPass = aq.userPassAl();
        String pass = "";
        
        for(int i=0; i<userPass.length(); i++)
            pass = pass + "* ";
        
        bilgiUserPass.setText(pass);
        
        bilgiUserMail.setText(aq.userMailAl());
    }
    
}
