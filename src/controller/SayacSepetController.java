package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class SayacSepetController implements Initializable {

    
    
    @FXML
    private Label jkl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
       
    }
    
    public void sayacAl(int sayac,Stage stage) throws IOException {
      
        jkl.setText(String.valueOf(sayac));
        System.out.println("DENEME SAYAC AL");
        
       sayacGonder(stage);
       sayacGonderKategori(stage);
    }
    
    public void sayacGonder(Stage stage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Musteriler.fxml"));
        
        
           //   Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );
        
        
                        int yeniSayac = Integer.valueOf(jkl.getText());
    
                        System.err.println("SAYACGONDER "+(jkl.getText()));
                        MusterilerController controller = loader.<MusterilerController>getController();
                        controller.sayacAl(Integer.valueOf(jkl.getText()));
                        
      // stage.show();
    }
    
    
    
    public void sayacGonderKategori(Stage stage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Kategori.fxml"));
        
        
           //   Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(
    new Scene(
      (Pane) loader.load()
    )
  );
        
        
                        int yeniSayac = Integer.valueOf(jkl.getText());
    
                        System.err.println("SAYACGONDER "+(jkl.getText()));
                        KategoriController controller = loader.<KategoriController>getController();
                        controller.sayacAl(Integer.valueOf(jkl.getText()));
                        
      // stage.show();
    }
    
}
