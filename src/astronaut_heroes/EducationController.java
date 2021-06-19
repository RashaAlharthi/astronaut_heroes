/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author ath77
 */
public class EducationController implements Initializable {
    
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    private String playerName;
    private int playerScore;
    
    @FXML 
    private Button Back;
    @FXML 
    private ImageView saturn;
    @FXML
    private ImageView Jupiter;
    @FXML
    private ImageView Mars;
    @FXML
    private ImageView Sun;
    @FXML
    private ImageView Earth;
    @FXML
    private ImageView Venus;
    @FXML
    private ImageView Mercury;
    @FXML
    private ImageView Uranus;
    @FXML
    private ImageView Neptune;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
        
    @FXML
    protected void handleBack(ActionEvent event)throws IOException{
      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("educationOrTraining4.fxml"));
      Parent root = (Parent)loader.load();
      EducationOrTraining4Controller secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
  
    @FXML
    protected void handleSaturn(javafx.scene.input.MouseEvent event)throws IOException{
     
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Saturn.fxml"));
      Parent root = (Parent)loader.load();
      SaturnController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }

    @FXML
    protected void handleJupiter(javafx.scene.input.MouseEvent event)throws IOException{
     
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Jupiter.fxml"));
      Parent root = (Parent)loader.load();
      JupiterController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleMars(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Mars.fxml"));
      Parent root = (Parent)loader.load();
      MarsController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleSun(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Sun.fxml"));
      Parent root = (Parent)loader.load();
      SunController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }


    @FXML
    protected void handleEarth(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Earth.fxml"));
      Parent root = (Parent)loader.load();
      EarthController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleVenus(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Venus.fxml"));
      Parent root = (Parent)loader.load();
      VenusController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleMercury(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Mercury.fxml"));
      Parent root = (Parent)loader.load();
      MercuryController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleUranus(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Uranus.fxml"));
      Parent root = (Parent)loader.load();
      UranusController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }
    @FXML
    protected void handleNeptune(javafx.scene.input.MouseEvent event)throws IOException{
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Neptune.fxml"));
      Parent root = (Parent)loader.load();
      NeptuneController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }

    public void current_player(String player, int score){
        playerName =player;
        playerScore =score;
    }

}
