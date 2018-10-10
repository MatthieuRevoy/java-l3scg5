/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquin_grp5;

import java.util.HashSet;

/**
 *
 * @author AsusCi7
 */
public class Grille {
    public class Grille implements Parametres {

    private final HashSet<Case> grille;
    private int valeurMax = 0;
    private boolean deplacement;

    public Grille() {
        this.grille = new HashSet<>();
    }
}
