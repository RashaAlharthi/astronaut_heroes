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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SignUp2Controller implements Initializable {

   @FXML private ImageView star;
   @FXML private ImageView rock;
   @FXML private ComboBox combo;
   @FXML private Button Start;
   @FXML private Button Back;
   @FXML private TextField userName_tf;
   @FXML private TextField password_tf;
   @FXML private Label lbErr;

   
   String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ComboBox Fill
         combo.getItems().addAll("6","7","8","9","10","11","12");
         combo.getSelectionModel().select("6");
        //For Animation
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(5));
        transition.setToX(500);
        transition.setToY(500);
        transition.setAutoReverse(false);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(star);
        transition.play();
        
        TranslateTransition transition2=new TranslateTransition();
        transition2.setDuration(Duration.seconds(5));
        transition2.setToX(20);
        transition2.setToZ(-10);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setNode(rock);
        transition2.play();
        
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
    protected void handleStart(ActionEvent event)throws IOException{
        mediaPlayer.play();
        
        Player new_player = new Player();
        new_player.setUserName(userName_tf.getText());
        new_player.setPassword(password_tf.getText());
        new_player.setAge((String)combo.getValue());
        
        try {
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
        
        lbErr.setText("");
        
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session2.beginTransaction();
        session2.save(new_player);
        tx.commit();
        session2.close(); 
      
      FXMLLoader loader = new FXMLLoader(getClass().getResource("educationOrTraining4.fxml"));
      Parent root = (Parent)loader.load();
      EducationOrTraining4Controller secondControl = loader.getController();
      
      secondControl.current_player(new_player.getUserName(), new_player.getTotal_score());
      
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
        }

        catch (Exception e){ lbErr.setText("The UserName is already taken,\nTry another name.");
        
        
        }
        

           
    }

    
}
