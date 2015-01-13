package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.POJO.Musteri;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import model.delete.MusteriSil;
import model.update.MusteriGuncelleme;
import controller.MusteriGuncelleController;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.Label;
import model.create.MusteriEkle;
import model.read.MusteriListele;

public class MusterilerController implements Initializable {
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
    private TableView<Musteri> MusteriListe;
    @FXML
    private ContextMenu menuItem;
    @FXML
    private MenuItem itemSil;
    @FXML
    private MenuItem itemGuncelle;
    @FXML
    private TableColumn<Musteri, Integer> clmMusteriId;
    @FXML
    private TableColumn<Musteri, BigInteger> clmMusteriTc;
    @FXML
    private TableColumn<Musteri, String> clmMusteriAd;
    @FXML
    private TableColumn<Musteri, String> clmMusteriSoyad;
    @FXML
    private TableColumn<Musteri, String> clmMusteriMail;
    @FXML
    private TableColumn<Musteri, BigInteger> clmMusteriTel;
    @FXML
    private TableColumn<Musteri, String> clmMusteriAdres;
    @FXML
    private TableColumn<Musteri, DateTimeFormatter> clmMusteriTarih;
    @FXML
    private TableColumn<Musteri, Integer> clmMusteriPuan;
    @FXML
    private TextField tfMusteriArat;
    @FXML
    private Button btnMusteriEkle;
    
    int sayac;
    @FXML
    private Label labelDeneme;
    @FXML
    private Label lblSepetSayac;
    
    MusteriListele mu = new MusteriListele();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(Object o :mu.MusteriListele()) 
        {
            Musteri musteri = (Musteri)o;
            musteriListe.add(musteri);
            
        }
               
        clmMusteriId.setCellValueFactory(new PropertyValueFactory<>("musteriId"));
        clmMusteriAd.setCellValueFactory(new PropertyValueFactory<>("musteriAd"));
        clmMusteriTc.setCellValueFactory(new PropertyValueFactory<>("musteriTc"));
        clmMusteriSoyad.setCellValueFactory(new PropertyValueFactory<>("musteriSoyad"));
        clmMusteriAdres.setCellValueFactory(new PropertyValueFactory<>("musteriAdres"));
        clmMusteriMail.setCellValueFactory(new PropertyValueFactory<>("musteriMail"));
        clmMusteriPuan.setCellValueFactory(new PropertyValueFactory<>("musteriPuan"));
        clmMusteriTarih.setCellValueFactory(new PropertyValueFactory<>("musteriTarih"));
        clmMusteriTel.setCellValueFactory(new PropertyValueFactory<>("musteriTel"));
        
        MusteriListe.setItems(musteriListe);
        
    
       
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

    ObservableList<Musteri> musteriListe = FXCollections.observableArrayList();
        
    
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
    private void sil(ActionEvent event) {
         int dialogButton ;
         
         menuItem.hide();
    
               dialogButton=JOptionPane.showConfirmDialog (null, "Seçilen ögeyi gerçekten silmek istiyor musunuz?");
                      
                 
                if(dialogButton==0){ 
                    
                   MusteriSil mSil = new MusteriSil();
                   mSil.MusteriSilindi(MusteriListe.getSelectionModel().getSelectedItem().getMusteriId());  
       
                   MusteriListe.getItems().remove(MusteriListe.getSelectionModel().getSelectedItem());
                   
                }
    }

    @FXML
    private void guncelle(ActionEvent event) throws IOException {
   
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/MusteriGuncelle.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        MusteriGuncelleme mGuncel=new MusteriGuncelleme();
        mGuncel.MusteriGuncellendi(MusteriListe.getSelectionModel().getSelectedItem().getMusteriId());
        
    }

    @FXML
    private void musteriAratma(ActionEvent event) {
        
        tfMusteriArat.setOnKeyPressed(new EventHandler<KeyEvent>()
    {
        @Override
        public void handle(KeyEvent key)
        {
           if (key.getCode().equals(KeyCode.ENTER)){
            musteriListe.clear();
            Session session = HibernateUtil.getSessionFactory().openSession();
            String arananKelime = tfMusteriArat.getText();
                
        
        session.beginTransaction();
        
        String hql = "FROM Musteri M WHERE M.musteriAd like " +" '" +"%"+arananKelime + "%" + "'"+
                                " OR" + " M.musteriSoyad like " +" '" +"%"+arananKelime + "%" + "'"+
                                " OR" + " M.musteriAdres like " +" '" +"%"+arananKelime + "%" + "'";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        for(Object o : results) {

            Musteri musteri = (Musteri)o;
            musteriListe.add(musteri);
        }
               
        clmMusteriId.setCellValueFactory(new PropertyValueFactory<>("musteriId"));
        clmMusteriAd.setCellValueFactory(new PropertyValueFactory<>("musteriAd"));
        clmMusteriTc.setCellValueFactory(new PropertyValueFactory<>("musteriTc"));
        clmMusteriSoyad.setCellValueFactory(new PropertyValueFactory<>("musteriSoyad"));
        clmMusteriAdres.setCellValueFactory(new PropertyValueFactory<>("musteriAdres"));
        clmMusteriMail.setCellValueFactory(new PropertyValueFactory<>("musteriMail"));
        clmMusteriPuan.setCellValueFactory(new PropertyValueFactory<>("musteriPuan"));
        clmMusteriTarih.setCellValueFactory(new PropertyValueFactory<>("musteriTarih"));
        clmMusteriTel.setCellValueFactory(new PropertyValueFactory<>("musteriTel"));
        
        MusteriListe.setItems(musteriListe);
        
       
        session.getTransaction().commit();
        }
        }
    });
    }

    @FXML
    private void musteriEkleme(ActionEvent event) throws IOException {
        
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/MusteriEkle.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void sayacAl(int sayac) {
        
        lblSepetSayac.setText(String.valueOf(sayac));
        System.out.println("MUSTERİ "+sayac);
        
    }


}
