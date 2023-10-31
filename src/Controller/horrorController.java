package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class horrorController {

    @FXML
    private Button romancebtn;

    @FXML
    private Button horror2home;

    @FXML
    private Button sawbtn;

    @FXML
    private Button screambtn;

    @FXML
    private Button horror2action;

    @FXML
    private Button horror2anime;

    @FXML
    private Button horror2logout;

    @FXML
    private Button horror2allmovie;

    
 @FXML
private void sawBtn(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/saw.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) sawbtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void screamBtn(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/scream.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) screambtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void horror2Action(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/action.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) horror2action.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void horror2Anime(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/action.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) horror2anime.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
}

@FXML
private void horror2Allmovie(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/action.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) horror2allmovie.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void horror2Logout(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/action.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) horror2logout.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void horror2Home(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) horror2home.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@FXML
private void romanceBtn(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/romance.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) romancebtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    

}
