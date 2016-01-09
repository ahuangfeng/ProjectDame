import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;


public class EcouteurChronometre implements ActionListener{
    private maFenetreScore fen;
    private String texte;

    public EcouteurChronometre(maFenetreScore fen) {
        this.fen =fen;
    }

    public void actionPerformed(ActionEvent e){
        fen.getCrono().Compter();
        fen.allerCrono();
        /*while(true){
            fen.setTemps(fen.getCrono().getSegundos());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EcouteurChronometre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        /*texte= this.fen.boutonDebutChronometre.getText();
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
