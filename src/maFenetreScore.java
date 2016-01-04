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
    private JLabel tour;
    
    private int nbManges =0;
    private int nbRestant=44;
	
    public JPanel monPanelAffichageDonnees;
    private JPanel PanelGlobalScore;
    
    private JButton btnFinDeJeu;
    private EcouteurBoutonFinDeJeu ecFinJeu;
	
    public static int nbPionAvalesJ1;
	
    public maFenetreScore(String nom1, String nom2){
	
        //définir la taille et la fermeture par défaut
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monPanelAffichageDonnees = new JPanel(new GridLayout(17,1));
        PanelGlobalScore = new JPanel(new BorderLayout());
        //creer plateau
        Plateau plat = new Plateau(this,new FenetreInit());
        plat.initialiser();
        PanelGlobalScore.add(plat,BorderLayout.CENTER);
        
        ecFinJeu = new EcouteurBoutonFinDeJeu(this);
        btnFinDeJeu = new JButton("Fin du jeu");
        btnFinDeJeu.addActionListener(ecFinJeu);

        nomJoueurUn = new JLabel("      "+nom1);
        //a modifier avec la classe joueur
        
        //int a = nbPionAvalesJ1 + plat.getNbPionsSautes();
        
        /*if(plat.getNbPionsSautes()!=0){
            monPanelAffichageDonnees.removeAll();
            monPanelAffichageDonnees.repaint();
        }*/

        this.nbManges = plat.getNbPionsSautes();
        this.nbRestant=this.nbRestant-this.nbManges;
        nbPionsMangesJ1 = new JLabel("      Nombre de pions manges : "+this.nbManges);
        
        nbPionsRestantsJ1 = new JLabel("      Nombre de pions restants : "+nbRestant);

        nomJoueurDeux = new JLabel("      "+nom2);
        //a modifier avec la classe joueur
        nbPionsMangesJ2 = new JLabel("      Nombre de pions manges : "+this.nbManges);
        nbPionsRestantsJ2 = new JLabel("      Nombre de pions restants : "+nbRestant);

        phraseNbPartiJ1 = new JLabel(nom1+" a gagne + *** + partie(s)");
        phraseNbPartiJ2 = new JLabel(nom2+" a gagne + *** + partie(s)");
        String turn = "Marron";
        this.tour=new JLabel("    Tour : "+turn);
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
        monPanelAffichageDonnees.add(vide);
        monPanelAffichageDonnees.add(btnFinDeJeu);
        //monPanelAffichageDonnees.add(tempsEcoule);

        PanelGlobalScore.add(monPanelAffichageDonnees, BorderLayout.EAST);
        //PanelGlobalScore.add(tempsEcoule, BorderLayout.SOUTH);
       


        setContentPane(PanelGlobalScore);

        //rendre la fenêtre visible
        setVisible(true);
        
        
    }
    
    public JPanel getPanelScore(){
        return this.PanelGlobalScore;
    }
    
    public void setPionsManges(int nom,int res){
        if(nom!=this.nbManges){
            this.nbPionsMangesJ1.setText("      nombre de pions manges : "+nom);
            this.nbPionsMangesJ2.setText("      nombre de pions manges : "+nom);
            this.nbPionsRestantsJ1.setText("      nombre de pions restants : "+res);
            this.nbPionsRestantsJ2.setText("      nombre de pions restants : "+res);
        }
    }
    
    public void setTour(boolean turno){
        if(turno){
            this.tour.setText("    Tour : Blanc");
        }else if(!turno){
            this.tour.setText("    Tour : Marron");
        }
        
    }

//losange vide : pas de forte dependance
//losange plein : forte dependance entre le compose et le composant 
//si il ny a plus de composant il ny a plus de composé


}
