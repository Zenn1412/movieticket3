package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class fbaarController {

    @FXML
    private Button fbaar2home;

    @FXML
    private Button fbaar2logout;

    @FXML
    private Button fbaar2movie;
    
    @FXML
    private void fbaar2Home(ActionEvent event) {
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
            Parent root = loader.load();
    
            
            Scene scene = new Scene(root);
    
            
            Stage stage = (Stage) fbaar2home.getScene().getWindow();
            
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void fbaar2Movie(ActionEvent event) {
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/movies.fxml"));
            Parent root = loader.load();
    
            
            Scene scene = new Scene(root);
    
            
            Stage stage = (Stage) fbaar2movie.getScene().getWindow();
            
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void fbaar2Logout(ActionEvent event) {
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
            Parent root = loader.load();
    
            
            Scene scene = new Scene(root);
    
            
            Stage stage = (Stage) fbaar2logout.getScene().getWindow();
            
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
