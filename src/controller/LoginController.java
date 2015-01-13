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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.read.LoginQuery;

/**
 * FXML Controller class
 *
 * @author asaidpalamut
 */
public class LoginController implements Initializable {
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField tfUserPass;
    @FXML
    private Label uyarıLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        
        LoginQuery loq = new LoginQuery();
        
        String userName = loq.userNameAl();
        String userPass = loq.userPassAl();
        
        if(tfUserName.getText().equals(userName) && tfUserPass.getText().equals(userPass)){
            
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Anasayfa.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            stage.sizeToScene();
        
        }
        
        else{
            
            uyarıLabel.setText("Kullanıcı adı veya parola yanlış..");
            tfUserName.setText("");
            tfUserPass.setText("");
        }
    }

    @FXML
    private void destekAction(ActionEvent event) throws IOException {
        
        ((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/DestekLoginden.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.sizeToScene();
    }
    
}
