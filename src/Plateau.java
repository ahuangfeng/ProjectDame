import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class Plateau extends JPanel{
    private final int Taille=11;
    private Case caseActive;
    private boolean tour0;
    private static int nbPionsSautesJ1=0;
    private static int nbPionsSautesJ2=0;
    private maFenetreScore mfs;
    boolean tiro;
    private FenetreInit ini;
    public String joueurGagnant;
    private String winner;

    //private boolean deplacementAutorise;

    public Plateau(maFenetreScore fenetr,FenetreInit init, String nomNum1, String nomNum2) {
        this.mfs = fenetr;
        this.tiro=true;
        this.ini=init;
        //Comparer ages
        if((this.ini.getTextAge1().equals("")) || (this.ini.getTextAge2().equals(""))){
            System.out.println("Error!");
        }else{
            if((this.ini.getSelectedIndex()==0) && (this.ini.getSaisieAge1()<this.ini.getSaisieAge2())){
                tour0 = false;
            }else if((this.ini.getSelectedIndex()==1) && (this.ini.getSaisieAge1()<this.ini.getSaisieAge2())){
                tour0=true;
            }else if((this.ini.getSelectedIndex()==0) && (this.ini.getSaisieAge1()>=this.ini.getSaisieAge2())){
                tour0=true;
            }else if((this.ini.getSelectedIndex()==1) && (this.ini.getSaisieAge1()>=this.ini.getSaisieAge2())){
                tour0=false;
            }
        }
        setLayout(new GridLayout(this.Taille,this.Taille));
        for(int i=0; i<this.Taille; i++){
            for(int j=0; j<this.Taille; j++){
                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                    ajouterCase(0);
                }
                else{
                    ajouterCase(1);
                }
            }
        }
    }
	
    public void ajouterCase(int o){
        Case case1 = new Case(o);
        case1.addMouseListener(new ListenerCase(case1, this));
        add(case1);
    }
		
    public Pion creerPion(int couleur, boolean monte){
        Pion pion = new Pion(couleur,monte);
        //mfs = new maFenetreScore("hola","gllaaa");
        pion.addMouseListener(new ListenerPion(pion, this));
        return pion;
    }
        
    public void initialiser(){
        for(int i=0;i<this.Taille*4;i=i+2){
            getCase(i).add(creerPion(0,false));
            getCase(this.Taille*this.Taille-i-1).add(creerPion(1 ,true));
        }
    }
    
    public Case getCase(int i){
        return (Case) getComponent(i);
    }
        
    public Case getCase(int i, int j){
        //i=ligne,j=colonne
        return (Case) getComponent(j+i*Taille);
    }
    
    //permet d'avoir la case sur lequel le pion a été sélectionné
    public void affichePossibilitesPion(Pion p){
        int a=0;
        int b=0;
        if((p.getCouleur()==0 && tour0) || (p.getCouleur()== 1 && !tour0)){
            for(int i = 0; i < Taille; i++){
                for(int j=0; j < Taille; j++){
                    //Teste si la case contient un pion et permet d'obtenir la case du pion sélectionné
                    if(getCase(i,j).getComponentCount()!=0 && getCase(i,j).getComponent(0).equals(p)){
                        this.caseActive=getCase(i,j);
                        a =i;
                        b = j;
                    }
                }	
            }
            caseAutorise(a,b,p.getCouleur());
        }
    }
		
		
    //test si il rest des pions :
    public boolean testRestePion(){
        boolean res = false;
        for(int i = 0; i < Taille; i++){
            for(int j=0; j < Taille; j++){
                //Teste si la case contient un pion et permet d'obtenir la case du pion sélectionné
                if(this.testPresencePion(i,j)){
                    res = true;
                }
            }	
        }
        return res;
    }
    
    
    public boolean testPresencePion(int i, int j){
        boolean res= false;
        if(getCase(i,j).getComponentCount()!=0){
            res= true;			
        }
        return res;
    }
		
    /*permet de savoir le numéro de la case sur lequel le pion sélectionné se trouve
    public int getPositionPion(Pion p){
        int niemeCase=0;
        for(int i=0; i < Taille; i++){
            if(getComponent(i).equals(p)){
                niemeCase=i;					
            }
        }
    return niemeCase;	
    }
    */
	//test des cases ou le deplacement est possible	
    public void caseAutorise(int i, int j, int couleur){
        Pion pion = (Pion)(getCase(i, j).getComponent(0));
        if(pion.isMonte()){
            //pour les pions du haut
            //verifie que pion n'est pas bord gauche et pas dernière ligne + case vide
            if(i-1>=0 && j+1<Taille && getCase(i-1, j+1).getComponentCount()==0){
                getCase(i-1, j+1).setChoisie(true);
            }
            // vérifie si peut sauter un pion(Case vide)
            else if((i-2>=0) && (j+2<Taille) && (getCase(i-2, j+2).getComponentCount()==0)){
                //vérie si pion sauté est de couleur différente
                if(!(((Pion)(getCase(i-1, j+1).getComponent(0))).getCouleur()==(couleur))){
                    getCase(i-2, j+2).setChoisie(true);
                }
            }
            //pour les pions du bas

            //vérifie si case vide en diagonale
            if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0){
                getCase(i-1, j-1).setChoisie(true);
            }
            else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0){
                if(!(((Pion)(getCase(i-1, j-1).getComponent(0))).getCouleur()==(couleur))){
                    getCase(i-2, j-2).setChoisie(true);
                }
            }
        }else{
                //pions du haut
                //verifie si case vide diagonale droite
                if(i+1<Taille && j+1<Taille && getCase(i+1, j+1).getComponentCount()==0){
                    getCase(i+1, j+1).setChoisie(true);
                }
                //verifie si case et si peut sauter pion de couleur différente
                else if((i+2<Taille) && (j+2<Taille) && (getCase(i+2, j+2).getComponentCount()==0)){
                    if(!(((Pion)(getCase(i+1, j+1).getComponent(0))).getCouleur()==(couleur))){
                        getCase(i+2, j+2).setChoisie(true);
                    }
                }
                //pions du bas
           
                if(i+1<Taille && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){
                    getCase(i+1, j-1).setChoisie(true);
                }
                else if(i+2<Taille && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0){			
                    if(!(((Pion)(getCase(i+1, j-1).getComponent(0))).getCouleur()==(couleur))){
                        getCase(i+2, j-2).setChoisie(true);
                    }
                }
            
            }
    }
    
    
    public Dame creerDame(int couleur ,boolean monte){
        Dame nouvelleDame = new Dame(couleur, monte);
        return nouvelleDame;
    }
		
		
    public void deplacer(Case case1){
        //permet de placer le pion dans la case sélectionné
        //Création de la dame si le pion se place sur la dernière ligne
            case1.add(this.caseActive.getComponent(0)); 

            //permet de supprimer sur le plateau le pion sauté
            if(Math.abs(getLigne(case1)-getLigne(this.caseActive))==2){
                int i = (getLigne(case1)+getLigne(this.caseActive))/2;
                int j = (getColonne(case1)+getColonne(this.caseActive))/2;
                getCase(i, j).removeAll();
                getCase(i, j).validate();
                getCase(i, j).repaint();
                if(this.tiro){
                    nbPionsSautesJ1++;
                }else{
                    nbPionsSautesJ2++;
                }
                if(nbPionsSautesJ1<nbPionsSautesJ2){
						 joueurGagnant=this.ini.getSaisieNom1();
				}
				if(nbPionsSautesJ2<nbPionsSautesJ1){
						 joueurGagnant=this.ini.getSaisieNom2();
				}
               
                this.mfs.setPionsMangesJ1(nbPionsSautesJ1,22-nbPionsSautesJ1);
                this.mfs.setPionsMangesJ2(nbPionsSautesJ2,22-nbPionsSautesJ2);
                //System.out.println(nbPionsSautes);
                if(nbPionsSautesJ1==22 || nbPionsSautesJ2==22){
                    //affichage FenetreFin si tout les pions ont ete manges
                    if(nbPionsSautesJ1==22){
						 joueurGagnant=this.ini.getSaisieNom1();
						 //new FenetreFin();
					}
					if(nbPionsSautesJ2==22){
						 joueurGagnant=this.ini.getSaisieNom2();
						 //new FenetreFin();
					}
                   new FenetreFin(joueurGagnant); 
                
                }
            }

            for(int k=0; k<Taille*Taille; k++){
                getCase(k).setChoisie(false);
            }
            tour0=!tour0;
            this.caseActive.removeAll();
            this.caseActive.repaint();
            this.caseActive=null;
            case1.repaint();
            if(getLigne(case1)==0){
                Pion p=(Pion)(case1.getComponent(0));
                p.setMonte(false);
            }
            if(getLigne(case1)==Taille-1){
                Pion p=(Pion)(case1.getComponent(0));
                p.setMonte(true);
            }
            
            this.mfs.setTour(this.tiro);
            this.tiro=!this.tiro;
    }

    private int getLigne(Case case1){
        int res=0;
        for(int i=0; i<Taille*Taille; i+=2){
            if(getCase(i).equals(case1)){
                res=i/Taille;
            }
        }
        return res;
    }

    private int getColonne(Case case1){
        int res=0;
        for(int i=0; i<Taille*Taille; i+=2){
            if(getCase(i).equals(case1)){
                res=i%Taille;
            }
        }
        return res;
    }
    
    public int getNbPionsSautesJ1(){
        System.out.println(nbPionsSautesJ1);
        return nbPionsSautesJ1;
    }
    
    public int getNbPionsSautesJ2(){
        System.out.println(nbPionsSautesJ2);
        return nbPionsSautesJ2;
    }
    
    public boolean getTour(){
        return this.tour0;
    }
}
