package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.POJO.CokSatan;
import model.POJO.Satisgecmis;
import model.POJO.Urun;
import model.read.UrunListele;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class StokTakipController implements Initializable {
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
    private TableView<Urun> StokTable;
    @FXML
    private TableColumn<Urun, String> clmurunAd;
    @FXML
    private TableColumn<Urun, Integer> clmUrunAdet;

    private UrunListele U = new UrunListele();
    private ObservableList<Urun> urunListe = FXCollections.observableArrayList();
    private ObservableList<CokSatan> coksatanListe = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> grafikData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> grafikDataCokSatan = FXCollections.observableArrayList();
    
    @FXML
    private PieChart pie;
    @FXML
    private Label caption;
    @FXML
    private Tab StokPie;
    @FXML
    private Tab StokTabloTAB;
    @FXML
    private Tab cokSatanTabPie;
    @FXML
    private Tab CokSatanTAB;
    @FXML
    private TableView<CokSatan>  cokSatanTable;
    @FXML
    private TableColumn<CokSatan,  Object> clmSatanUrun;
    @FXML
    private TableColumn<CokSatan,  Object> clmSatanAdet;
    @FXML
    private TableColumn<CokSatan,  Object> clmSatanFiyat;
    @FXML
    private PieChart PieCokSatan;
    @FXML
    private Label caption1;
    
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
     
        
         for(Object o : U.urunTableCek()) 
         { 
            Urun urun = (Urun)o;
           
            urunListe.add(urun);
            grafikData.add(new PieChart.Data(urun.getUrunAdi(),urun.getUrunAdet()));
        }
         clmurunAd.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
         clmUrunAdet.setCellValueFactory(new PropertyValueFactory<>("urunAdet"));
         
         
         StokTable.setItems(urunListe);
         
        pie.setData(grafikData);
        pie.setLegendVisible(true);
        pie.setLegendSide(Side.BOTTOM);
        pie.setTitle("Stok Dağılımları");
        
        
        
caption.setTextFill(Color.DARKORANGE);
caption.setStyle("-fx-font: 24 arial;");

for (PieChart.Data data : pie.getData()) {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
        
            @Override public void handle(MouseEvent e) {
                
                caption.setText(String.valueOf(data.getPieValue())+ " Adet");
                
             }
        });
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
    private void cokSatanTabPie(Event event) {
        
       coksatanListe.clear();
       grafikDataCokSatan.clear();
        
        CokSatanTAB(event);
    }

    @FXML
    private void CokSatanTAB(Event event) {
        
       coksatanListe.clear();
       grafikDataCokSatan.clear();
       
       
        
    
       
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    String SQL_QUERY ="SELECT U.UrunAdi,count(S.UrunID),sum(S.SatisFiyat) FROM Satisgecmis S   inner join Urun U on  S.UrunId = U.UrunId group by U.UrunId";
      
    //String SQL_QUERY = "SELECT UrunID,count(UrunID),sum(S.SatisFiyat) FROM Satisgecmis S group by UrunID";
     List results = session.createSQLQuery(SQL_QUERY).list();  
  

       int i =0;
            for(Iterator iterator =results.iterator() ; iterator.hasNext();) 
         { 
            Object [] row = (Object []) iterator.next();
           
             
             CokSatan cs = new CokSatan();
             
             String ad =new String (row[0].toString());
             //int fiyat = (Integer) row[2];
             double d = new Double(row[2].toString());
             grafikDataCokSatan.add(new PieChart.Data(ad, d));
             
             
             cs.setUrun(row[0]);
             cs.setSayi(row[1]);
             cs.setFiyat(row[2]);
             
           coksatanListe.add(cs);

        }
            
         clmSatanUrun.setCellValueFactory(new PropertyValueFactory<>("urun"));
         clmSatanAdet.setCellValueFactory(new PropertyValueFactory<>("sayi"));
         clmSatanFiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
         
         cokSatanTable.setItems(coksatanListe);
         
        PieCokSatan.setData(grafikDataCokSatan);
        PieCokSatan.setLegendVisible(true);
        PieCokSatan.setLegendSide(Side.TOP);
        PieCokSatan.setTitle("Satış Dağılımları");
        
caption1.setTextFill(Color.DARKORANGE);
caption1.setStyle("-fx-font: 24 arial;");
        
        for (PieChart.Data data : PieCokSatan.getData()) {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
        
            @Override public void handle(MouseEvent e) {
                
                caption1.setText(String.valueOf(data.getPieValue()) +" TL");
                
             }
        });
}
         
        
  session.getTransaction().commit();  
  session.close();       
        
        


         
         
         
          
        
    }

    @FXML
    private void PieAction(MouseEvent event) {
    }
    
}
