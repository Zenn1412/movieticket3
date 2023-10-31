package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class handmaidenController {

    @FXML
    private Button handmaidenhome;

    
    @FXML
    private void handmaidenHome(ActionEvent event) {
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
            Parent root = loader.load();
    
            
            Scene scene = new Scene(root);
    
            
            Stage stage = (Stage) handmaidenhome.getScene().getWindow();
            
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
