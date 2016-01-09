import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
//import java.util.Timer;
//import java.util.TimerTask;
import java.awt.event.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Thread;


public class maFenetreScore extends JFrame{
	
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
    
    //Variable pour le Timer
    private static int heure=0;
    private static int minute =0;
    private static int seconde =0;
	
    //Panel pour le Timer
    public JLabel LabelTemps;
    public JButton boutonDebutChronometre;
    private JPanel PanelChronometre;
    public Timer timer1;
    private EcouteurChronometre ecChronometre;

	
    public  static int nbMangesJ1 =0;
    private int nbRestantJ1=22;
    
    public static int nbMangesJ2 =0;
    private int nbRestantJ2=22;
	
    public JPanel monPanelAffichageDonnees;
    private JPanel PanelGlobalScore;
    
    private JButton btnFinDeJeu;
    private EcouteurBoutonFinDeJeu ecFinJeu;
    public Plateau plat;
    private String turn;
    private String j1;
    private String j2;
	
    public static int nbPionAvalesJ1;
    private Crono temps;
    
    public static String vainqueur;
	
    public maFenetreScore(String nom1, String nom2, FenetreInit ini){
	super("Jeu de Dame");
		
		j1 = nom1;
		j2 = nom2;
		
        //définir la taille et la fermeture par défaut
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monPanelAffichageDonnees = new JPanel(new GridLayout(17,1));
        PanelGlobalScore = new JPanel(new BorderLayout());
        //creer plateau
        this.plat = new Plateau(this,ini, j1,j2);
        plat.initialiser();
        PanelGlobalScore.add(plat,BorderLayout.CENTER);
        
        ecFinJeu = new EcouteurBoutonFinDeJeu(this);
        btnFinDeJeu = new JButton("Fin du jeu");
        btnFinDeJeu.addActionListener(ecFinJeu);

        //instancier des variables pour le Timer
        ecChronometre = new EcouteurChronometre(this);

        //int delais =1000;
        /*ActionListener tache_timer;

        tache_timer = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                seconde++;
                if(seconde==60){
                    seconde=0;
                    minute++;
                }
                if(minute==60){
                    minute=0;
                    heure++;
                }
                LabelTemps.setText(heure+":"+minute+":"+seconde);/* rafraichir le label 
                System.out.println(heure+":"+minute+":"+seconde);
            }
        };*/

        //timer1 = new Timer(delais,tache_timer);
        this.temps = new Crono();
        
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
		
		
		if(nbMangesJ1<nbMangesJ2){
			vainqueur = nom2;
		}else{
			vainqueur = nom1;
		}
		
        nomJoueurDeux = new JLabel("      "+nom2);
        //a modifier avec la classe joueur
        nbPionsMangesJ2 = new JLabel("      Nombre de pions manges : "+this.nbMangesJ2);
        nbPionsRestantsJ2 = new JLabel("      Nombre de pions restants : "+nbRestantJ2);

      
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
        monPanelAffichageDonnees.add(PanelChronometre);
        monPanelAffichageDonnees.add(btnFinDeJeu);
        //monPanelAffichageDonnees.add(tempsEcoule);

        PanelGlobalScore.add(monPanelAffichageDonnees, BorderLayout.EAST);
        //PanelGlobalScore.add(tempsEcoule, BorderLayout.SOUTH);
       


        setContentPane(PanelGlobalScore);

        //rendre la fenêtre visible
        setVisible(true);
    }
    
    public Crono getCrono(){
        return this.temps;
    }
    
    public void setTemps(int sec){
        int segondesss = sec;
        int minutes1=0;
        int heure1=0;
        for(int k=segondesss;k>=60;k=k-60){
            minutes1++;
            segondesss=segondesss-60;
        }
        for(int k=minutes1;k>=60;k=k-60){
            heure1++;
            minutes1=minutes1-60;
        }
        this.seconde=segondesss;
        this.minute=minutes1;
        this.heure=heure1;
        this.LabelTemps.setText("Temps ecoule : "+heure+":"+minute+":"+seconde);
    }
    public void allerCrono(){
        while(true){
            this.PanelChronometre.repaint();
            setTemps(this.temps.getSegundos());
            //Thread.sleep(1000);
            setVisible(true);
        }
    }
    
    public int getSeconde(){
        return this.seconde;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getHeure(){
        return this.heure;
    }
    /*
    private static void delaySeconde(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    }*/
    
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
