/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */
public class Partie {
	
    private Joueur joueur1;
    private Joueur joueur2;


    public Partie(Joueur jug1,Joueur jug2){
        this.joueur1=jug1;
        this.joueur2=jug2;
        
        Plateau plat = new Plateau(new maFenetreScore("h","j"));
    }	
}


