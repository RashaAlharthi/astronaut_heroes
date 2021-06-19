/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Russa
 */
public class Login3Controller implements Initializable {
    @FXML
    private Button login;
    @FXML
    private Button back;
   @FXML private TextField userName_tf;
   @FXML private TextField password_tf;
   @FXML private Label lbErr;
   @FXML private ImageView star;
    
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For Animation
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(5));
        transition.setToX(500);
        transition.setToY(500);
        transition.setAutoReverse(false);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(star);
        transition.play();
    }    
    @FXML
    protected void handleBack(ActionEvent event)throws IOException{
          mediaPlayer.play();
           
          Parent root = FXMLLoader.load(getClass().getResource("welcome1.fxml"));
          Scene scene2 = new Scene(root);
          
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(scene2);
          window.show();
    }
    @FXML
    protected void handleLogin(ActionEvent event)throws IOException{
          mediaPlayer.play();

        Player new_player = new Player();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Player> player_list = null;
        String queryStr = "from Player";
        Query query = session1.createQuery(queryStr);
        player_list =  query.list();
        session1.close();

        if (userName_tf.getText().equals("") && password_tf.getText().equals("")){
            lbErr.setText("Enter UserName and Password !");
            return;}
        if (userName_tf.getText().equals("")){
            lbErr.setText("Enter UserName !");
            return;}
        if( password_tf.getText().equals("")){
            lbErr.setText("Enter Passsword !");
            return;}
        
        for(Player p : player_list){
            if(p.getUserName().equals(userName_tf.getText()) ){
                if (p.getPassword().equals(password_tf.getText())){

                          FXMLLoader loader = new FXMLLoader(getClass().getResource("educationOrTraining4.fxml"));
                          Parent root = (Parent)loader.load();
                          EducationOrTraining4Controller secondControl_1 = loader.getController();

                          secondControl_1.current_player(p.getUserName(),p.getTotal_score());
 
                         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                         window.setScene(new Scene(root));
                         window.show();

                }
                else{
                lbErr.setText("incorrect Password !"); return;
                }         
            }       
            lbErr.setText("Entered UserName doesn't exist"); 
        }     
        

         

    
    }
                    
          
          

    
    
}
