package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class selectSeatController {

    @FXML
    private Label selectedSeatLabel;

  

    @FXML
    private Button go2ticket;

    @FXML
    private Button selectedSeatButton = null; // Track the currently selected seat

    @FXML
    private Button a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,d1,d2,d3,d4,d5,d6;
    

    // Add more buttons for other seats

    // Create a map to store the occupation status of seats
    private Map<String, Boolean> seatOccupation = new HashMap<>();

    public selectSeatController() {
        // Initialize the seatOccupation map with all seats as unoccupied
        seatOccupation.put("a1", false);
        seatOccupation.put("a2", false);
        seatOccupation.put("a3", false);
        seatOccupation.put("a4", false);
        seatOccupation.put("a5", false);
        seatOccupation.put("a6", false);
        seatOccupation.put("b1", false);
        seatOccupation.put("a2", false);
        seatOccupation.put("b3", false);
        seatOccupation.put("b4", false);
        seatOccupation.put("b5", true);
        seatOccupation.put("b6", true);
        seatOccupation.put("c1", false);
        seatOccupation.put("c2", true);
        seatOccupation.put("c3",true);
        seatOccupation.put("c4", false);
        seatOccupation.put("c5", false);
        seatOccupation.put("c6", false);
        seatOccupation.put("d1", true);
        seatOccupation.put("d2", false);
        seatOccupation.put("d3", false);
        seatOccupation.put("d4", true);
        seatOccupation.put("d5", true);
        seatOccupation.put("d6", true);
    
        // Initialize other seats in a similar way
    }

    @FXML
    private void handleSeatSelection(ActionEvent event) {
        Button button = (Button) event.getSource();
        String seatNumber = button.getText();

        if (selectedSeatButton != null) {
            // Deselect the previously selected seat
            selectedSeatButton.setStyle("-fx-background-color: transparent");
        }

        // Handle the selected seat
        if (isSeatAvailable(seatNumber)) {
            button.setStyle("-fx-background-color: blue;"); // Set background color to blue
            selectedSeatButton = button;

            // Mark the seat as occupied
            
        } else {
            // Show a dialog to inform the user that the seat is already occupied
            showOccupiedSeatDialog();
        }
    }

    private boolean isSeatAvailable(String seatNumber) {
        Boolean isOccupied = seatOccupation.get(seatNumber);
        return isOccupied == null || !isOccupied;
    
    }

    private void markSeatAsOccupied(String seatNumber) {
        // Mark the seat as occupied
        seatOccupation.put(seatNumber, true);
    }

    private void showOccupiedSeatDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Seat Occupied");
        alert.setHeaderText("Seat Already Occupied");
        alert.setContentText("The selected seat is already occupied. Please choose another seat.");
        alert.showAndWait();
    }

     @FXML
private void go2Ticket(ActionEvent event) {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/tickets.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) go2ticket.getScene().getWindow();
        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    } 

}
}
