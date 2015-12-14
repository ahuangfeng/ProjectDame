
import java.awt.Color;
import java.awt.GradientPaint;
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
                if(this.couleur==0){
                    setForeground(Color.LIGHT_GRAY);
                    setBackground(Color.WHITE);
                }else if(this.couleur==1){
                    setForeground(new Color(102,51,0));
                    setBackground(Color.LIGHT_GRAY);
                }
                setOpaque(false);
	}
	
        public void paintComponent(Graphics g){
            Paint paint;
            Graphics2D g2d = (Graphics2D) g;
            if (g instanceof Graphics2D) {
                g2d = (Graphics2D) g;
            }
            else {
                System.out.println("Error");
                return;
            }
            paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
            g2d.setPaint(paint);
            g.fillOval(5, 5, getWidth()-10, getHeight()-10);
        }
	
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


