/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author xxrob
 */
public class EducationOrTraining4Controller implements Initializable {
     @FXML
    private Button train;
    @FXML
    private Button educate;
    @FXML
    private Button scores;
    @FXML
    private Button logOut;
  
  
    
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    @FXML
    private ImageView astro;
    @FXML
    private Label playerName;
    @FXML
    private Label playerScore;
    @FXML
    private ImageView rock1;
    @FXML
    private ImageView rock2;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //animation
    TranslateTransition transition= new TranslateTransition();
    transition.setDuration(Duration.seconds(100));
    transition.setToX(1000);
    transition.setToY(1000);
    transition.setAutoReverse(false);
    transition.setCycleCount(Animation.INDEFINITE);
    transition.setNode(rock1);
    transition.play();
      
    TranslateTransition transition2= new TranslateTransition();
    transition2.setDuration(Duration.seconds(50));
    transition2.setToX(100);
    transition2.setToY(0);
    transition2.setAutoReverse(false);
    transition2.setCycleCount(Animation.INDEFINITE);
    transition2.setNode(rock2);
    transition2.play();
    
    }   
    @FXML
    protected void handleTrain(ActionEvent event)throws IOException{
 
      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseGame.fxml"));
      Parent root = (Parent)loader.load();
      ChooseGameController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
    }

    @FXML
    protected void handleEducate(ActionEvent event)throws IOException{
                 
        
      mediaPlayer.play();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("education.fxml"));
      Parent root = (Parent)loader.load();
      EducationController secondControl_1 = loader.getController();

      
      secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
    }
@FXML
    protected void handleLogOut(ActionEvent event)throws IOException{  
        
          mediaPlayer.play();
          
           
          Parent root = FXMLLoader.load(getClass().getResource("welcome1.fxml"));
          Scene scene2 = new Scene(root);
          
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(scene2);
          window.show();
          
    }
@FXML
    protected void handleScores(ActionEvent event)throws IOException{
      
        
          mediaPlayer.play();
          
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Scores6.fxml"));
     Parent root = (Parent)loader.load();
     Scores6Controller secondControl_1 = loader.getController();
      
     secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
          
    }
    
    public void current_player(String player, int score){
        playerName.setText(player);
        playerScore.setText(Integer.toString(score));
    }
    
    
  
}
 