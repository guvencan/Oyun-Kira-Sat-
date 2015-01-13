package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.update.MusteriGuncelleme;


public class MusteriGuncelleController implements Initializable {
    @FXML
    private TextField lblId;
    @FXML
    private TextField lblTC;
    @FXML
    private TextField lblAd;
    @FXML
    private TextField lblSoyad;
    @FXML
    private TextField lblMail;
    @FXML
    private TextField lblTel;
    @FXML
    private TextField lblTarih;
    @FXML
    private TextField lblPuan;
    @FXML
    private Button btnMusteriGuncelle;
    @FXML
    private TextArea taAdres;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
 
   
    @FXML
    private void MusteriGuncelleme(ActionEvent event) {
       
    }
    
}
