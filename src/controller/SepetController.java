package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.POJO.CokSatan;
import model.POJO.Musteri;
import model.POJO.Satisgecmis;
import model.POJO.Sepet;
import model.POJO.Urun;
import model.create.SatisgecmisEkle;
import model.delete.SepetSil;
import model.read.MusteriListele;
import model.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


public class SepetController implements Initializable {
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
    private Label lblSepetAdet;
    @FXML
    private TabPane sepetTabmenu;
    @FXML
    private Tab sepetTabmenuSatis;
    @FXML
    private TableView<Urun> sepetTabmenuSatisTable;
    @FXML
    private TableColumn<Urun, Object> clmUrunad;
    @FXML
    private TableColumn<Urun, Object> clmFiyat;
    @FXML
    private TextField tfMusteriBulsatis;
    @FXML
    private Button btnMusteriBul;
    @FXML
    private Label MusteriADlabel;
    @FXML
    private Label ToplamLabel;
    @FXML
    private Button btnSat;
    @FXML
    private Tab sepetTabmenuKiraTV;
    @FXML
    private TableView<Urun> sepetTabmenuKiraTable;
    @FXML
    private TableColumn<Urun, Object> clmUrunAdKira;
    @FXML
    private TableColumn<Urun, Date> clmBaslangictarihi;
    @FXML
    private TableColumn<Urun, Date> clmBitistarihi;
    @FXML
    private TableColumn<Urun, Object> clmKiraFiyat;
    @FXML
    private Button btnMusteriBulKira;
    @FXML
    private Label MusteriADlabelKira;
    @FXML
    private Button btnKirala;
    @FXML
    private Label ToplamLabelKira;
    @FXML
    private TextField tfMusteriBulKira;
    @FXML
    private Button btnBosaltSatis;
    @FXML
    private Button btnBosaltKira;  
    

     private ObservableList<Urun> sepetListe = FXCollections.observableArrayList();
     private ObservableList<Urun> sepetKiraListe = FXCollections.observableArrayList();
     
     private SepetSil sepetsil = new SepetSil();
     private MusteriListele mus = new MusteriListele();
     private SatisgecmisEkle  satg = new SatisgecmisEkle();
     
     private Musteri musterigec;
     private Urun urungec;
    
     
     
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
     Sepet();
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
    private void MusteriBulAction(ActionEvent event) {
        
     
        
        for(Object o : mus.MusteriBul(tfMusteriBulsatis.getText())) 
         { 
             Musteri musteri = (Musteri)o;
             musterigec = musteri;
            MusteriADlabel.setText("" +musteri.getMusteriAd() +"  " +musteri.getMusteriSoyad()); 
        }
        
    }
    
    

    @FXML
    private void SatAction(ActionEvent event) {
        
        
               Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
      
        System.err.println("girdi");
        System.out.println(sepetListe.size());
        
        
        
        
        
        for(int  i=0 ; i<sepetListe.size() ; i++)
        {
             Satisgecmis sat = new Satisgecmis();
        
        sat.setMusteri(sat.getMusteri());
        sat.setDurum("Satildi");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
        String date = "2015-01-02";
        sat.setSatisKiraTarih(Date.from(Instant.EPOCH));
        sat.setSatisFiyat(sepetKiraListe.get(i).getUrunSatisFiyat());
        sat.setUrun(sepetKiraListe.get(i));
        satg.ekle(sat);
         
        }
        
       
      session.getTransaction().commit();
        session.close();  
        
        
        
        
      //  sepetsil.Sil();
    }

    @FXML
    private void BosaltSatisAction(ActionEvent event) {

        sepetsil.Sil();
    }
    
    @FXML
    private void KiralaTabAction(Event event) {
        
        SepetKira();
    }

    @FXML
    private void MusteriBulKiraAction(ActionEvent event) {
    }

    @FXML
    private void KiralaAction(ActionEvent event) {
    }

    @FXML
    private void BosaltKiraAction(ActionEvent event) {
    }

    private void Sepet (){
        
    sepetListe.clear();
       
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    String SQL_QUERY ="SELECT U.UrunAdi,U.UrunSatisFiyat From Sepet S inner join Urun U on S.UrunId=U.UrunId";
      
   
     List results = session.createSQLQuery(SQL_QUERY).list();  
  

       int toplam =0;
            for(Iterator iterator =results.iterator() ; iterator.hasNext();) 
         { 
            Object [] row = (Object []) iterator.next();
           
             
             Urun urun = new Urun();
             
           
             String ad =new String (row[0].toString());
             
             //double d = new Double(row[2].toString());
             int fiyat = new Integer (row[1].toString());
             
             toplam+=fiyat;
            
             
             urun.setUrunAdi(ad);
             urun.setUrunSatisFiyat(fiyat);
             

           sepetListe.add(urun);

        }
            
         clmUrunad.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
         clmFiyat.setCellValueFactory(new PropertyValueFactory<>("urunSatisFiyat"));
         
         sepetTabmenuSatisTable.setItems(sepetListe);
         ToplamLabel.setText(" "+ toplam);
        
    }
    
    
    
    private void SepetKira (){
        
    sepetKiraListe.clear();
       
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    String SQL_QUERY ="SELECT U.UrunAdi,U.UrunKiraFiyat From Sepetkira S inner join Urun U on S.kUrunId=U.UrunId";
      
   
     List results = session.createSQLQuery(SQL_QUERY).list();  
  

       int toplam =0;
            for(Iterator iterator =results.iterator() ; iterator.hasNext();) 
         { 
            Object [] row = (Object []) iterator.next();
           
             
             Urun urun = new Urun();
             
             System.out.println(row[0]);
             System.out.println(row[1]);
             
             String ad =new String (row[0].toString());
             
             //double d = new Double(row[2].toString());
             int fiyat = new Integer (row[1].toString());
             
             toplam+=fiyat;
             
             System.out.println();
             
             urun.setUrunAdi(ad);
             urun.setUrunKiraFiyat(fiyat);
             
        
            
             urun.setKiraBasTarih( new Date() );
             
             

           sepetKiraListe.add(urun);

        }
            
         clmUrunAdKira.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
         clmKiraFiyat.setCellValueFactory(new PropertyValueFactory<>("urunKiraFiyat"));
         clmBaslangictarihi.setCellValueFactory(new PropertyValueFactory<>("KiraBasTarih"));
         
         sepetTabmenuKiraTable.setItems(sepetKiraListe);
         ToplamLabelKira.setText(" "+ toplam);
        
    }

    

}
