
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurFermeFenetre implements ActionListener {

    //ferme la fenetre mais pas le jeu
    private FenetreRegleJeu fen;

    public EcouteurFermeFenetre(FenetreRegleJeu fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent ae) {
        this.fen.setVisible(false);
    }
}
