import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FenetreRegleJeu extends JFrame{

    private JLabel regle;
    private JLabel vide;
    private String regleJeu;

    private JPanel monPanelAffichageRegle;

    public FenetreRegleJeu(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        monPanelAffichageRegle = new JPanel(new BorderLayout());

        regle = new JLabel("<html>Objectif : eliminer tous les pions de son adversaire. <br> Regles du jeu : Le jeu se fait sur un plateau de 100 cases (alterne noir et blanc). Les pions se deplacent en diagonale (avant et arriere) d une seule case, sauf lorsqu un pion elimine un pion adverse. Pour eliminer un pion de l adversaire, il faut se trouver a cote du pion, en diagonale et pouvoir sauter au dessus de lui pour pouvoir lui prendre son pion. <br> Option Dame : si un pion arrive sur la premiere ligne de l adversaire, le pion devient alors une dame. Ce nouveau pion peut alors se deplacer, toujours en diagonale, du nombre de case qu il souhaite. Pour eliminer des pions, il doit en revanche pouvoir aussi sauter au-dessus d eux.</html>");

        regle.setHorizontalAlignment(SwingConstants.TRAILING);

        monPanelAffichageRegle.add(regle);
		
        vide = new JLabel("");

        monPanelAffichageRegle.add(regle, BorderLayout.CENTER);
        monPanelAffichageRegle.add(vide, BorderLayout.SOUTH);
        monPanelAffichageRegle.add(vide, BorderLayout.NORTH);

        setContentPane(monPanelAffichageRegle);

        //rendre la fenêtre visible
        setVisible(true);
    }
}
