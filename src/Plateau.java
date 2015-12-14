
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */

public class Plateau extends JPanel{
	private int Taille=11;
	public Plateau() {
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
		add(case1);
	}
        
        public Pion creerPion(int couleur){
            Pion pion = new Pion(couleur);
            //ajouter Listener!
            return pion;
        }
        
        public void initialiser(){
            for(int i=0;i<this.Taille*4;i=i+2){
                getCase(i).add(creerPion(0));
                getCase(this.Taille*this.Taille-i-1).add(creerPion(1));
            }
        }
        public Case getCase(int i){
            return (Case) getComponent(i);
        }
	
}
