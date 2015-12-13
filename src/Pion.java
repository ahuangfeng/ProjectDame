
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */
public class Pion extends JPanel{
	
	private Joueur joueur;
	private int positionX;
	private int positionY;
	private int couleur;
	
	public Pion(int couleur) {
		//this.joueur=joueur;
		//this.positionX=x;
		//this.positionY=y;
		this.couleur=couleur;
                if(couleur==0){
                    setForeground(Color.CYAN);
                }else if(couleur==1){
                    setForeground(Color.MAGENTA);
                }
	}
	
        /*public void paintComponent(Graphics g){
            Paint paint;
            Graphics2D f;
            paint=
        }*/
	
	public Joueur getJoueur(){
		return this.joueur;
	}
	
	/*public int getPositionX(){
		return this.positionX;
	}
	
	public int getPositionY(){
		return this.positionY;
	}
	
	public int getCouleur(){
		return this.couleur;
	}
	
	public void setPosition(int x, int y){
		this.positionX=x;
		this.positionY=y;
	}*/
	
	/*public boolean peutBouger(){
		//il faut le completer
		
	}*/
	
	/*public boolean peutManger(){
		//il faut le completer
	}
	
	public void bouger(int posx,int posy){
		//je crois qu'il sers a rien
	}*/
	
	public void reset(){
		this.joueur=null;
		this.positionX=0;
		this.positionY=0;
		this.couleur=0;
		
	}
}


