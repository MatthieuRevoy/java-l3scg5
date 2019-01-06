/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin_grp5;


import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author mback
 */
public class Plateau extends Parent{ 
    
    /**
     *
     */
    public Plateau(){ 
        
        Rectangle fond_plateau = new Rectangle();
        fond_plateau.setWidth(410);
        fond_plateau.setHeight(410);
        fond_plateau.setFill(Color.BLACK);
        
        this.setTranslateX(300);
        this.setTranslateY(300);
        this.getChildren().add(fond_plateau);
        
        this.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCharacter().compareTo("q") == 0){
                    
                }
                
                /*
                *Override key event to move hut
                *@param<KeyEvent> key of direction
                */
            }
        });
        /*
        * Graphic plate constructor
        */
    }
    
    /**
     *
     */
    public void initPlateau(){ 
    
        Plateau p = new Plateau();
        Grille g = new Grille();
        Case c;
        String s;
        g.initGrille();
        for(int i=0; i<16; i++){
            s = (""+g.getGrille().get(i).getValeur()+"");
            int x = 10 + (i%4)*100;
            int y = 10 + (i/4)*100;
            if(s.compareTo("0") != 0){
                c = new Case(s, x, y);
            }else{
                c = new Case("", x, y);
            }
            this.getChildren().add(c);
        }  
    }
    /*
    * Initialize graphic plate
    * @return void
    */
}