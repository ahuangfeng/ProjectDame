
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonFinDeJeu implements ActionListener {

    private maFenetreScore fen;

    public EcouteurBoutonFinDeJeu(maFenetreScore fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent ae) {
        new FenetreFin(this.fen.plat.joueurGagnant, this.fen.plat.joueurPerdant, this.fen.plat.nbPionsSautesJ1, this.fen.plat.nbPionsSautesJ2, this.fen.getCrono().getTemps());

        this.fen.getCrono().stopCrono();
        this.fen.setVisible(false);
    }

}
