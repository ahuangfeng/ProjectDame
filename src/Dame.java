import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class Dame extends Pion {
	
    public Dame(int couleur, boolean monte){
        super();
        super.setCouleur(couleur);
        super.setMonte(monte);
        if(couleur==0){
            setForeground(Color.CYAN);
            setBackground(Color.WHITE);
        }else if(couleur==1){
            setForeground(Color.GREEN);
            setBackground(Color.LIGHT_GRAY);
        }
        setOpaque(false);
        
    }

}
