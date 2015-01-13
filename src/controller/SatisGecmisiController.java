package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.POJO.Kirahareket;
import model.POJO.Musteri;
import model.POJO.Satisgecmis;
import model.POJO.Urun;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import model.read.SatisGecmisiListele;

public class SatisGecmisiController implements Initializable {
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
    private TableView<Satisgecmis> TableSatisGecmisi;
    @FXML
    private TableColumn<Satisgecmis,Musteri> clmMusteriId;
    @FXML
    private TableColumn<Satisgecmis, String> clmDurum;
    @FXML
    private TableColumn<Satisgecmis, Date> clmTarih;
    @FXML
    private TableColumn<Satisgecmis, Integer> clmFiyat;
    @FXML
    private TableColumn<Satisgecmis, Urun> clmUrun;
    @FXML
    private TableColumn<Satisgecmis, String> clmMusteriAd;
    
    
private ObservableList<Kirahareket> kiraListe = FXCollections.observableArrayList();    
private ObservableList<Satisgecmis> satListe = FXCollections.observableArrayList();       
private SatisGecmisiListele satg = new SatisGecmisiListele(); 
   
    @FXML
    private TableView<Kirahareket> KiraTable;
    @FXML
    private TableColumn<Kirahareket, Integer> clmKiraMusteriId;
    
    @FXML
    private TableColumn<Kirahareket, Musteri> clmKiraMusteri;
    @FXML
    private TableColumn<Kirahareket, Date> clmKiraBasTar;
    @FXML
    private TableColumn<Kirahareket, Date> clmKiraBitTar;
    @FXML
    private TableColumn<Kirahareket, Integer> clmKiraFiyat;
    @FXML
    private TableColumn<Kirahareket, Urun> clmnKiraUrun;
    @FXML
    private Tab KiraPane;
    @FXML
    private TextField SatisAraText;
    @FXML
    private Button SatisAraButton;
    @FXML
    private TextField KiraAraText;
    @FXML
    private Button KiraAraButton;
  


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         Satis();
         
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
    private void KiraPane(Event event) {
        
                        
        Kira();
        
        
    }

    @FXML
    private void SatisArama(ActionEvent event) {
        
         satListe.clear();
         
         if(SatisAraText.getText() ==null)
             Satis();
         
     
        

          for(Object o :  satg.SatisAra(SatisAraText.getText())) {
            
           Satisgecmis sat = (Satisgecmis)o;
          
           sat.setID(sat.getMusteri().getMusteriId());
           sat.setMusteriler(sat.getMusteri().getMusteriAd());
           sat.setUrunler(sat.getUrun().getUrunAdi());
           
            satListe.add(sat);
           
         
           }  
          
          if(satListe.size()== 0)
              JOptionPane.showMessageDialog(null, "Bulunamadı");
        
        clmMusteriId.setCellValueFactory(new PropertyValueFactory<Satisgecmis,Musteri>("ID"));
        clmMusteriAd.setCellValueFactory(new PropertyValueFactory<>("Musteriler"));
        clmDurum.setCellValueFactory(new PropertyValueFactory<>("durum"));
        clmTarih.setCellValueFactory(new PropertyValueFactory<>("satisKiraTarih"));
        clmFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyat")); 
        clmUrun.setCellValueFactory(new PropertyValueFactory<>("Urunler"));
        
         
        
        TableSatisGecmisi.setItems(satListe);  
        SatisAraText.setText(null);
        
        
    }

    @FXML
    private void KiraArama(ActionEvent event) {
        
        kiraListe.clear();
        
        if(KiraAraText.getText() == null)
            Kira();
        
        
        
        
         for(Object o :  satg.KiraAra(KiraAraText.getText())) 
         {
            
        Kirahareket kira = (Kirahareket)o;
        kira.setID(kira.getMusteri().getMusteriId());
        kira.setMusteriler(kira.getMusteri().getMusteriAd());
        kira.setUrunler(kira.getUrun().getUrunAdi());
        kiraListe.add(kira);
           }  
         
          if(kiraListe.size()== 0)
              JOptionPane.showMessageDialog(null, "Bulunamadı");
          
        
    clmKiraMusteriId.setCellValueFactory(new PropertyValueFactory<>("ID"));     
    clmKiraMusteri.setCellValueFactory(new PropertyValueFactory<>("Musteriler"));   
    clmKiraBasTar.setCellValueFactory(new PropertyValueFactory<>("kiraBaslangicTarih"));   
    clmKiraBitTar.setCellValueFactory(new PropertyValueFactory<>("kiraSonTarih"));   
    clmKiraFiyat.setCellValueFactory(new PropertyValueFactory<>("kiraFiyat"));   
    clmnKiraUrun.setCellValueFactory(new PropertyValueFactory<>("Urunler"));   
    
    KiraTable.setItems(kiraListe);
    }



 private void Satis() {
     
      satListe.clear();
     
       for(Object o :  satg.urunListele()) {
            
           Satisgecmis sat = (Satisgecmis)o;
           sat.setID(sat.getMusteri().getMusteriId());
           sat.setMusteriler(sat.getMusteri().getMusteriAd());
           sat.setUrunler(sat.getUrun().getUrunAdi());
           satListe.add(sat);
           }  
        
        clmMusteriId.setCellValueFactory(new PropertyValueFactory<Satisgecmis,Musteri>("ID"));
        clmMusteriAd.setCellValueFactory(new PropertyValueFactory<>("Musteriler"));
        clmDurum.setCellValueFactory(new PropertyValueFactory<>("durum"));
        clmTarih.setCellValueFactory(new PropertyValueFactory<>("satisKiraTarih"));
        clmFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyat")); 
        clmUrun.setCellValueFactory(new PropertyValueFactory<>("Urunler"));
        
         
        
        TableSatisGecmisi.setItems(satListe);  
    }
 
private void Kira(){
    
        kiraListe.clear();
    
       for(Object o :  satg.KiraListele()) {
            
        Kirahareket kira = (Kirahareket)o;
        kira.setID(kira.getMusteri().getMusteriId());
        kira.setMusteriler(kira.getMusteri().getMusteriAd());
        kira.setUrunler(kira.getUrun().getUrunAdi());
        kiraListe.add(kira);
           }  
        
    clmKiraMusteriId.setCellValueFactory(new PropertyValueFactory<>("ID"));     
    clmKiraMusteri.setCellValueFactory(new PropertyValueFactory<>("Musteriler"));   
    clmKiraBasTar.setCellValueFactory(new PropertyValueFactory<>("kiraBaslangicTarih"));   
    clmKiraBitTar.setCellValueFactory(new PropertyValueFactory<>("kiraSonTarih"));   
    clmKiraFiyat.setCellValueFactory(new PropertyValueFactory<>("kiraFiyat"));   
    clmnKiraUrun.setCellValueFactory(new PropertyValueFactory<>("Urunler"));   
    
    KiraTable.setItems(kiraListe);
        
    
}
    
}
