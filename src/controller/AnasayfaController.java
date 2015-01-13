package controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.POJO.Sepet;
import model.POJO.Urun;
import model.create.SepetEkle;
import model.update.SepetUpdate;
import model.read.UrunListele;


public class AnasayfaController implements Initializable {
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
    private Pane arkaPane;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Label lblSepetSayac;
    
    
    static SepetController ana = new SepetController();

    int sayac ;
   
    SepetEkle spt = new SepetEkle();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
       
        final ObservableList<Urun> urunListe = FXCollections.observableArrayList();
        
         UrunListele ul = new UrunListele();
         List results = ul.urunAnasayfa();
         
         for(Object o : results) {
            
                    Urun urun = (Urun)o;
                    urun.setPlat(urun.getPlatform().getPlatformAdi());
                    urunListe.add(urun);
            
                }
       
         
         GridPane gridPane = new GridPane();
         gridPane.setStyle("-fx-background-color:transparent");
         scroll.setContent(gridPane);
         scroll.setStyle("-fx-background-color:transparent");
         arkaPane.getChildren().add(gridPane);
         gridPane.setGridLinesVisible(false);
         
         
         for(int i=0;i<4;i++) {
             
             ColumnConstraints cc = new ColumnConstraints(198);
             gridPane.getColumnConstraints().add(cc);
             
         }
         
       
         
          for(int i=0;i<Math.ceil((double)urunListe.size()/4.0);i++) {
             
              RowConstraints rc = new RowConstraints(400);
              gridPane.getRowConstraints().add(rc);
             
         }
         
          int k=0;
        
        for(int i=0;i<=(int)(urunListe.size()/4);i++) {
            
            for(int j=0;j<4;j++) {
                
                int deger=k;
                
                if(i==(int)(urunListe.size()/4) && j==urunListe.size()%4)
                    break;
                
                HBox hb = new HBox();
                Button btn1 = new Button("SAT");
                Button btn2 = new Button("KİRALA");
                btn1.setStyle("-fx-background-color: #292323 ; -fx-text-fill:#b2c538");
                btn1.setCursor(Cursor.HAND);
                btn2.setStyle("-fx-background-color: #292323 ; -fx-text-fill:#b2c538");
                btn2.setCursor(Cursor.HAND);
                hb.setAlignment(Pos.BOTTOM_CENTER);
                hb.setSpacing(10);
                hb.getChildren().addAll(btn1,btn2);
                
                
                ImageView iv = new ImageView();
                     iv.setFitHeight(186);
                     iv.setFitWidth(131);
                     byte[] resim = urunListe.get(deger).getUrunResim();
                     iv.setImage(new Image(new ByteArrayInputStream(resim)));
                     gridPane.add(iv, j, i);
                
                VBox vb =new VBox();
                
                
                VBox vbAdR = new VBox();
                Label lAd = new Label(urunListe.get(deger).getUrunAdi());
                lAd.setStyle("-fx-font-weight :bold ; -fx-font-size :15 ; -fx-font-family : Verdana");
                vbAdR.getChildren().addAll(lAd,iv);
                vbAdR.setSpacing(5);
                vbAdR.setAlignment(Pos.CENTER);
                
                HBox hbPlat = new HBox();
                Label lPlat = new Label("Platfom : "+urunListe.get(deger).getPlatform().getPlatformAdi());
                lPlat.setStyle("-fx-font-weight :bold ; -fx-font-size :12 ; -fx-font-family : Verdana");
                lPlat.setFont(new Font(12));
                hbPlat.getChildren().add(lPlat);
                hbPlat.setAlignment(Pos.CENTER);
                
                VBox vbKirSat = new VBox();
                Label lKir = new Label("Kiralama Bedeli : "+urunListe.get(deger).getUrunKiraFiyat()+" TL");
                Label lSat = new Label("Satis Bedeli : "+ urunListe.get(deger).getUrunSatisFiyat()+ " TL");
                lKir.setStyle("-fx-font-size :11 ; -fx-font-family : Verdana"); 
                lSat.setStyle("-fx-font-size :11 ; -fx-font-family : Verdana");
                
                lSat.setFont(new Font(12));
                lKir.setFont(new Font(12));
                vbKirSat.setSpacing(5);
                vbKirSat.getChildren().addAll(lSat,lKir);
                vbKirSat.setAlignment(Pos.CENTER);
                
                
                gridPane.add(vb, j, i);
                
                     
                     vb.getChildren().addAll(vbAdR, hbPlat, vbKirSat, hb);
                     vb.setSpacing(20);
                     vb.setAlignment(Pos.CENTER);
                     //GridPane.setHalignment(vb, HPos.CENTER);
               
                
                     //Sat
                btn1.setOnAction(new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle(ActionEvent event) {
                        
                        //System.err.println("ID"+ urunListe.get(deger).getUrunId());
                        sayac++;
                        //ana.setSayac(sayac);
                        //ana.setId(urunListe.get(deger).getUrunId());
                        // System.out.println("IDg  "+ana.getId() +"   Syg  "+ ana.getSayac());
                        lblSepetSayac.setText(String.valueOf(sayac));    
                        //   System.err.println("SAYAC"+sayac);
                        
                        
                        
                        spt.SepetEkle(urunListe.get(deger));
                        
                     
                    }
                    
                    
                
               
                });
                
                //KİRALA
                
                btn2.setOnAction(new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle(ActionEvent event) {
                        
                   
                   
                       // System.err.println("ID"+ urunListe.get(deger).getUrunId());
                       
                       // ana.setSayac(sayac);
                       // ana.setId(urunListe.get(deger).getUrunId());
                        spt.SepetKiraEkle(urunListe.get(deger));
                        

                    }
                });
                
               
                
                k++;
            }
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

    private void sayacDeneme(ActionEvent event) throws IOException {
        
        Node node1=(Node) event.getSource();
        Stage stage1=(Stage) node1.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("/view/SayacSepet.fxml"));
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
    
//    public void deneme(Stage stage) throws IOException {
//        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SayacSepet.fxml"));
//        
////        Stage stage = new Stage(StageStyle.DECORATED);
////  stage.setScene(
////    new Scene(
////      (Pane) loader.load()
////    )
////  );
//        
//        stage.setScene(new Scene((Pane) loader.load()));
//                       
//                        SayacSepetController controller = loader.<SayacSepetController>getController();
//                        controller.sayacAl(sayac,stage);
//                     
//                        
//                       // stage.show();
//    }
    
}
