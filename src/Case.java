/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */

import java.awt.*;
import javax.swing.JPanel;
public class Case extends JPanel {
    
    private int couleur;
    private boolean selectionnee;
    private boolean choisie;
    
    public Case(int u){
        setLayout(new GridLayout(1,0));
        this.couleur=u;
        if(u==0){
            setBackground(Color.DARK_GRAY);
        }else if(u==1){
            setBackground(Color.WHITE);
        }
        this.choisie = false;
    }

    public boolean estChoisie(){
        return choisie;
    }

    public void setChoisie(boolean choisie){
        this.choisie=choisie;
    }
}



