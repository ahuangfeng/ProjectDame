import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
//import java.util.Timer;
//import java.util.TimerTask;
import java.awt.event.*;
import java.lang.*;


public class maFenetreScore extends JFrame{
	
	//création des variables
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
    
    //Variable pour le Timer
    public static int heure=0;
    public static int minute =0;
    public static int seconde =0;
	
	//Panel pour le Timer
	public JLabel LabelTemps;
	public JButton boutonDebutChronometre;
	public JPanel PanelChronometre;
	public Timer timer1;
	private EcouteurChronometre ecChronometre;

	
    private int nbMangesJ1 =0;
    private int nbRestantJ1=22;
    
    private int nbMangesJ2 =0;
    private int nbRestantJ2=22;
	
    public JPanel monPanelAffichageDonnees;
    private JPanel PanelGlobalScore;
    
    private JButton btnFinDeJeu;
    private EcouteurBoutonFinDeJeu ecFinJeu;
    private Plateau plat;
    private String turn;
	
    public static int nbPionAvalesJ1;
	
    public maFenetreScore(String nom1, String nom2, FenetreInit ini){
	super("Jeu de Dame");
        //définir la taille et la fermeture par défaut
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monPanelAffichageDonnees = new JPanel(new GridLayout(17,1));
        PanelGlobalScore = new JPanel(new BorderLayout());
        //creer plateau
        this.plat = new Plateau(this,ini);
        plat.initialiser();
        PanelGlobalScore.add(plat,BorderLayout.CENTER);
        
        ecFinJeu = new EcouteurBoutonFinDeJeu(this);
        btnFinDeJeu = new JButton("Fin du jeu");
        btnFinDeJeu.addActionListener(ecFinJeu);

//instancier des variables pour le Timer
		//ecChronometre = new EcouteurChronometre(this);
		
		
		int delais =1000;
		ActionListener tache_timer;
		
		tache_timer = new ActionListener(){
			public void actionPerformed(ActionEvent e1)
			{
				seconde++;
				if(seconde==60)
				{
					seconde=0;
					minute++;
				}
				if(minute==60)
				{
					minute=0;
					heure++;
				}
				LabelTemps.setText(heure+":"+minute+":"+seconde);/* rafraichir le label */
				
			}
		};
	
		timer1 = new Timer(delais,tache_timer);
		
		LabelTemps = new JLabel("Temps ecoule : "+heure+":"+minute+":"+seconde);
		boutonDebutChronometre = new JButton ("Start");
		PanelChronometre= new JPanel();
		boutonDebutChronometre.addActionListener(ecChronometre);
		
		PanelChronometre.add(LabelTemps);
		PanelChronometre.add(boutonDebutChronometre);

        nomJoueurUn = new JLabel("      "+nom1);
        //a modifier avec la classe joueur
        
        //int a = nbPionAvalesJ1 + plat.getNbPionsSautes();
        
        /*if(plat.getNbPionsSautes()!=0){
            monPanelAffichageDonnees.removeAll();
            monPanelAffichageDonnees.repaint();
        }*/
	//Statistiques pions mangés
        this.nbMangesJ1 = plat.getNbPionsSautesJ1();
        this.nbRestantJ1=this.nbRestantJ1-this.nbMangesJ1;
        this.nbMangesJ2 = plat.getNbPionsSautesJ2();
        this.nbRestantJ2=this.nbRestantJ2-this.nbMangesJ2;
        nbPionsMangesJ1 = new JLabel("      Nombre de pions manges : "+this.nbMangesJ1);
        
        nbPionsRestantsJ1 = new JLabel("      Nombre de pions restants : "+nbRestantJ1);

        nomJoueurDeux = new JLabel("      "+nom2);
        //a modifier avec la classe joueur
        nbPionsMangesJ2 = new JLabel("      Nombre de pions manges : "+this.nbMangesJ2);
        nbPionsRestantsJ2 = new JLabel("      Nombre de pions restants : "+nbRestantJ2);

        phraseNbPartiJ1 = new JLabel("      "+nom1+" a gagne + *** + partie(s)");
        phraseNbPartiJ2 = new JLabel("      "+nom2+" a gagne + *** + partie(s)");
        this.turn="";
        if(this.plat.getTour()==true){
            turn = "Blanc";
        }else{
            turn = "Marron";
        }
        this.tour=new JLabel("    Tour : "+turn);
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
        monPanelAffichageDonnees.add(PanelChronometre);
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
    //méthode pour mettre à jour le nombre de pions mangés du joueur 1
    public void setPionsMangesJ1(int nom,int res){
        if(nom!=this.nbMangesJ1){
            this.nbPionsMangesJ1.setText("      nombre de pions manges : "+nom);
            //this.nbPionsMangesJ2.setText("      nombre de pions manges : "+nom);
            this.nbPionsRestantsJ1.setText("      nombre de pions restants : "+res);
            //this.nbPionsRestantsJ2.setText("      nombre de pions restants : "+res);
        }
    }
    //méthode pour mettre à jour le nombre de pions mangés du joueur 2
    public void setPionsMangesJ2(int nom,int res){
        if(nom!=this.nbMangesJ1){
            //this.nbPionsMangesJ1.setText("      nombre de pions manges : "+nom);
            this.nbPionsMangesJ2.setText("      nombre de pions manges : "+nom);
            //this.nbPionsRestantsJ1.setText("      nombre de pions restants : "+res);
            this.nbPionsRestantsJ2.setText("      nombre de pions restants : "+res);
        }
    }
    //Methode afin de savoir qui doit jouer
    public void setTour(boolean turno){
        if(turn.equals("Blanc")){
            if(!turno){
                this.tour.setText("    Tour : Blanc");
            }else if(turno){
                this.tour.setText("    Tour : Marron");
            }
        }else if(turn.equals("Marron")){
            if(turno){
                this.tour.setText("    Tour : Blanc");
            }else if(!turno){
                this.tour.setText("    Tour : Marron");
            }
        }
    }
    
    public Plateau getPlateau(){
        return this.plat;
    }

//losange vide : pas de forte dependance
//losange plein : forte dependance entre le compose et le composant 
//si il ny a plus de composant il ny a plus de composé


}
