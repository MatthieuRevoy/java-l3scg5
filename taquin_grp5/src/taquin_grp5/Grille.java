/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin_grp5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;


/**
 * ArrayList of hut
 * @author AsusCi7
 */
public class Grille implements Parametres {

    private final ArrayList<Case> grille;

    /**
     *
     */
    public Grille() { 
        this.grille = new ArrayList<>();
        
        /*
        *plate constructor
        */
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Case> getGrille(){ 
        return this.grille;
        /*
        *get List of hut
        *@return ArrayList<Case>
        */
    }
    
    /**
     * get hut according to coordinate
     * @param abs abscissa of hut
     * @param ord ordinate of hut
     * @return hut
     */
    public Case getCase(int abs, int ord){ 
        
        for (Case c : this.grille){
            if (c.getX() == abs && c.getY() == ord){
                return c;
            }
        }
        return null;
    }
    
    /**
     * Initialize plate
     */
    public void initGrille(){ 
        
        int abs;
        int ord;
        HashSet<Integer> listeVal = new HashSet<>();
        Random ra = new Random();
        for(int i = 0; i<16;i++){
            listeVal.add(i);
        }
        while(!listeVal.isEmpty() && this.grille.size() < 17){
            for (ord=0; ord<4; ord++){
                for (abs=0; abs<4; abs++){
                    int i = ra.nextInt(16);
                    if(listeVal.contains(i)){
                        Case c = new Case(abs, ord, i);
                        this.grille.add(c);
                        listeVal.remove(i);
                    }else{
                        abs--;
                    }
                }
            }
        }
    }
    
    /**
     * move hut in plate according to direction
     * @param direction
     */
    public void Deplacement(int direction){ 
        
        int x = 0;
        int y = 0;
        for (Case c : this.grille){
            if(c.getValeur() == 0){
                x = c.getX();
                y = c.getY();
                c = new Case(x, y, 0);
            }
            if(x==0){
                if(y==0){
                    if(direction == DROITE){
                        Case t = new Case(1, 0, getValeurCoor(1, 0));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == BAS){
                        Case t = new Case(0, 1, getValeurCoor(0, 1));
                        this.EchangerBloc(c, t);
                    }
                }
                if(y==3){
                    if(direction == DROITE){
                        Case t = new Case(1, 3, getValeurCoor(1, 3));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == HAUT){
                        Case t = new Case(0, 2, getValeurCoor(0, 2));
                        this.EchangerBloc(c, t);
                    }
                }else{
                    if(direction == DROITE){
                        Case t = new Case(x+1, y, getValeurCoor(x+1, y));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == HAUT){
                        Case t = new Case(x, y-1, getValeurCoor(x, y-1));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == BAS){
                        Case t = new Case(x, y+1, getValeurCoor(x, y+1));
                        this.EchangerBloc(c, t);
                    }
                }
            }
            if(x==3){
                if(y==0){
                    if(direction == GAUCHE){
                        Case t = new Case(2, 0, getValeurCoor(2, 0));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == BAS){
                        Case t = new Case(3, 1, getValeurCoor(3, 1));
                        this.EchangerBloc(c, t);
                    }
                }
                if(y==3){
                    if(direction == GAUCHE){
                        Case t = new Case(2, 3, getValeurCoor(2, 3));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == HAUT){
                        Case t = new Case(3, 2, getValeurCoor(3, 2));
                        this.EchangerBloc(c, t);
                    }
                }else{
                    if(direction == GAUCHE){
                        Case t = new Case(x-1, y, getValeurCoor(x-1, y));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == HAUT){
                        Case t = new Case(x, y-1, getValeurCoor(x, y-1));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == BAS){
                        Case t = new Case(x, y+1, getValeurCoor(x, y+1));
                        this.EchangerBloc(c, t);
                    }
                }
            }
            if(y==0){
                if(x==1 || x==2){
                    if(direction == GAUCHE){
                        Case t = new Case(x-1, 0, getValeurCoor(x-1, 0));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == DROITE){
                        Case t = new Case(x+1, 0, getValeurCoor(x+1, 0));
                        this.EchangerBloc(c, t);
                    }
                    if(direction == BAS){
                        Case t = new Case(x, 1, getValeurCoor(x, 1));
                        this.EchangerBloc(c, t);
                    }
                }
            }
            if(y==3){
                if(direction == GAUCHE){
                    Case t = new Case(x-1, 3, getValeurCoor(x-1, 3));
                    this.EchangerBloc(c, t);
                }
                if(direction == DROITE){
                    Case t = new Case(x+1, 3, getValeurCoor(x+1, 3));
                    this.EchangerBloc(c, t);
                }
                if(direction == HAUT){
                    Case t = new Case(x, 2, getValeurCoor(x, 2));
                    this.EchangerBloc(c, t);
                }
            }else{
                if(direction == GAUCHE){
                    Case t = new Case(x-1, y, getValeurCoor(x-1, y));
                    this.EchangerBloc(c, t);
                }
                if(direction == DROITE){
                    Case t = new Case(x+1, y, getValeurCoor(x+1, y));
                    this.EchangerBloc(c, t);
                }
                if(direction == HAUT){
                    Case t = new Case(x, y-1, getValeurCoor(x, y-1));
                    this.EchangerBloc(c, t);
                }
                if(direction == BAS){
                        Case t = new Case(x, y+1, getValeurCoor(x, y+1));
                        this.EchangerBloc(c, t);
                }
            }
        }
    }
    
    /**
     * exchange value of hut
     * @param c hut
     * @param t hut
     */
    public void EchangerBloc(Case c, Case t){
        
        Case temp = null;
        temp = new Case(t.getX(),t.getY(),c.getValeur());
        this.grille.add(temp);
        this.grille.remove(t);
        temp = new Case(c.getX(), c.getY(), t.getValeur());
        this.grille.add(temp);
        this.grille.remove(c);
    }
    
    /**
     * sign plate
     */
    public void AfficherGrille(){
        
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                System.out.print("[" + this.getCase(i, j).getValeur() + "] ");
            }
            System.out.println();
        }
        System.out.print("\n");
        System.out.print("\n");
    }
    
    /**
     * get value of hut according to coordinate
     * @param abs abscissa of hut
     * @param ord ordinate of hut
     * @return value
     */
    public int getValeurCoor(int abs, int ord){
        
        int i = 0;
        boolean trouve = false;
        Iterator<Case> hs = this.grille.iterator();
        while(hs.hasNext() && !trouve){
            if(hs.next().getX() == abs && hs.next().getY() == ord){
                i = this.getCase(abs, ord).getValeur();
                trouve = true;
            }
        }
        return i;
    }
    
    /**
     * set value of hut according to coordinate
     * @param abs abscissa of hut
     * @param ord ordinate of hut
     * @param v value to set on hut
     */
    public void setValeurCoor(int abs, int ord, int v){
        
        Iterator<Case> hs = this.grille.iterator();
        while(hs.hasNext()){
            if(hs.next().getX() == abs && hs.next().getY() == ord){
                this.getCase(abs, ord).setValeur(v);
            }
        }
    }

    /**
     * condition of game victory
     * @return boolean
     */
    public boolean Victory(){
        
        boolean victory = true;
        for(int i = 1; i<16; i++){
            for(Case c : this.grille){
                if(c.getX() == ((i-1)%4) && c.getY() == ((i-1)/4)){
                    if(c.getValeur() != i){
                        victory = false;
                    }
                }
            }
        }
        return victory;
    }
}
