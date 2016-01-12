
import javax.swing.*;
import java.awt.*;

public class FenetreFin extends JFrame {

    //Création des éléments de la fenetre
    private JButton boutonRejouer;
    private JButton boutonNouvellePartie;
    private JButton quitter;
    private JLabel etiquette;
    private JPanel cadrePrincipal;
    private JPanel pHaut;
    private JPanel pBas;
    private JPanel pMilieu;

    private JLabel gagnant;
    private JLabel statistique1;
    private JLabel statistique2;

    //Panneaux invisibles
    private JPanel videRejouer;
    private JPanel videNouvellePartie;
    private JPanel videQuitter;
    private JPanel videVainqueur;
    private JPanel videStatistique1;
    private JPanel videStatistique2;

    private JPanel vide;
    private JPanel vide1;
    private JPanel vide2;
    private JPanel vide3;

    //création des écouteurs
    private EcouteurBoutonFerme EcouteurBtnClose;
    private EcouteurBoutonNouvellePartie EcouteurBtnNewPartie;
    private EcouteurBoutonRejouer EcouteurBtnRejouer;

    private String winnerOfTheGame;
    private String temps;

    public FenetreFin(String winnerOfTheGame, String looserOfTheGame, int nbEatenJ1, int nbEatenJ2, String temps) {

        super("Fin de la Partie");
        //System.out.println(temps);
        this.etiquette = new JLabel("FELICITATIONS !!! ");
        this.etiquette.setFont(new Font(Font.SERIF, Font.BOLD, 55));
        this.etiquette.setForeground(Color.BLUE);
        this.boutonRejouer = new JButton("Rejouer");
        this.boutonNouvellePartie = new JButton("Nouvelle Partie");
        this.quitter = new JButton("Quitter le jeu");

        //instanciation des éléments constructifs de la fenetre
        this.pBas = new JPanel(new GridLayout(3, 1));
        this.pMilieu = new JPanel(new GridLayout(4, 1));
        this.pHaut = new JPanel(new FlowLayout());
        this.cadrePrincipal = new JPanel(new GridLayout(7, 1));

        //gagnant = new JLabel(this.maFenetreScore.vainqueur+" a remporte la partie ! ");
        this.gagnant = new JLabel(looserOfTheGame + " a remporte la partie ! ");
        this.gagnant.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
        this.statistique1 = new JLabel(looserOfTheGame + " a mange " + nbEatenJ2 + " pions");
        this.statistique1.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
        this.statistique2 = new JLabel(winnerOfTheGame + "  a mange " + nbEatenJ1 + " pions");
        this.statistique2.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
        this.temps = temps;
        JLabel tempsJoue = new JLabel(this.temps);

        //création panneaux vides
        this.videRejouer = new JPanel();
        this.videNouvellePartie = new JPanel();
        this.videQuitter = new JPanel();
        this.videVainqueur = new JPanel();
        this.videStatistique1 = new JPanel();
        this.videStatistique2 = new JPanel();
        JPanel videStat3 = new JPanel(new FlowLayout());

        this.vide = new JPanel();
        this.vide1 = new JPanel();
        this.vide2 = new JPanel();
        this.vide3 = new JPanel();

        //création des trois boutons pour center le texte
        //videRejouer.add(boutonRejouer);
        this.videNouvellePartie.add(boutonNouvellePartie);
        this.videQuitter.add(quitter);

        this.videVainqueur.add(gagnant);
        this.videStatistique1.add(statistique1);
        this.videStatistique2.add(statistique2);
        videStat3.add(tempsJoue);

        // Création de pHaut
        this.pHaut.add(etiquette);

        // Création de pBas
        this.pBas.add(videRejouer);
        this.pBas.add(videNouvellePartie);
        this.pBas.add(videQuitter);

        // Création de pMilieu
        this.pMilieu.add(videVainqueur);
        this.pMilieu.add(videStatistique1);
        this.pMilieu.add(videStatistique2);
        this.pMilieu.add(videStat3);

        // Création du cadre principal
        this.cadrePrincipal.add(vide);
        this.cadrePrincipal.add(pHaut);
        this.cadrePrincipal.add(vide1);
        this.cadrePrincipal.add(pMilieu);
        this.cadrePrincipal.add(vide2);
        this.cadrePrincipal.add(pBas);
        this.cadrePrincipal.add(vide3);

        this.EcouteurBtnClose = new EcouteurBoutonFerme(this);
        this.EcouteurBtnNewPartie = new EcouteurBoutonNouvellePartie(this);
        this.EcouteurBtnRejouer = new EcouteurBoutonRejouer(this);

        this.quitter.addActionListener(EcouteurBtnClose);
        this.boutonRejouer.addActionListener(EcouteurBtnRejouer);
        this.boutonNouvellePartie.addActionListener(EcouteurBtnNewPartie);

        setContentPane(cadrePrincipal);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
