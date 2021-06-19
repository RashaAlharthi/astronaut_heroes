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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author lujam
 */
public class ChooseGameController implements Initializable {
@FXML
    private Button orderPlanets;
    private Button whichPlanet;
    private Button BackToTrainingOREducationButton;
    @FXML
    private Label playerName;
    @FXML
    private Label playerScore;
    
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);

      @FXML ImageView rock2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

TranslateTransition transition2= new TranslateTransition();
transition2.setDuration(Duration.seconds(5));
transition2.setToX(50);
transition2.setToY(50);
transition2.setAutoReverse(false);
transition2.setCycleCount(Animation.INDEFINITE);
transition2.setNode(rock2);
transition2.play();
    }   //
    
     @FXML
    protected void BackToTrainingOrEducationHandle(ActionEvent event)throws IOException{
      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("educationOrTraining4.fxml"));
      Parent root = (Parent)loader.load();
      EducationOrTraining4Controller secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
    }
  
     @FXML
    protected void whichPlanetHandle(ActionEvent event)throws IOException{
                 
      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("WhichPlanetQ1.fxml"));
      Parent root = (Parent)loader.load();
      WhichPlanetQ1Controller secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
          
    }
    
     @FXML
    protected void orderPlanetsHandle(ActionEvent event)throws IOException{

          mediaPlayer.play();

          FXMLLoader loader = new FXMLLoader(getClass().getResource("planetsOrder.fxml"));
          Parent root = (Parent)loader.load();
          PlanetsOrderController secondControl_1 = loader.getController();

          secondControl_1.current_player(playerName.getText(),parseInt(playerScore.getText()));

         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(new Scene(root));
         window.show();
   
         Window owner = orderPlanets.getScene().getWindow();
         showAlert(Alert.AlertType.INFORMATION, owner, "Game instructions", "1: Choose a planet from the combo box."
                 + "\n2: Enter the number of the orbit by keyboard to move the plantets."
                 + "\n3: Enter Done whene You finish.");
    }
    
   public static void showAlert(Alert.AlertType alertType, Window window, String title, String message){
       Alert alert = new Alert(alertType);
       alert.setTitle(title);
       alert.setHeaderText(null);
       alert.setContentText(message);
       alert.initOwner(window);
       alert.show();
   
   }
    
        public void current_player(String player, int score){
        playerName.setText(player);
        playerScore.setText(Integer.toString(score));
    }

}
