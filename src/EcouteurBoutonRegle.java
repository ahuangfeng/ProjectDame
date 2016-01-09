
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonRegle implements ActionListener {

    private FenetreInit fen;

    public EcouteurBoutonRegle(FenetreInit fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent ae) {
        new FenetreRegleJeu();
    }

}
