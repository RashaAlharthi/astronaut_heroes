package astronaut_heroes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Russa
 */
public class Scores6Controller implements Initializable {
    String path = "mouse_voice.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    private String playerName;
    private int playerScore;
    @FXML private ComboBox game;
    @FXML private Label top10;
    @FXML private Button Back;
    @FXML TableView<Game> Scores;
    @FXML TableColumn<Game,Integer> Rank = new TableColumn<Game, Integer>("#");
    @FXML TableColumn<Game,String> userName;
    @FXML TableColumn<Game,String> gameName;
    @FXML TableColumn<Game,Integer> score;

    @FXML
    private ImageView rock1;
    @FXML
    private ImageView rock2;
    @FXML
    private ImageView astro;
 
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        game.getItems().addAll("Order Planets","Which Planet");
        top10.textProperty().bind(game.getSelectionModel().selectedItemProperty());
        game.setValue("Order Planets");  

        Session session0 = HibernateUtil.getSessionFactory().openSession();
        List<Game> gList = null;
        String queryStr1 = "from Game where gameName ='Order Planets'"; //add top 10
        Query query1 = session0.createQuery(queryStr1);
        gList =  query1.list();
        session0.close();
        
        ObservableList<Game> List=FXCollections.observableArrayList(gList);
//        for (int i = 0; i < gList.size()-1; i++) {
//            for (int j = 1; j < gList.size(); j++) {
//                if((gList.get(i).getUserName().equals(gList.get(j).getUserName()))){
//                    List.remove(gList.get(j));
//                }
//            }
//        }
        
                Rank.setCellValueFactory(col-> new ReadOnlyObjectWrapper<Integer>(Scores.getItems().indexOf(col.getValue())+1));
                userName.setCellValueFactory(new PropertyValueFactory<Game,String> ("userName"));
                gameName.setCellValueFactory(new PropertyValueFactory<Game,String> ("gameName"));
                score.setCellValueFactory(new PropertyValueFactory<Game,Integer> ("score"));

                Scores.setItems(List);
                score.setSortType(TableColumn.SortType.DESCENDING);
                Scores.getSortOrder().add(score);
                Scores.sort();
    }    
    
    @FXML
    protected void handleGame(ActionEvent event)throws IOException{
        if(game.getValue().equals("Order Planets")){
                Session session0 = HibernateUtil.getSessionFactory().openSession();
                 List<Game> gList = null;
                String queryStr1 = "from Game where gameName ='Order Planets'";
                Query query1 = session0.createQuery(queryStr1);
                gList =  query1.list();
                session0.close();
                ObservableList<Game> List=FXCollections.observableArrayList(gList);
//                        for (int i = 0; i < gList.size()-1; i++) {
//                            for (int j = 1; j < gList.size(); j++) {
//                                if ((gList.get(i).getUserName().equals(gList.get(j).getUserName()))){
//                                    List.remove(gList.get(j));
//                                }
//                            }
//                        }                
                Scores.setItems(List);
                score.setSortType(TableColumn.SortType.DESCENDING);
                Scores.getSortOrder().add(score);
                Scores.sort();}
            if(game.getValue().equals("Which Planet")){
                Session session0 = HibernateUtil.getSessionFactory().openSession();
                 List<Game> gList = null;
                String queryStr2 = "from Game where gameName ='Which Planet'";
                Query query2 = session0.createQuery(queryStr2);
                gList =  query2.list();
                session0.close();
                
                ObservableList<Game> List=FXCollections.observableArrayList(gList);
//                        for (int i = 0; i < gList.size()-1; i++) {
//                            for (int j = 1; j < gList.size(); j++) {
//                                if ((gList.get(i).getUserName().equals(gList.get(j).getUserName()))){
//                                    List.remove(gList.get(j));
//                                }
//                            }
//                        } 
                Scores.setItems(List);
                score.setSortType(TableColumn.SortType.DESCENDING);
                Scores.getSortOrder().add(score);
                Scores.sort();}
    }

     @FXML
   protected void handleBack(ActionEvent event) throws IOException {            

      mediaPlayer.play();
           
      FXMLLoader loader = new FXMLLoader(getClass().getResource("educationOrTraining4.fxml"));
      Parent root = (Parent)loader.load();
      EducationOrTraining4Controller secondControl_1 = loader.getController();
      
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
