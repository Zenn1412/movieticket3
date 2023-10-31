package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ticketsController {

    @FXML
    private Label selectedSeatLabel; // A Label to display the selected seat

    // Other fields and methods

    public void setSelectedSeat(String seat) {
        // Set the selected seat in the Label or any other UI element in your "tickets.fxml" file
        selectedSeatLabel.setText("Selected Seat: " + seat);
    }

    // Other methods and code
}
