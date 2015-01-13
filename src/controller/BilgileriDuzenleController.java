/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.POJO.Urun;
import model.read.UrunKatPlatCekQuery;
import model.update.UrunBilgiGuncelle;

/**
 * FXML Controller class
 *
 * @author cryptex
 */
public class BilgileriDuzenleController implements Initializable {
    
    @FXML
    private TextField tfUrunAdedi;
    @FXML
    private TextField tfUrunFiyati;
    @FXML
    private ComboBox<String> cbUrunKategorisi;
    @FXML
    private TextField tfUrunAdi;
    @FXML
    private TextField tfKiraFiyati;
    @FXML
    private ComboBox<String> cbUrunPlatform;
    
    int secilenUrunID;
    ObservableList<String> kategoriListeAdi = FXCollections.observableArrayList();
    ObservableList<String> platformListeAdi = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UrunKatPlatCekQuery cek = new UrunKatPlatCekQuery();
        List list=cek.kategoriSorgu();
        
         for(Object o : list) {
            
            String kategori = (String)o;
            kategoriListeAdi.add(kategori);
            
            
        }
         
         cbUrunKategorisi.setItems(kategoriListeAdi);
         
         
         
        List list2=cek.platformSorgu();
        
         for(Object o : list2) {
            
            String platform = (String)o;
            platformListeAdi.add(platform);
            
            
        }
         
         cbUrunPlatform.setItems(platformListeAdi);
        
    }
    
    public void urunBilgileriAl(Urun secilenUrun) {
        
       
        tfUrunAdi.setText(secilenUrun.getUrunAdi());
        tfUrunAdedi.setText(String.valueOf(secilenUrun.getUrunAdet()));
        tfKiraFiyati.setText(String.valueOf(secilenUrun.getUrunKiraFiyat()));
        tfUrunFiyati.setText(String.valueOf(secilenUrun.getUrunSatisFiyat()));
        cbUrunKategorisi.setValue(secilenUrun.getKat());
        cbUrunPlatform.setValue(secilenUrun.getPlat());
        secilenUrunID=secilenUrun.getUrunId();
    }

    @FXML
    private void urunBilgiGuncelle(ActionEvent event) {
        
        UrunKatPlatCekQuery ukpc = new UrunKatPlatCekQuery();
        List katListe = ukpc.kategoriCekID(cbUrunKategorisi.getSelectionModel().getSelectedItem());
        
        
            
             int kategoriID = (int)katListe.get(0);
            
            
             UrunKatPlatCekQuery ukpc2 = new UrunKatPlatCekQuery();
             List platListe = ukpc2.platformCekID(cbUrunPlatform.getSelectionModel().getSelectedItem());
             
             int platformID = (int)platListe.get(0);
        
        
        UrunBilgiGuncelle ubg = new UrunBilgiGuncelle();
        ubg.urunBilgiGuncelle(tfUrunAdi.getText(), kategoriID, platformID, Integer.valueOf(tfUrunFiyati.getText()),Integer.valueOf(tfKiraFiyati.getText())
                ,Integer.valueOf(tfUrunAdedi.getText()),secilenUrunID);
    }

    
}
