/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin_grp5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 
 * @author mback
 */
public class Taquin_grp5 extends Application implements Parametres {
    
    @Override
    public void start(Stage stage) throws Exception  {
        try {
            stage.setTitle("Taquin");
            Group root = new Group();
            Scene scene = new Scene(root, 1000, 750, Color.LIGHTBLUE);
            Plateau p = new Plateau();
            p.initPlateau();
          
            root.getChildren().add(p);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.requestFocus();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        /*
        *@exception  
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Taquin_grp5.class, args);
    }
    
}
