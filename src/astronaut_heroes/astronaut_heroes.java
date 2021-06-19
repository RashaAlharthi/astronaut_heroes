/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronaut_heroes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ath77
 */



public class astronaut_heroes extends Application {
    
  
    @Override
    public void start(Stage primaryStage)throws Exception{
        try {
    Parent root = FXMLLoader.load(getClass().getResource("welcome1.fxml"));

    primaryStage.setTitle("Astronaut hero");
    
    Scene scene1 = new Scene(root, 800, 515);
    primaryStage.setScene(scene1);
    primaryStage.show();
    } catch (IOException ex) {
    Logger.getLogger(astronaut_heroes.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
