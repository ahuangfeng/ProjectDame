/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author AlexHF
 */
public class Lanceur extends JFrame{

    /**
     * @param args the command line arguments
     */
     
    private JPanel PanelGlobalScore;
    
       
     public Lanceur(){   
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Plateau plat = new Plateau();
        plat.initialiser();
        PanelGlobalScore = new JPanel(new BorderLayout());
        PanelGlobalScore.add(plat,BorderLayout.CENTER);
        setContentPane(PanelGlobalScore);
        setVisible(true);
    }    
        //maFenetreScore esc = new maFenetreScore();
        //FenetreFin ola = new FenetreFin();
}
