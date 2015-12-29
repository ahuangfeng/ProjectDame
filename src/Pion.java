import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class Pion extends JPanel{
	
    private Joueur joueur;
    private int couleur;
    private boolean monte;

    public Pion(int couleur, boolean monte) {
        //this.joueur=joueur;
        this.monte=monte;
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
    public Pion(){
        this.couleur=0;
        this.monte=true;
    }
                
    public void setCouleur(int col){
        this.couleur=col;
    }
    
    public void setMonte(boolean mon){
        this.monte=mon;
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

    public int getCouleur(){
        return this.couleur;
    }
	
    public void reset(){
        this.joueur=null;
        this.couleur=0;
    }
	
    public boolean isMonte(){
        return monte;
    }
}

