import javax.swing.*;
import java.awt.*;

	public class FenetreFin extends JFrame{
		private JButton boutonRejouer;
		private JButton boutonNouvellePartie;
		private JButton quitter;
		private JLabel etiquette;
		private JPanel cadrePrincipal;
		private JPanel pHaut;
		private JPanel pBas;
		private JPanel pMilieu;
		
		private JLabel vainqueur;
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
		
		private EcouteurBoutonFerme EcouteurBtnClose;

	
	
	public FenetreFin(){
		super("Fin de la Partie");
		
		etiquette = new JLabel("FELICATIONS !!! ");
		
		boutonRejouer = new JButton ("Rejouer");
		boutonNouvellePartie= new JButton("Nouvelle Partie" );
		quitter = new JButton("Quitter le jeu");
		
		pBas= new JPanel(new GridLayout(3,1));
		pMilieu = new JPanel(new GridLayout(3,1));
		pHaut = new JPanel(new FlowLayout());
		cadrePrincipal=new JPanel(new GridLayout(7,1));
		
		
		vainqueur = new JLabel("*Joueur 1* a remporte la partie ! ");
		statistique1 = new JLabel("*Joueur* a remporte * * parties et a mange * * pions");
		statistique2 = new JLabel("*Joueur* a remporte * * parties et a mange * * pions");
		
		//création panneaux vides
		videRejouer = new JPanel();
		videNouvellePartie = new JPanel();
		videQuitter = new JPanel();
		videVainqueur = new JPanel();
		videStatistique1 = new JPanel();
		videStatistique2 = new JPanel();
		
		vide = new JPanel();
		vide1 = new JPanel();
		vide2 = new JPanel();
		vide3 = new JPanel();
		
		//création des trois boutons pour center le texte
		videRejouer.add(boutonRejouer);
		videNouvellePartie.add(boutonNouvellePartie);
		videQuitter.add(quitter);
		
		videVainqueur.add(vainqueur);
		videStatistique1.add(statistique1);
		videStatistique2.add(statistique2);
		
		// Création de pHaut
		pHaut.add(etiquette);
		
		// Création de pBas
		pBas.add(videRejouer);
		pBas.add(videNouvellePartie);
		pBas.add(videQuitter);
		
		// Création de pMilieu
		pMilieu.add(videVainqueur);
		pMilieu.add(videStatistique1);
		pMilieu.add(videStatistique2);
				
		
		// Création du cadre principal
		cadrePrincipal.add(vide);
		cadrePrincipal.add(pHaut);
		cadrePrincipal.add(vide1);
		cadrePrincipal.add(pMilieu);
		cadrePrincipal.add(vide2);
		cadrePrincipal.add(pBas);
		cadrePrincipal.add(vide3);
		
		
		EcouteurBtnClose = new EcouteurBoutonFerme(this);
		
		quitter.addActionListener(EcouteurBtnClose);
		
		//quitter.addActionListener(new EcouteurQuitter(this));
		
		setContentPane(cadrePrincipal);
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
	}
	
	public static void main(String[] args) {
        new FenetreFin();
    }
}
