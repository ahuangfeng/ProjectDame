import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class maFenetreScore extends JFrame{

	private JLabel nomJoueurUn;
	private JLabel nomJoueurDeux;
	private JLabel nbPionsMangesJ1;
	private JLabel nbPionsRestantsJ1;
	private JLabel nbPionsMangesJ2;
	private JLabel nbPionsRestantsJ2;
	private JLabel phraseNbPartiJ1;
	private JLabel phraseNbPartiJ2;
	private JLabel tempsEcoule;
	private JLabel vide;
	
	private JPanel monPanelAffichageDonnees;
	private JPanel PanelGlobalScore;
	
	
	public maFenetreScore(){
		
	
            //définir la taille et la fermeture par défaut
            setSize(800,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            monPanelAffichageDonnees = new JPanel(new GridLayout(17,1));
            PanelGlobalScore = new JPanel(new BorderLayout());

            nomJoueurUn = new JLabel("*Joueur 1*");
            //a modifier avec la classe joueur
            nbPionsMangesJ1 = new JLabel("      nombre de pions manges : + ***");
            nbPionsRestantsJ1 = new JLabel("      nombre de pions restants : + *** ");

            nomJoueurDeux = new JLabel("*Joueur 2*");
            //a modifier avec la classe joueur
            nbPionsMangesJ2 = new JLabel("      nombre de pions manges : + *** ");
            nbPionsRestantsJ2 = new JLabel("      nombre de pions restants : + *** ");

            phraseNbPartiJ1 = new JLabel("Joueur1+ a gagne + *** + partie(s)");
            phraseNbPartiJ2 = new JLabel("Joueur2+ a gagne + *** + partie(s)");
            /*Tiempo temp = new Tiempo();
            temp.Contar();
            temp.run();
            //tempsEcoule = new JLabel("temps ecoule : " + Integer.parseInt((temp.run()).getText()));
            tempsEcoule = new JLabel("temps ecoule : " +temp.getSegundos());
            */
            vide = new JLabel("");

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
            monPanelAffichageDonnees.add(phraseNbPartiJ1);
            monPanelAffichageDonnees.add(phraseNbPartiJ2);
            monPanelAffichageDonnees.add(vide);
            monPanelAffichageDonnees.add(vide);
            //monPanelAffichageDonnees.add(tempsEcoule);

            PanelGlobalScore.add(monPanelAffichageDonnees, BorderLayout.EAST);
            //PanelGlobalScore.add(tempsEcoule, BorderLayout.SOUTH);
            Plateau plat = new Plateau();
            plat.initialiser();
            PanelGlobalScore.add(plat,BorderLayout.CENTER);


            setContentPane(PanelGlobalScore);

            //rendre la fenêtre visible
            setVisible(true);
	}

//losange vide : pas de forte dependance
//losange plein : forte dependance entre le compose et le composant 
//si il ny a plus de composant il ny a plus de composé


}
