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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author ath77
 */
public class PlanetsOrderController implements Initializable {

    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);

    
    public int score=0;
    private String playerName;
    private int playerScore;
    
    @FXML private Label lbErr;
    @FXML private Button Back;
    @FXML private Button Done;
    @FXML private ComboBox planets_combo;
    @FXML private ImageView jupiter; 
    @FXML private ImageView neptune; 
    @FXML private ImageView mercury;  
    @FXML private ImageView earth;    
    @FXML private ImageView venus;    
    @FXML private ImageView mars;    
    @FXML private ImageView uranus;  
    @FXML private ImageView saturn;
    @FXML
    private Pane pane;
    @FXML
    private Button ok;
    @FXML private Label ScoreLabel;
    @FXML private Label Grade;
    @FXML private ImageView RightStar;
    @FXML private ImageView LeftStar;
    @FXML private ImageView CenterStar;
    DropShadow shadow = new DropShadow();
    DropShadow reset_shadow = new DropShadow();

    /**
     * Initializes the controller class.
     */
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane.setOpacity(0);
        RightStar.setOpacity(0);
        LeftStar.setOpacity(0);
        CenterStar.setOpacity(0);
      planets_combo.setStyle("-fx-font: 13px \"Comic Sans MS\";");
      planets_combo.getItems().addAll("Jupiter","Neptune","Mercury","Earth","Venus","Mars","Uranus","Saturn");

        shadow.setColor(Color.WHITE);
        shadow.setOffsetX(1.2);
        shadow.setOffsetY(1.2);
        shadow.setSpread(0.5);  
        reset_shadow.setColor(Color.TRANSPARENT);

          planets_combo.valueProperty().addListener((options)-> { 
               if (planets_combo.getValue().equals("Jupiter")) { jupiter.setEffect(shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); venus.setEffect(reset_shadow);mars.setEffect(reset_shadow);uranus.setEffect(reset_shadow); saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Neptune")) { neptune.setEffect(shadow);jupiter.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); venus.setEffect(reset_shadow);mars.setEffect(reset_shadow);uranus.setEffect(reset_shadow);saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Mercury")) { mercury.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); earth.setEffect(reset_shadow);venus.setEffect(reset_shadow);mars.setEffect(reset_shadow);uranus.setEffect(reset_shadow);saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Earth")) { earth.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); venus.setEffect(reset_shadow);mars.setEffect(reset_shadow);uranus.setEffect(reset_shadow);saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Venus")) { venus.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); mars.setEffect(reset_shadow);uranus.setEffect(reset_shadow);saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Mars")) { mars.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); venus.setEffect(reset_shadow); uranus.setEffect(reset_shadow);saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Uranus")) { uranus.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); venus.setEffect(reset_shadow); mars.setEffect(reset_shadow); saturn.setEffect(reset_shadow);}
          else if (planets_combo.getValue().equals("Saturn")) { saturn.setEffect(shadow);jupiter.setEffect(reset_shadow); neptune.setEffect(reset_shadow); mercury.setEffect(reset_shadow); earth.setEffect(reset_shadow); venus.setEffect(reset_shadow); mars.setEffect(reset_shadow); uranus.setEffect(reset_shadow);}
          });
          
    }    
  

   @FXML
   protected void handleBack(ActionEvent event) throws IOException {            

      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseGame.fxml"));
      Parent root = (Parent)loader.load();
      ChooseGameController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    
    }
   @FXML
   protected void handleDone(ActionEvent event) throws IOException {            
       
       pane.setOpacity(1);
       Done.setDisable(true);
       Back.setDisable(true);
       planets_combo.setDisable(true);
       
        TranslateTransition transition= new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setFromX(0);
        transition.setFromY(-400);
        transition.setToX(0);
        transition.setToY(10);
        transition.setAutoReverse(false);
        transition.setCycleCount(0);
        transition.setNode(pane);
        transition.play();

        if (jupiter.getLayoutX()== 388 && jupiter.getLayoutY()== 184){
          score+=5;
        }
        if (neptune.getLayoutX()== 705 && neptune.getLayoutY()== 65){
            score+=5;
        }
        if (mercury.getLayoutX()== 66 && mercury.getLayoutY()== 65){
            score+=5;
        }
        if (earth.getLayoutX()== 215 && earth.getLayoutY()== 83){
           score+=5;
        }
        if (venus.getLayoutX()== 155 && venus.getLayoutY()== 305){
            score+=5;
        }        
        if (mars.getLayoutX()== 315 && mars.getLayoutY()== 340){
            score+=5;
        }    
        if (uranus.getLayoutX()== 605 && uranus.getLayoutY()== 315){
            score+=5;
        }
        if (saturn.getLayoutX()== 485 && saturn.getLayoutY()== 68){
            score+=5;
        }  

        
        if(score==0){
        ScoreLabel.setText("0");
        Grade.setText("You can do it next time");
        RightStar.setOpacity(1);
        LeftStar.setOpacity(1);
        CenterStar.setOpacity(1);
       }
        if(score==5){
        ScoreLabel.setText("5");
        Grade.setText("Good");
        RightStar.setOpacity(1);
        LeftStar.setOpacity(1);
       }
       if(score==10){
        ScoreLabel.setText("10");
        Grade.setText("Good");
        RightStar.setOpacity(1);
        LeftStar.setOpacity(1);
       }
       if(score==15){
        ScoreLabel.setText("15");
        Grade.setText("Good");
        RightStar.setOpacity(1);
        LeftStar.setOpacity(1);
       }
       if(score==20){
        ScoreLabel.setText("20");
        Grade.setText("Very Good");
         RightStar.setOpacity(1);
       }
       if(score==25){
        ScoreLabel.setText("25");
        Grade.setText("Very Good");
         RightStar.setOpacity(1);
       }
       if(score==30){
        ScoreLabel.setText("30");
        Grade.setText("Very Good");
         RightStar.setOpacity(1);
       }
       if(score==35){
        ScoreLabel.setText("35");
        Grade.setText("Ecellent");
       }
       if(score==40){
        ScoreLabel.setText("40");
        Grade.setText("Ecellent");
       }
        
       try{
         
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Player> pList = null;
        String queryStr1 = "from Player";
        Query query1 = session1.createQuery(queryStr1);
        pList =  query1.list();
        session1.close();
        
        Player player=new Player();
        for(Player p : pList){
            if(p.getUserName().equals(playerName))
                player=p;
        }
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Game newGame = new Game();
        newGame.setGameName("Order Planets");
        newGame.setUserName(player.getUserName());
        newGame.setScore(score);
        Transaction tx1 = session2.beginTransaction();
        session2.save(newGame);
        tx1.commit();
        session2.close(); 
        
        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session3.beginTransaction();
        player.setTotal_score(score+player.getTotal_score());
        session3.update(player);
        tx2.commit();
        session3.close();
        
        playerScore += score;
        
        }
       catch(Exception e){
            System.out.println("ERROE");
        }
      
       
   
   }
    
   
   @FXML
   protected void handleplanets_combo(ActionEvent event) throws IOException{


       
       if(planets_combo.getValue().equals("Jupiter")){  
           jupiter.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
            if (!((neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65) || (earth.getLayoutX()==66 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
            { 
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(73);
            jupiter.setFitHeight(73);
            jupiter.setLayoutX(66);
            jupiter.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT2){             
            if (!((neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305) || (earth.getLayoutX()==155 && earth.getLayoutY()==305)  ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305) ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(90);
            jupiter.setFitHeight(90);
            jupiter.setLayoutX(155);
            jupiter.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83) || (earth.getLayoutX()==215 && earth.getLayoutY()==83)  ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83) ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83))) 
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(108);
            jupiter.setFitHeight(107);
            jupiter.setLayoutX(215);
            jupiter.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340) || (earth.getLayoutX()==315 && earth.getLayoutY()==340)  ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340) ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(63);
            jupiter.setFitHeight(63);
            jupiter.setLayoutX(315);
            jupiter.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184) || (earth.getLayoutX()==388 && earth.getLayoutY()==184)  ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184) ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(183);
            jupiter.setFitHeight(184);
            jupiter.setLayoutX(388);
            jupiter.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68) || (earth.getLayoutX()==510 && earth.getLayoutY()==68)  ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68) ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {  
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(115);
            jupiter.setFitHeight(115);
            jupiter.setLayoutX(510);
            jupiter.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315) || (earth.getLayoutX()==630 && earth.getLayoutY()==315)  ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315) ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(81);
            jupiter.setFitHeight(81);
            jupiter.setLayoutX(630);
            jupiter.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65) || (earth.getLayoutX()==705 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67))) 
            {
            lbErr.setText("");
            jupiter.setEffect(reset_shadow);
            mediaPlayer.play();
            jupiter.setFitWidth(73);
            jupiter.setFitHeight(73);
            jupiter.setLayoutX(705);
            jupiter.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           });
            jupiter.requestFocus();
       }  
       
       if(planets_combo.getValue().equals("Neptune")){
           neptune.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
            if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65) || (earth.getLayoutX()==66 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(73);
            neptune.setFitHeight(73);
            neptune.setLayoutX(66);
            neptune.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){             
            if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305) || (earth.getLayoutX()==155 && earth.getLayoutY()==305)  ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305) ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(90);
            neptune.setFitHeight(90);
            neptune.setLayoutX(155);
            neptune.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83) || (earth.getLayoutX()==215 && earth.getLayoutY()==83)  ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83) ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83))) 
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(108);
            neptune.setFitHeight(107);
            neptune.setLayoutX(215);
            neptune.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340) || (earth.getLayoutX()==315 && earth.getLayoutY()==340)  ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340) ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(63);
            neptune.setFitHeight(63);
            neptune.setLayoutX(315);
            neptune.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184) || (earth.getLayoutX()==388 && earth.getLayoutY()==184)  ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184) ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(183);
            neptune.setFitHeight(184);
            neptune.setLayoutX(388);
            neptune.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68) || (earth.getLayoutX()==510 && earth.getLayoutY()==68)  ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68) ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(115);
            neptune.setFitHeight(115);
            neptune.setLayoutX(510);
            neptune.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315) || (earth.getLayoutX()==630 && earth.getLayoutY()==315)  ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315) ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(81);
            neptune.setFitHeight(81);
            neptune.setLayoutX(630);
            neptune.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65) || (earth.getLayoutX()==705 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67))) 
            {
            lbErr.setText("");
            neptune.setEffect(reset_shadow);
            mediaPlayer.play();
            neptune.setFitWidth(73);
            neptune.setFitHeight(73);
            neptune.setLayoutX(705);
            neptune.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           } 
           });
            neptune.requestFocus();
       }
       
       if(planets_combo.getValue().equals("Mercury")){
           mercury.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
            if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (earth.getLayoutX()==66 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(73);
            mercury.setFitHeight(73);
            mercury.setLayoutX(66);
            mercury.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT2){             
            if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (earth.getLayoutX()==155 && earth.getLayoutY()==305)  ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305) ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(90);
            mercury.setFitHeight(90);
            mercury.setLayoutX(155);
            mercury.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (earth.getLayoutX()==215 && earth.getLayoutY()==83)  ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83) ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83))) 
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(108);
            mercury.setFitHeight(107);
            mercury.setLayoutX(215);
            mercury.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (earth.getLayoutX()==315 && earth.getLayoutY()==340)  ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340) ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(63);
            mercury.setFitHeight(63);
            mercury.setLayoutX(315);
            mercury.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (earth.getLayoutX()==388 && earth.getLayoutY()==184)  ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184) ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(183);
            mercury.setFitHeight(184);
            mercury.setLayoutX(388);
            mercury.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (earth.getLayoutX()==510 && earth.getLayoutY()==68)  ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68) ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(115);
            mercury.setFitHeight(115);
            mercury.setLayoutX(510);
            mercury.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (earth.getLayoutX()==630 && earth.getLayoutY()==315)  ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315) ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(81);
            mercury.setFitHeight(81);
            mercury.setLayoutX(630);
            mercury.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (earth.getLayoutX()==705 && earth.getLayoutY()==65)  ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67))) 
            {
            lbErr.setText("");
            mercury.setEffect(reset_shadow);
            mediaPlayer.play();
            mercury.setFitWidth(73);
            mercury.setFitHeight(73);
            mercury.setLayoutX(705);
            mercury.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           });
            mercury.requestFocus();
       }
       
       if(planets_combo.getValue().equals("Earth")){
           earth.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
           if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65)  ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
           {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(73);
            earth.setFitHeight(73);
            earth.setLayoutX(66);
            earth.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){             
            if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305)  ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305) ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(90);
            earth.setFitHeight(90);
            earth.setLayoutX(155);
            earth.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83)  ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83) ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83))) 
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(108);
            earth.setFitHeight(107);
            earth.setLayoutX(215);
            earth.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340)  ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340) ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(63);
            earth.setFitHeight(63);
            earth.setLayoutX(315);
            earth.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184)  ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184) ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(183);
            earth.setFitHeight(184);
            earth.setLayoutX(388);
            earth.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68)  ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68) ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(115);
            earth.setFitHeight(115);
            earth.setLayoutX(510);
            earth.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315)  ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315) ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(81);
            earth.setFitHeight(81);
            earth.setLayoutX(630);
            earth.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65)  ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65) ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67))) 
            {
            lbErr.setText("");
            earth.setEffect(reset_shadow);
            mediaPlayer.play();
            earth.setFitWidth(73);
            earth.setFitHeight(73);
            earth.setLayoutX(705);
            earth.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           });
            earth.requestFocus();
       }
       
       if(planets_combo.getValue().equals("Venus")){
           venus.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
           if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==66 && earth.getLayoutY()==65) ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
           {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(73);
            venus.setFitHeight(73);
            venus.setLayoutX(66);
            venus.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){           
            if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305)  ||  (earth.getLayoutX()==155 && earth.getLayoutY()==305) ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(90);
            venus.setFitHeight(90);
            venus.setLayoutX(155);
            venus.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83)  ||  (earth.getLayoutX()==215 && earth.getLayoutY()==83) ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83))) 
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(108);
            venus.setFitHeight(107);
            venus.setLayoutX(215);
            venus.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340)  ||  (earth.getLayoutX()==315 && earth.getLayoutY()==340) ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(63);
            venus.setFitHeight(63);
            venus.setLayoutX(315);
            venus.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184)  ||  (earth.getLayoutX()==388 && earth.getLayoutY()==184) ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(183);
            venus.setFitHeight(184);
            venus.setLayoutX(388);
            venus.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68)  ||  (earth.getLayoutX()==510 && earth.getLayoutY()==68) ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(115);
            venus.setFitHeight(115);
            venus.setLayoutX(510);
            venus.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315)  ||  (earth.getLayoutX()==630 && earth.getLayoutY()==315) ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(81);
            venus.setFitHeight(81);
            venus.setLayoutX(630);
            venus.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==705 && earth.getLayoutY()==65) ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67)))
            {
            lbErr.setText("");
            venus.setEffect(reset_shadow);
            mediaPlayer.play();
            venus.setFitWidth(73);
            venus.setFitHeight(73);
            venus.setLayoutX(705);
            venus.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           });
            venus.requestFocus();
       }
       //Mars
       if(planets_combo.getValue().equals("Mars")){
           mars.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
           if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==66 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65)  ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
           {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(73);
            mars.setFitHeight(73);
            mars.setLayoutX(66);
            mars.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){             
            if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305)  ||  (earth.getLayoutX()==155 && earth.getLayoutY()==305) ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305)  ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))   
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(90);
            mars.setFitHeight(90);
            mars.setLayoutX(155);
            mars.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT3){            
            if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83)  ||  (earth.getLayoutX()==215 && earth.getLayoutY()==83) ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83)  ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83)))
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(108);
            mars.setFitHeight(107);
            mars.setLayoutX(215);
            mars.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
            }
           else if(e.getCode()==KeyCode.DIGIT4){            
            if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340)  ||  (earth.getLayoutX()==315 && earth.getLayoutY()==340) ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340)  ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(63);
            mars.setFitHeight(63);
            mars.setLayoutX(315);
            mars.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
            if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184)  ||  (earth.getLayoutX()==388 && earth.getLayoutY()==184) ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184)  ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184))) 
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(183);
            mars.setFitHeight(184);
            mars.setLayoutX(388);
            mars.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
            if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68)  ||  (earth.getLayoutX()==510 && earth.getLayoutY()==68) ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68)  ||  (uranus.getLayoutX()==485 && uranus.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68))) 
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(115);
            mars.setFitHeight(115);
            mars.setLayoutX(510);
            mars.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
            if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315)  ||  (earth.getLayoutX()==630 && earth.getLayoutY()==315) ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315)  ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))  
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(81);
            mars.setFitHeight(81);
            mars.setLayoutX(630);
            mars.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
            if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==705 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65)  ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67))) 
            {
            lbErr.setText("");
            mars.setEffect(reset_shadow);
            mediaPlayer.play();
            mars.setFitWidth(73);
            mars.setFitHeight(73);
            mars.setLayoutX(705);
            mars.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           });
            mars.requestFocus();
       }
       
       if(planets_combo.getValue().equals("Uranus")){
           uranus.setOnKeyPressed(e -> {if(e.getCode()==KeyCode.DIGIT1){ 
           if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==66 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65)  ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65) ||  (saturn.getLayoutX()==50 && saturn.getLayoutY()==65)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(115);
            uranus.setFitHeight(73);
            uranus.setLayoutX(50);
            uranus.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){             
           if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305)  ||  (earth.getLayoutX()==155 && earth.getLayoutY()==305) ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305)  ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305) ||  (saturn.getLayoutX()==135 && saturn.getLayoutY()==305)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(132);
            uranus.setFitHeight(90);
            uranus.setLayoutX(135);
            uranus.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT3){            
           if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83)  ||  (earth.getLayoutX()==215 && earth.getLayoutY()==83) ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83)  ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83) ||  (saturn.getLayoutX()==200 && saturn.getLayoutY()==83)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(140);
            uranus.setFitHeight(100);
            uranus.setLayoutX(200);
            uranus.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT4){            
           if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340)  ||  (earth.getLayoutX()==315 && earth.getLayoutY()==340) ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340)  ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340) ||  (saturn.getLayoutX()==295 && saturn.getLayoutY()==340)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(100);
            uranus.setFitHeight(63);
            uranus.setLayoutX(295);
            uranus.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
           if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184)  ||  (earth.getLayoutX()==388 && earth.getLayoutY()==184) ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184)  ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184) ||  (saturn.getLayoutX()==366 && saturn.getLayoutY()==184)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(220);
            uranus.setFitHeight(130);
            uranus.setLayoutX(366);
            uranus.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
           if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68)  ||  (earth.getLayoutX()==510 && earth.getLayoutY()==68) ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68)  ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68) ||  (saturn.getLayoutX()==485 && saturn.getLayoutY()==68)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(160);
            uranus.setFitHeight(105);
            uranus.setLayoutX(485);
            uranus.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
           if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315)  ||  (earth.getLayoutX()==630 && earth.getLayoutY()==315) ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315)  ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315) ||  (saturn.getLayoutX()==605 && saturn.getLayoutY()==315)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(130);
            uranus.setFitHeight(81);
            uranus.setLayoutX(605);
            uranus.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
           if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==705 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65)  ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65) ||  (saturn.getLayoutX()==681 && saturn.getLayoutY()==67)))
           {
            lbErr.setText("");
            uranus.setEffect(reset_shadow);
            mediaPlayer.play();
            uranus.setFitWidth(115);
            uranus.setFitHeight(73);
            uranus.setLayoutX(681);
            uranus.setLayoutY(67);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           } 
           });
            uranus.requestFocus();
       }       
       //Saturn
        if(planets_combo.getValue().equals("Saturn")){
           saturn.setOnKeyPressed(e -> { if(e.getCode()==KeyCode.DIGIT1){ 
           if (!((jupiter.getLayoutX()==66 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==66 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==66 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==66 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==66 && venus.getLayoutY()==65)  ||  (mars.getLayoutX()==66 && mars.getLayoutY()==65) ||  (uranus.getLayoutX()==50 && uranus.getLayoutY()==65)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(115);
            saturn.setFitHeight(73);
            saturn.setLayoutX(50);
            saturn.setLayoutY(65);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT2){             
           if (!((jupiter.getLayoutX()==155 && jupiter.getLayoutY()==305) || (neptune.getLayoutX()==155 && neptune.getLayoutY()==305) || (mercury.getLayoutX()==155 && mercury.getLayoutY()==305)  ||  (earth.getLayoutX()==155 && earth.getLayoutY()==305) ||  (venus.getLayoutX()==155 && venus.getLayoutY()==305)  ||  (mars.getLayoutX()==155 && mars.getLayoutY()==305) ||  (uranus.getLayoutX()==135 && uranus.getLayoutY()==305)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(132);
            saturn.setFitHeight(90);
            saturn.setLayoutX(135);
            saturn.setLayoutY(305);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT3){            
           if (!((jupiter.getLayoutX()==215 && jupiter.getLayoutY()==83) || (neptune.getLayoutX()==215 && neptune.getLayoutY()==83) || (mercury.getLayoutX()==215 && mercury.getLayoutY()==83)  ||  (earth.getLayoutX()==215 && earth.getLayoutY()==83) ||  (venus.getLayoutX()==215 && venus.getLayoutY()==83)  ||  (mars.getLayoutX()==215 && mars.getLayoutY()==83) ||  (uranus.getLayoutX()==200 && uranus.getLayoutY()==83)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(140);
            saturn.setFitHeight(100);
            saturn.setLayoutX(200);
            saturn.setLayoutY(83);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT4){            
           if (!((jupiter.getLayoutX()==315 && jupiter.getLayoutY()==340) || (neptune.getLayoutX()==315 && neptune.getLayoutY()==340) || (mercury.getLayoutX()==315 && mercury.getLayoutY()==340)  ||  (earth.getLayoutX()==315 && earth.getLayoutY()==340) ||  (venus.getLayoutX()==315 && venus.getLayoutY()==340)  ||  (mars.getLayoutX()==315 && mars.getLayoutY()==340) ||  (uranus.getLayoutX()==295 && uranus.getLayoutY()==340)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(100);
            saturn.setFitHeight(63);
            saturn.setLayoutX(295);
            saturn.setLayoutY(340);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT5){            
           if (!((jupiter.getLayoutX()==388 && jupiter.getLayoutY()==184) || (neptune.getLayoutX()==388 && neptune.getLayoutY()==184) || (mercury.getLayoutX()==388 && mercury.getLayoutY()==184)  ||  (earth.getLayoutX()==388 && earth.getLayoutY()==184) ||  (venus.getLayoutX()==388 && venus.getLayoutY()==184)  ||  (mars.getLayoutX()==388 && mars.getLayoutY()==184) ||  (uranus.getLayoutX()==366 && uranus.getLayoutY()==184)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(220);
            saturn.setFitHeight(130);
            saturn.setLayoutX(366);
            saturn.setLayoutY(184);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }   
           else if(e.getCode()==KeyCode.DIGIT6){            
           if (!((jupiter.getLayoutX()==510 && jupiter.getLayoutY()==68) || (neptune.getLayoutX()==510 && neptune.getLayoutY()==68) || (mercury.getLayoutX()==510 && mercury.getLayoutY()==68)  ||  (earth.getLayoutX()==510 && earth.getLayoutY()==68) ||  (venus.getLayoutX()==510 && venus.getLayoutY()==68)  ||  (mars.getLayoutX()==510 && mars.getLayoutY()==68) ||  (uranus.getLayoutX()==485 &&  uranus.getLayoutY()==68)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(160);
            saturn.setFitHeight(105);
            saturn.setLayoutX(485);
            saturn.setLayoutY(68);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT7){            
           if (!((jupiter.getLayoutX()==630 && jupiter.getLayoutY()==315) || (neptune.getLayoutX()==630 && neptune.getLayoutY()==315) || (mercury.getLayoutX()==630 && mercury.getLayoutY()==315)  ||  (earth.getLayoutX()==630 && earth.getLayoutY()==315) ||  (venus.getLayoutX()==630 && venus.getLayoutY()==315)  ||  (mars.getLayoutX()==630 && mars.getLayoutY()==315) ||  (uranus.getLayoutX()==605 && uranus.getLayoutY()==315)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(130);
            saturn.setFitHeight(81);
            saturn.setLayoutX(605);
            saturn.setLayoutY(315);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           }
           else if(e.getCode()==KeyCode.DIGIT8){            
           if (!((jupiter.getLayoutX()==705 && jupiter.getLayoutY()==65) || (neptune.getLayoutX()==705 && neptune.getLayoutY()==65) || (mercury.getLayoutX()==705 && mercury.getLayoutY()==65)  ||  (earth.getLayoutX()==705 && earth.getLayoutY()==65) ||  (venus.getLayoutX()==705 && venus.getLayoutY()==65)  ||  (mars.getLayoutX()==705 && mars.getLayoutY()==65) ||  (uranus.getLayoutX()==681 && uranus.getLayoutY()==67)))
           {
            lbErr.setText("");
            saturn.setEffect(reset_shadow);
            mediaPlayer.play();
            saturn.setFitWidth(115);
            saturn.setFitHeight(73);
            saturn.setLayoutX(681);
            saturn.setLayoutY(67);} else {lbErr.setText("Don't put 2 planet in the same orbit !");}
           } 
           });
            saturn.requestFocus();
       }

           
   }
    


    public void current_player(String player, int score){
        playerName =player;
        playerScore =score;
    }

    @FXML
    private void handleOk(ActionEvent event)  throws IOException {
        
      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseGame.fxml"));
      Parent root = (Parent)loader.load();
      ChooseGameController secondControl_1 = loader.getController();
      
      secondControl_1.current_player(playerName,playerScore);

     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(new Scene(root));
     window.show();
    }

 
}
