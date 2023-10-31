package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class thewindrisesController {

    @FXML
    private Button homewindrisesbtn;
    
    // @FXML
    // private Button schedwinrises;

    @FXML
    private Button about;
    


     @FXML
private void homewindrisesBtn(ActionEvent event) {
    try {
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) homewindrisesbtn.getScene().getWindow();
        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}



// the wind rises sched

//    @FXML
// private void schedwindrises(ActionEvent event) {
//     try {
     
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
//         Parent root = loader.load();

        
//         Scene scene = new Scene(root);

        
//         Stage stage = (Stage) schedwinrises.getScene().getWindow();
        
//         stage.setScene(scene);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }

// wind about

//  @FXML
// private void About(ActionEvent event) {
//     try {
     
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml"));
//         Parent root = loader.load();

        
//         Scene scene = new Scene(root);

        
//         Stage stage = (Stage) about.getScene().getWindow();
        
//         stage.setScene(scene);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }

}
