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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.POJO.Kategori;
import model.POJO.Urun;
import model.read.UrunKatPlatCekQuery;
import model.util.HibernateUtil;
import model.read.UrunListele;
import org.hibernate.Query;
import org.hibernate.Session;

public class UrunController implements Initializable {
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
    private Button btnKaydet;
    @FXML
    private TableView<Urun> tvUrunListe;
    @FXML
    private TableColumn<Urun, Integer> clmUrunID;
    @FXML
    private TableColumn<Urun, String> clmUrunAdi;
    @FXML
    private TableColumn<Urun, String> clmKategori;
    @FXML
    private TableColumn<Urun, Integer> clmUrunAdedi;
    @FXML
    private TableColumn<Urun, Integer> clmUrunFiyati;
    @FXML
    private TableColumn<Urun, Integer> clmKiraBedeli;
    @FXML
    private TableColumn<Urun, String> clmPlatform;
    @FXML
    private TextField tfUrunAra;
    @FXML
    private Button btnAra;
    
    public Urun secilen;
    
    ObservableList<Urun> urunListe = FXCollections.observableArrayList();
    ObservableList<Urun> urunListe2 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cbPlatform;
    @FXML
    private ComboBox<String> cbKategori;
    
   ObservableList<String> kategoriler = FXCollections.observableArrayList();
   ObservableList<String> platformlar = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       UrunKatPlatCekQuery donenListKat = new UrunKatPlatCekQuery();
        List list1 = donenListKat.kategoriSorgu();
                
        
         for(Object o : list1) {
            
            String kategori = (String)o;
            kategoriler.add(kategori);
            
        }
         
         cbKategori.setItems(kategoriler);
         
          UrunKatPlatCekQuery donenListPlat = new UrunKatPlatCekQuery();
        List list2 = donenListPlat.platformSorgu();
        
         for(Object o : list2) {
            
            String platform = (String)o;
            platformlar.add(platform);
            
        }
         
        cbPlatform.setItems(platformlar);
        
        
        
         UrunListele ul = new UrunListele();
        List results=ul.urunListele();
        
        if(results.isEmpty()) {
            
            VBox pane = new VBox();
            
            Image resim = new Image(getClass().getResourceAsStream("/pictures/saw.png"));
            pane.setAlignment(Pos.CENTER);
            ImageView iv = new ImageView(resim);
            pane.getChildren().add(iv);
            
            Label tvMessage = new Label("Listelenecek ürün bulunamadı.");
            
            pane.getChildren().add(tvMessage);
             tvMessage.setStyle("-fx-text-fill:red ; -fx-font-size:16");
             
             tvUrunListe.setPlaceholder(pane);
        }
        
        else {
        
        for(Object o : results) {
            
           
            Urun urun = (Urun)o; 
            urun.setID(urun.getKategori().getKategoriId());
            urun.setPlat(urun.getPlatform().getPlatformAdi());
            urun.setKat(urun.getKategori().getKategoriAdi());
            urunListe.add(urun);
            
        }
       
        clmUrunID.setCellValueFactory(new PropertyValueFactory<>("urunId"));
        clmKategori.setCellValueFactory(new PropertyValueFactory<>("Kat"));
        clmPlatform.setCellValueFactory(new PropertyValueFactory<>("Plat"));
        clmUrunAdi.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
        clmKiraBedeli.setCellValueFactory(new PropertyValueFactory<>("urunKiraFiyat"));
        clmUrunFiyati.setCellValueFactory(new PropertyValueFactory<>("urunSatisFiyat"));
        clmUrunAdedi.setCellValueFactory(new PropertyValueFactory<>("urunAdet"));
        
        tvUrunListe.setItems(urunListe);
        
        }
        
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
    private void yeniBilgiKaydet(ActionEvent event) {
    }

    @FXML
    private void bilgileriDuzenle(ActionEvent event) throws IOException {
        
      
        
        secilen=tvUrunListe.getSelectionModel().getSelectedItem();
        
        FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "/view/BilgileriDuzenle.fxml"
    )
  );
        
//        Parent root = FXMLLoader.load(getClass().getResource("/view/Anasayfa.fxml"));;

  Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );

  BilgileriDuzenleController controller = 
    loader.<BilgileriDuzenleController>getController();
  controller.urunBilgileriAl(secilen);

  stage.show();
        
    }

    @FXML
    private void urunSil(ActionEvent event) {
        
        System.out.println("SECİLEN URUN === " + tvUrunListe.getSelectionModel().getSelectedItem().getUrunId());
        System.out.println("SECİLEN INDEX === " + tvUrunListe.getSelectionModel().getSelectedIndex());
        
        UrunListele ul = new UrunListele();
        ul.urunSil(tvUrunListe.getSelectionModel().getSelectedItem().getUrunId());
        
        urunListe.remove(tvUrunListe.getSelectionModel().getSelectedIndex());
        
        if(urunListe.isEmpty()) {
            
            Label tvMessage = new Label("Listelenecek ürün bulunamadı.");
             tvMessage.setStyle("-fx-text-fill:red ; -fx-font-size:16");
             
             tvUrunListe.setPlaceholder(tvMessage);
            
        }
        
    }

    @FXML
    private void urunAra(ActionEvent event) {
        
        
        urunListe.clear();
        
        String arananKelime = tfUrunAra.getText();
        
        
        
        UrunListele ul = new UrunListele();
        List results=ul.urunListele(arananKelime);
        
        if(results.isEmpty()) {
            
            Label tvMessage = new Label("Aranan ürün bulunamadı.");
             tvMessage.setStyle("-fx-text-fill:red ; -fx-font-size:16");
             
             tvUrunListe.setPlaceholder(tvMessage);
        }
        
        else {
        
        for(Object o : results) {
            
           
            Urun urun = (Urun)o; 
            urun.setID(urun.getKategori().getKategoriId());
            urun.setPlat(urun.getPlatform().getPlatformAdi());
            urun.setKat(urun.getKategori().getKategoriAdi());
            urunListe.add(urun);
            
        }
       
        clmUrunID.setCellValueFactory(new PropertyValueFactory<>("urunId"));
        clmKategori.setCellValueFactory(new PropertyValueFactory<>("Kat"));
        clmPlatform.setCellValueFactory(new PropertyValueFactory<>("Plat"));
        clmUrunAdi.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
        clmKiraBedeli.setCellValueFactory(new PropertyValueFactory<>("urunKiraFiyat"));
        clmUrunFiyati.setCellValueFactory(new PropertyValueFactory<>("urunSatisFiyat"));
        clmUrunAdedi.setCellValueFactory(new PropertyValueFactory<>("urunAdet"));
        
        tvUrunListe.setItems(urunListe);
        
        
        
        }
        
    }

    @FXML
    private void urunEkleSayfasi(ActionEvent event) throws IOException {
        
         Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/UrunEkle.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    private void secilenPlatform(ActionEvent event) {
        
        urunListe2.clear();
        
        UrunKatPlatCekQuery ukpc = new UrunKatPlatCekQuery();
        List platID = ukpc.platformCekID(cbPlatform.getSelectionModel().getSelectedItem());
        
        UrunListele ul = new UrunListele();
        List results = ul.urunListelePlatID((int)platID.get(0));
        
        
         if(results.isEmpty()) {
            
            //JOptionPane.showMessageDialog(null, "Listelenecek ürün bulunamadı.");
             
             Label tvMessage = new Label("\""+cbPlatform.getSelectionModel().getSelectedItem()+"\""+" için listelenecek ürün bulunamadı.");
             tvMessage.setStyle("-fx-text-fill:red ; -fx-font-size:16");
             
             tvUrunListe.setPlaceholder(tvMessage);
        }
        
        else {
        
        for(Object o : results) {
            
           
            Urun urun = (Urun)o; 
            urun.setID(urun.getKategori().getKategoriId());
            urun.setPlat(urun.getPlatform().getPlatformAdi());
            urun.setKat(urun.getKategori().getKategoriAdi());
            urunListe2.add(urun);
            
        }
       
        clmUrunID.setCellValueFactory(new PropertyValueFactory<>("urunId"));
        clmKategori.setCellValueFactory(new PropertyValueFactory<>("Kat"));
        clmPlatform.setCellValueFactory(new PropertyValueFactory<>("Plat"));
        clmUrunAdi.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
        clmKiraBedeli.setCellValueFactory(new PropertyValueFactory<>("urunKiraFiyat"));
        clmUrunFiyati.setCellValueFactory(new PropertyValueFactory<>("urunSatisFiyat"));
        clmUrunAdedi.setCellValueFactory(new PropertyValueFactory<>("urunAdet"));
        
        tvUrunListe.setItems(urunListe2);
        
        
        
        }
        
        
    }   
         
        
    @FXML
    private void secilenKategori(ActionEvent event) {
        
        
        
        urunListe2.clear();
        
        UrunKatPlatCekQuery ukpc = new UrunKatPlatCekQuery();
        List katID = ukpc.kategoriCekID(cbKategori.getSelectionModel().getSelectedItem());
        
        UrunListele ul = new UrunListele();
        List results = ul.urunListeleKatID((int)katID.get(0));
        
        
         if(results.isEmpty()) {
            
            //JOptionPane.showMessageDialog(null, "Listelenecek ürün bulunamadı.");
             
             Label tvMessage = new Label("\""+cbKategori.getSelectionModel().getSelectedItem()+"\""+" kategorisinde listelenecek ürün bulunamadı.");
             tvMessage.setStyle("-fx-text-fill:red ; -fx-font-size:16");
             
             tvUrunListe.setPlaceholder(tvMessage);
        }
        
        else {
        
        for(Object o : results) {
            
           
            Urun urun = (Urun)o; 
            urun.setID(urun.getKategori().getKategoriId());
            urun.setPlat(urun.getPlatform().getPlatformAdi());
            urun.setKat(urun.getKategori().getKategoriAdi());
            urunListe2.add(urun);
            
        }
       
        clmUrunID.setCellValueFactory(new PropertyValueFactory<>("urunId"));
        clmKategori.setCellValueFactory(new PropertyValueFactory<>("Kat"));
        clmPlatform.setCellValueFactory(new PropertyValueFactory<>("Plat"));
        clmUrunAdi.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
        clmKiraBedeli.setCellValueFactory(new PropertyValueFactory<>("urunKiraFiyat"));
        clmUrunFiyati.setCellValueFactory(new PropertyValueFactory<>("urunSatisFiyat"));
        clmUrunAdedi.setCellValueFactory(new PropertyValueFactory<>("urunAdet"));
        
        tvUrunListe.setItems(urunListe2);
        
        
        
        }
        
        
        
    }
    
    
}
