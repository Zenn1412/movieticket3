package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.xdevapi.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginSignupController implements Initializable {

    

    @FXML
    private Button eeaaobtn;

    @FXML
    private Button homewindrisesbtn;

    @FXML
    private Button tomovies;

    @FXML
    private Button thewindrisesbtn;

    @FXML
    private Button handmaidenbtn;

    @FXML 
    private Button homelogoutbtn;

    @FXML
    private Button screambtn;

    @FXML
    private Button ponyoBtn;

    @FXML
    private Hyperlink signUp_alreadyHaveAccount;

    @FXML
    private Button signUp_btn;

    @FXML
    private Button signUp_close;

    @FXML
    private TextField signUp_email;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private Button signUp_minimize;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private TextField signUp_username;

    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_loginBtn;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;
// Tools for database
private Connection connect;
private PreparedStatement prepare;
private Statement statement;
private ResultSet result;



public boolean validEmail(){
    // agapito_123@gmail.com [first letter] [second letter -> Before@] [@] [gmail] [.] [com]
    Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

    Matcher match = pattern.matcher(signUp_email.getText());

    Alert alert;

    if(match.find() && match.group().matches(signUp_email.getText())){
        
        return true;
    } else{

        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Invalid email");
        alert.showAndWait();

        return false;
    }

}

//for signup
public void signup(){

    String sql = "INSERT INTO admin (email,username,password) VALUES (?,?,?)";

    connect = database.connectDb();
    
    try{

        prepare = connect.prepareStatement(sql);
        prepare.setString(1,signUp_email.getText());
        prepare.setString(2,signUp_username.getText());
        prepare.setString(3,signUp_password.getText());

        Alert alert;

        if(signUp_email.getText().isEmpty() || signUp_username.getText().isEmpty()
         || signUp_password.getText().isEmpty()){

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
         

         
         }else if(signUp_password.getText().length() < 8){

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Password");
            alert.showAndWait();
         }else{
            if(validEmail()){

                 prepare.execute();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully create a new Account!");
            alert.showAndWait();


            signUp_email.setText("");
            signUp_username.setText("");
            signUp_password.setText("");
            

         }

        }


    }catch(Exception e){e.printStackTrace();}

}


//signin
public void signin(){
    String sql ="SELECT * FROM admin WHERE username = ? and password = ?";
    connect = database.connectDb();
    try{
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, signin_username.getText());
        prepare.setString(2, signin_password.getText());

        result = prepare.executeQuery();
        Alert alert;
       if(signin_username.getText().isEmpty() || signin_password.getText().isEmpty()){
alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Message");
alert.setHeaderText(null);
alert.setContentText(("Please fill all blank fields"));
alert.showAndWait();
//go to dashboard/homepage

       }else{
if(result.next()){
alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Message");
alert.setHeaderText(null);
alert.setContentText("Successfully Login!");
alert.showAndWait();
//go to dashboard
Parent root =FXMLLoader.load(getClass().getResource("/FXML/dashboard.fxml"));
Stage stage =new Stage();
Scene scene = new Scene(root);
 
        

signin_loginBtn.getScene().getWindow().hide();
stage.initStyle(StageStyle.TRANSPARENT);
stage.setScene(scene);
stage.show();

}else{
    alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("Wrong Username/Password");
    alert.showAndWait();
}
       }
}catch (Exception e) {e.printStackTrace();}

}

//to switch in sign_createaccount to signup
    public void switchForm(ActionEvent event){

        if(event.getSource()== signin_createAccount){
            signin_form.setVisible(false);
            signUp_form.setVisible(true);

        }else if(event.getSource()== signUp_alreadyHaveAccount ){
       signin_form.setVisible(true);
       signUp_form.setVisible(false);
        }
    }
//to exit signin btn
    public void signIn_close(){
        System.exit(0);
    }
    //minimize singin button    
    public void signIn_minimize(ActionEvent event){
        Stage stage = (Stage)signin_form.getScene().getWindow();
          stage.setIconified(true);
    }
    public void signup_close(){
        System.exit(0);
    }
    //minimize signup btn
    public void signUp_minimize(ActionEvent event){
        Stage stage = (Stage)signUp_form.getScene().getWindow();
          stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
    //FOR PONYO BUTTON ON dashboard/home scene
@FXML
private void ponyoBtn(ActionEvent event) {
    try {
        // Load the ponyo.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ponyo.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) ponyoBtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


//Homepage close button
 public void home_close(){
        System.exit(0);
 }

@FXML
private void logoutBtn(ActionEvent event) {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) homelogoutbtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void screamBtn(ActionEvent event) {
    try {
        // Load the ponyo.fxml file
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
private void handmaidenBtn(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/handmaiden.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) handmaidenbtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void homewindrisesBtn(ActionEvent event) {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/thewindrises.fxml"));
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


@FXML
private void toMovies(ActionEvent event) {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/movies.fxml"));
        Parent root = loader.load();

        
        Scene scene = new Scene(root);

        
        Stage stage = (Stage) tomovies.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void eeaaoBtn(ActionEvent event) {
    try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/eeaao.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the current stage (assuming the button is part of a stage)
        Stage stage = (Stage) eeaaobtn.getScene().getWindow();

        // Set the new scene in the current stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
