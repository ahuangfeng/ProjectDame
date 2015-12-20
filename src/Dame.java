import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class Dame extends Pion {
	
	
	
	public Dame(int couleur, boolean monte){
		super(couleur,monte);
				
	    if(couleur==0){
			setForeground(Color.YELLOW);
			setBackground(Color.WHITE);
		}else if(couleur==1){
			setForeground(Color.BLACK);
			setBackground(Color.WHITE);
		}
		setOpaque(false);
	}
	

	
	
}
