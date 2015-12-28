import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonCommencerJeu implements ActionListener {
	
    private FenetreInit fen;

    public EcouteurBoutonCommencerJeu(FenetreInit fen) {
        this.fen =fen;
    }

    public void actionPerformed(ActionEvent ae){
        new maFenetreScore(this.fen.getSaisieNom1(),this.fen.getSaisieNom2());
    }
	
}
