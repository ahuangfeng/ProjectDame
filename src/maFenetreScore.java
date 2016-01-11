
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.awt.event.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Thread;

public class maFenetreScore extends JFrame {

    //création des variables
    private JLabel nomJoueurUn;
    private JLabel nomJoueurDeux;
    private JLabel nbPionsMangesJ1;
    private JLabel nbPionsRestantsJ1;
    private JLabel nbPionsMangesJ2;
    private JLabel nbPionsRestantsJ2;
    private JLabel tempsEcoule;
    private JLabel vide;
    private JLabel tour;

    public static int nbMangesJ1 = 0;
    private int nbRestantJ1 = 22;

    public static int nbMangesJ2 = 0;
    private int nbRestantJ2 = 22;

    public JPanel monPanelAffichageDonnees;
    private JPanel PanelGlobalScore;

    private JButton btnFinDeJeu;
    private EcouteurBoutonFinDeJeu ecFinJeu;
    public Plateau plat;
    private String turn;
    private String j1;
    private String j2;

    public static int nbPionAvalesJ1;
    private Cronometre temps;

    //public static String vainqueur;

    public maFenetreScore(String nom1, String nom2, FenetreInit ini) {
        super("Jeu de Dame");
        j1 = nom1;
        j2 = nom2;

        //définir la taille et la fermeture par défaut
        setSize(830, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monPanelAffichageDonnees = new JPanel(new GridLayout(17, 1));
        PanelGlobalScore = new JPanel(new BorderLayout());
        //creer plateau
        this.plat = new Plateau(this, ini);
        plat.initialiser();
        PanelGlobalScore.add(plat, BorderLayout.CENTER);

        ecFinJeu = new EcouteurBoutonFinDeJeu(this);
        btnFinDeJeu = new JButton("Fin du jeu");
        btnFinDeJeu.addActionListener(ecFinJeu);

        this.temps = new Cronometre();

        nomJoueurUn = new JLabel("      " + this.j1);
        //Statistiques pions mangés
        this.nbMangesJ1 = plat.getNbPionsSautesJ1();
        System.out.println(this.nbMangesJ1);
        this.nbRestantJ1 = this.nbRestantJ1 - this.nbMangesJ1;
        this.nbMangesJ2 = plat.getNbPionsSautesJ2();
        this.nbRestantJ2 = this.nbRestantJ2 - this.nbMangesJ2;
        this.nbPionsMangesJ1 = new JLabel("      Nombre de pions manges : " + this.nbMangesJ1);

        this.nbPionsRestantsJ1 = new JLabel("      Nombre de pions a eliminer restant : " + nbRestantJ1);

        nomJoueurDeux = new JLabel("      " + this.j2);
        //a modifier avec la classe joueur
        nbPionsMangesJ2 = new JLabel("      Nombre de pions manges : " + this.nbMangesJ2);
        nbPionsRestantsJ2 = new JLabel("      Nombre de pions a eliminer restant : " + nbRestantJ2);

        this.turn = "";
        if (this.plat.getTour() == true) {
            turn = "Blanc";
        } else {
            turn = "Marron";
        }
        this.tour = new JLabel("    Tour : " + turn);
        vide = new JLabel("");
        //organisation des éléments constitutifs de la fenetre
        monPanelAffichageDonnees.add(nomJoueurUn);
        monPanelAffichageDonnees.add(nbPionsMangesJ1);
        monPanelAffichageDonnees.add(nbPionsRestantsJ1);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(nomJoueurDeux);
        monPanelAffichageDonnees.add(nbPionsMangesJ2);
        monPanelAffichageDonnees.add(nbPionsRestantsJ2);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(this.tour);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(this.temps);
        monPanelAffichageDonnees.add(btnFinDeJeu);
        //monPanelAffichageDonnees.add(tempsEcoule);

        PanelGlobalScore.add(monPanelAffichageDonnees, BorderLayout.EAST);
        //PanelGlobalScore.add(tempsEcoule, BorderLayout.SOUTH);

        setContentPane(PanelGlobalScore);

        //rendre la fenêtre visible
        setVisible(true);
    }

    public Cronometre getCrono() {
        return this.temps;
    }

    public JPanel getPanelScore() {
        return this.PanelGlobalScore;
    }

    //méthode pour mettre à jour le nombre de pions mangés du joueur 1
    public void setPionsMangesJ1(int nom, int res) {
        if (nom != this.nbMangesJ1) {
        this.nbPionsMangesJ1.setText("      Nombre de pions manges : " + nom);
        this.nbPionsRestantsJ1.setText("      Nombre de pions a eliminer restant : " + res);
        }
    }

    //méthode pour mettre à jour le nombre de pions mangés du joueur 2
    public void setPionsMangesJ2(int nom, int res) {
        if (nom != this.nbMangesJ1) {
            this.nbPionsMangesJ2.setText("      Nombre de pions manges : " + nom);
            this.nbPionsRestantsJ2.setText("      Nombre de pions a eliminer restant : " + res);
        }
    }

    //Methode afin de savoir qui doit jouer
    public void setTour(boolean turno) {
        if (turn.equals("Blanc")) {
            if (!turno) {
                this.tour.setText("    Tour : Blanc");
            } else if (turno) {
                this.tour.setText("    Tour : Marron");
            }
        } else if (turn.equals("Marron")) {
            if (turno) {
                this.tour.setText("    Tour : Blanc");
            } else if (!turno) {
                this.tour.setText("    Tour : Marron");
            }
        }
    }

    public Plateau getPlateau() {
        return this.plat;
    }

    public void resetNbManges() {
        this.nbMangesJ1 = 0;
        this.nbRestantJ1 = 22;
        this.nbMangesJ2 = 0;
        this.nbRestantJ2 = 22;
    }

    public void setDonnes(int nbSautesJ1, int nbSautesJ2) {
        this.nbMangesJ1 = nbSautesJ1;
        this.nbMangesJ2 = nbSautesJ2;
    }

    public int getPionsMangesGagnant() {
        int res;
        if (this.nbMangesJ1 > this.nbMangesJ2) {
            res = this.nbMangesJ1;
        } else {
            res = this.nbMangesJ2;
        }
        return res;
    }

//losange vide : pas de forte dependance
//losange plein : forte dependance entre le compose et le composant 
//si il ny a plus de composant il ny a plus de composé
}
