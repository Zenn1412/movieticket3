import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{

    private double x = 0;
    private double y = 0;
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Login.fxml"));
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent Event) ->{
            x = Event.getSceneX();
            y = Event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event)->{

            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
    
} 