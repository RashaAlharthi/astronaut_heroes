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
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author xxrob
 */
public class EarthController implements Initializable {
@FXML
private ImageView move;

@FXML ImageView speaker;
private String playerName;
private int playerScore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    TranslateTransition transition= new TranslateTransition();
    transition.setDuration(Duration.seconds(100));
    transition.setToX(1000);
    transition.setToY(1000);
    transition.setAutoReverse(false);
    transition.setCycleCount(Animation.INDEFINITE);
    transition.setNode(move);
    transition.play();
    
    }    
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    String path2 = "Earth.wav";
    Media media2 = new Media(new File(path2).toURI().toString());
    MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
    
    @FXML
    protected void handleBack(ActionEvent event)throws IOException{
          
        mediaPlayer2.pause();
        mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("education.fxml"));
      Parent root = (Parent)loader.load();
      EducationController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
    }
    
    public void current_player(String player, int score){
        playerName =player;
        playerScore =score;
    }
    
    @FXML
    private void handleSpeaker(MouseEvent event) {
        
        mediaPlayer2.play();
    }
}
