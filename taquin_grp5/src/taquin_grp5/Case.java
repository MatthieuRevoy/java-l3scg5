/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin_grp5;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * Describe and methods of hut
 * @author AsusCi7
 */
public class Case extends Parent implements Parametres {

    private int x, y, valeur;
    private Grille grille;

    /**
     *
     */
    public Text symbole;
    
    Rectangle fond_case;

    /**
     * hut constructor
     * @param abs abscissa of hut
     * @param ord ordinate of hut
     * @param v value of hut
     */
    public Case(int abs, int ord, int v) { 
        this.x = abs;
        this.y = ord;
        this.valeur = v;
    }
    
    /**
     * graphic hut constructor
     * @param l value on hut
     * @param X abscissa of hut in graphic plate
     * @param Y ordinate of hut in graphic plate
     */
    public Case(String l, int X, int Y){ 
        
        fond_case = new Rectangle(90,90,Color.WHITE);
        fond_case.setArcHeight(10);
        fond_case.setArcWidth(10);
        this.getChildren().add(fond_case);
        
        symbole = new Text(l);
        symbole.setFont(new Font(40));
        symbole.setFill(Color.BURLYWOOD);
        symbole.setX(30);
        symbole.setY(50);
        this.getChildren().add(symbole);
        this.setTranslateX(X);
        this.setTranslateY(Y);
        
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                fond_case.setFill(Color.LIGHTGREY);
            }
            /*
            *Change color of hut on mouse enterd
            *@param <MouseEvent> mouse entered
            */
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                fond_case.setFill(Color.WHITE);
            }
            /*
            *reset color of hut on mouse exited
            *@param <MouseEvent> mouse exited
            */
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            }
            /*
            *move hut on mouse click
            *@param<MouseEvent> mouse click
            */
        });


        
    }

    /**
     * get X coordinate
     * @return x coordinate of hut
     */
    public int getX() { 
        return this.x;
    }

    /**
     * get Y coordinate
     * @return y coordinate of hut
     */
    public int getY() { 
        return this.y;
    }

    /**
     * set X coordinate
     * @param x abscissa coordinate
     */
    public void setX(int x) { 
        this.x = x;
    }

    /**
     * set Y coordinate
     * @param y ordinate coordinate
     */
    public void setY(int y) { 
        this.y = y;
    }

    /**
     * set value
     * @param valeur value of hut
     */
    public void setValeur(int valeur) { 
        this.valeur = valeur;
    }

    /**
     * get value
     * @return value of hut
     */
    public int getValeur() { 
        return this.valeur;
    }
    
    /**
     * move coordinate of hut
     * @param direction
     * @return hut
     */
    public Case getVoisinDirect(int direction) { 
        switch (direction) {
            case HAUT:
                for (int i = this.y - 1; i >= 0; i--) {
                    for (Case c : grille.getGrille()) {
                        if (c.getX() == this.x && c.getY() == i) {
                            return c;
                        }
                    }
                }   break;
            case BAS:
                for (int i = this.y + 1; i < TAILLE; i++) {
                    for (Case c : grille.getGrille()) {
                        if (c.getX() == this.x && c.getY() == i) {
                            return c;
                        }
                    }
                }   break;
            case GAUCHE:
                for (int i = this.x - 1; i >= 0; i--) {
                    for (Case c : grille.getGrille()) {
                        if (c.getX() == i && c.getY() == this.y) {
                            return c;
                        }
                    }
                }   break;
            case DROITE:
                for (int i = this.x + 1; i < TAILLE; i++) {
                    for (Case c : grille.getGrille()) {
                        if (c.getX() == i && c.getY() == this.y) {
                            return c;
                        }
                    }
                }   break;
            default:
                break;
        }
        return null;
    }

    @Override
    public String toString() { // redéfinit l'affichage d'une case
        return "Case(" + this.x + "," + this.y + "," + this.valeur + ")";
        /*
        *override toString() method for hut
        *@return void
        */
    }
    
   
}

