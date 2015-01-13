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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.POJO.Kategori;
import model.POJO.Platform;
import model.POJO.Urun;
import model.util.HibernateUtil;
import model.create.KategoriEkle;
import model.create.PlatformEkle;
import model.read.KategoriListele;
import model.read.PlatformListele;
import model.read.UrunListele;
import org.hibernate.Query;
import org.hibernate.Session;


public class KategoriController implements Initializable {
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
    private Button katbtnekle;
    @FXML
    private Button plabtnekle;
    @FXML
    private TextField tfKategoriAdi;
    @FXML
    private TextField tfPlatformAdi;
    @FXML
    private Tooltip ekleKategoriTooltip;
    @FXML
    private Tooltip eklePlatformTooltip;
    @FXML
    private TextField tfPlatformAdiDuzenle;
    @FXML
    private Tooltip duzenlePlatformTooltip;
    @FXML
    private Button katbtnAra;
    @FXML
    private Button plabtnAra;
    @FXML
    private TextField tfKategoriAdiDuzenle;
    @FXML
    private Tooltip duzenleKategoriTooltip;
    
    ObservableList<Kategori> kategoriListe = FXCollections.observableArrayList();
    ObservableList<Platform> platformListe = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Kategori, Integer> clmId;
    @FXML
    private TableColumn<Kategori, String> clmKategoriAdi;
    @FXML
    private TableView<Kategori> tvKategoriListe;
    @FXML
    private TableView<Platform> tvPlatformListe;
    @FXML
    private TableColumn<Platform, Integer> clmPid;
    @FXML
    private TableColumn<Platform, String> clmPlatformAdi;
    @FXML
    private Label lblSepetSayac;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        
//        String hql = "select E.KategoriAdi from kategori E";
//        Query query = session.createQuery(hql);
//        List results = query.list();
//        
//            for(Object o : results){
//                
//                String kategori = (String)o;
//                kategoriListeAdi.add(kategori);
//                
//            }
        
        
       
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
    private void kategoriEkle(ActionEvent event) {
        
        
        KategoriEkle ke = new KategoriEkle();
        ke.kategoriEkle(tfKategoriAdi.getText());
    }

    @FXML
    private void PlatformEkle(ActionEvent event) {
        
        PlatformEkle pe = new PlatformEkle();
        pe.platformEkle(tfPlatformAdi.getText());
    }

    @FXML
    private void kategoriDuzenle(ActionEvent event) {
        
        
    }

    @FXML
    private void kategoriSil(ActionEvent event) {
        
        
        KategoriListele ul = new KategoriListele();
        ul.kategoriSil(tvKategoriListe.getSelectionModel().getSelectedItem().getKategoriId());
        
        kategoriListe.remove(tvKategoriListe.getSelectionModel().getSelectedIndex());
        
        
    }

    @FXML
    private void platformDuzenle(ActionEvent event) {
    }

    @FXML
    private void platformSil(ActionEvent event) {
        
        PlatformListele ul = new PlatformListele();
        ul.platformSil(tvPlatformListe.getSelectionModel().getSelectedItem().getPlatformId());
        
        platformListe.remove(tvPlatformListe.getSelectionModel().getSelectedIndex());
        
        
    }

    @FXML
    private void kategoriAra(ActionEvent event) {
        
        kategoriListe.clear();
        
        String arananKelime = tfKategoriAdiDuzenle.getText();
        
        
        
        KategoriListele ul = new KategoriListele();
        List results=ul.kategoriListele(arananKelime);
        
        if(results.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Listelenecek ürün bulunamadı.");
        }
        
        else {
        
        for(Object o : results) {
            
           
            Kategori kategori = (Kategori)o; 
            
            kategoriListe.add(kategori);
            
        }
       
        clmId.setCellValueFactory(new PropertyValueFactory<>("kategoriId"));
        clmKategoriAdi.setCellValueFactory(new PropertyValueFactory<>("kategoriAdi"));
        
        
        tvKategoriListe.setItems(kategoriListe);
        
        
        
        }
        
    }

    @FXML
    private void PlatformAra(ActionEvent event) {
        
        platformListe.clear();
        
        String arananKelime = tfPlatformAdiDuzenle.getText();
        
        
        
        PlatformListele ul = new PlatformListele();
        List results=ul.platformListele(arananKelime);
        
        if(results.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Listelenecek ürün bulunamadı.");
        }
        
        else {
        
        for(Object o : results) {
            
           
            Platform platform = (Platform)o; 
            
            platformListe.add(platform);
            
        }
       
        clmPid.setCellValueFactory(new PropertyValueFactory<>("platformId"));
        clmPlatformAdi.setCellValueFactory(new PropertyValueFactory<>("platformAdi"));
        
        
        tvPlatformListe.setItems(platformListe);
        
        
        
        }
        
    }
    
    
     public void sayacAl(int sayac) {
        
        lblSepetSayac.setText(String.valueOf(sayac));
        System.out.println("MUSTERİ "+sayac);
        
    }
    
}
