/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */
public class Joueur {
	
    private String nom;
    private int age;
    private int couleur;
	
	
    public Joueur(String nom, int age, int couleur){
        this.nom=nom;
        this.age=age;
        this.couleur=couleur;
    }
	
    public String getNom(){
        return this.nom;
    }
	
    public int getAge(){
        return this.age;
    }

    public int getCouleur(){
        return this.couleur;
    }
}


