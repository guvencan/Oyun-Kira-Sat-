/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.POJO.Kategori;
import model.POJO.Platform;
import model.POJO.Urun;
import model.create.UrunEkle;
import model.util.HibernateUtil;
import model.read.UrunKatPlatCekQuery;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author cryptex
 */
public class UrunEkleController implements Initializable {
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
    private TextField tfKiraFiyati;
    @FXML
    private TextField tfUrunAdi;
    @FXML
    private ComboBox<String> cbUrunKategorisi;
    @FXML
    private TextField tfUrunFiyati;
    @FXML
    private Button btnEkle;
    @FXML
    private TextField tfUrunAdedi;
    @FXML
    private Button btnResimSec;
    @FXML
    private ComboBox<String> cbUrunPlatform;
    
    ObservableList<Kategori> kategoriListe = FXCollections.observableArrayList();
    ObservableList<Platform> platformListe = FXCollections.observableArrayList();
    ObservableList<String> kategoriListeAdi = FXCollections.observableArrayList();
    ObservableList<String> platformListeAdi = FXCollections.observableArrayList();
    Urun urun1 = new Urun();
    Kategori k = new Kategori();
    
    byte[] urunResim;
    @FXML
    private Label lblSecilenResim;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UrunKatPlatCekQuery donenListKat = new UrunKatPlatCekQuery();
        List list1 = donenListKat.kategoriSorgu();
                
        
         for(Object o : list1) {
            
            String kategori = (String)o;
            kategoriListeAdi.add(kategori);
            
            
        }
         
         UrunKatPlatCekQuery donenListPlat = new UrunKatPlatCekQuery();
        List list2 = donenListPlat.platformSorgu();
        
         for(Object o : list2) {
            
            String platform = (String)o;
            platformListeAdi.add(platform);
            
            
        }
         
        
        
        cbUrunKategorisi.setItems(kategoriListeAdi);
        cbUrunPlatform.setItems(platformListeAdi);
        
        
        //HibernateUtil.getSessionFactory().close();
        
        
        
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
    private void urunEkle(ActionEvent event) throws IOException {
        
        System.err.println("grrrrr "+lblSecilenResim.getText());
        
        if(tfKiraFiyati.getText().isEmpty() || tfUrunAdedi.getText().isEmpty() || tfUrunAdi.getText().isEmpty() ||
                tfUrunFiyati.getText().isEmpty() || cbUrunKategorisi.getSelectionModel().getSelectedItem()==null ||
                cbUrunPlatform.getSelectionModel().getSelectedItem()==null || lblSecilenResim.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Lütfen ilgili alanların tamamını doldurun.");
        }
        
        else {
        
         try {
            
            
             UrunKatPlatCekQuery a = new UrunKatPlatCekQuery();
             List results=a.kategoriCek(cbUrunKategorisi.getSelectionModel().getSelectedItem());
        
         for(Object o : results) {
            
            Kategori kategori = (Kategori)o;
            kategoriListe.add(kategori);
            
        }
         
         
         UrunKatPlatCekQuery b = new UrunKatPlatCekQuery();
        List results2 = b.platformCek(cbUrunPlatform.getSelectionModel().getSelectedItem());
        
         for(Object o : results2) {
            
            Platform platform = (Platform)o;
            platformListe.add(platform);
            
        }
        
            System.out.println("KATEGORİ = " + results.get(0));
           
            
             UrunEkle ue = new UrunEkle();
             ue.urunEkle(kategoriListe.get(0),platformListe.get(0),tfUrunAdi.getText(),Integer.valueOf(tfKiraFiyati.getText()),Integer.valueOf(tfUrunFiyati.getText()),urunResim,Integer.valueOf(tfUrunAdedi.getText()));
        
             System.err.println("HOOOBAA = " + urunResim);
        

        JOptionPane.showMessageDialog(null, "Oyun Başarıyla Eklendi.");
            
           
        }
        
        catch(HibernateException e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
         
        }
    }

    @FXML
    private void resimSec(ActionEvent event) throws IOException {
        
        FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(
         
         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"),
         new ExtensionFilter("All Files", "*.*"));
         
 File selectedFile = fileChooser.showOpenDialog(null);
 if (selectedFile != null) {
    // mainStage.display(selectedFile);
 }

 
//        System.out.println("SELECTED = " + selectedFile.getName());
        lblSecilenResim.setText(selectedFile.getName());
        
        byte[] b;
        
          BufferedImage bufferedImage = ImageIO.read(selectedFile);
            
          
            
            ByteArrayOutputStream out = new ByteArrayOutputStream(262144);
                ImageIO.write(bufferedImage, "jpg", out);
                out.flush();
                b=out.toByteArray();
                
                urunResim=b;
        
      
        
    }

    
}
