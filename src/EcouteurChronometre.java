import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.border.*;


public class EcouteurChronometre implements ActionListener{
	private maFenetreScore fen;
	private String texte;

    public EcouteurChronometre(maFenetreScore fen) {
        this.fen =fen;
    }

	
	
	public void actionPerformed(ActionEvent e){
		
		texte= this.fen.boutonDebutChronometre.getText();
		if(texte.compareTo("Start")==0){
			this.fen.boutonDebutChronometre.setText("Stop");
			this.fen.timer1.start();
			this.fen.PanelChronometre.repaint();
		}/*else if(texte.compareTo("Stop")==0){
			this.fen.boutonDebutChronometre.setText("Start");
			this.fen.timer1.stop();
		}*/
	}
			
}
