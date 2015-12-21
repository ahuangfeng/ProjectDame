import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonFerme implements ActionListener {
	
    private FenetreFin fen;

    public EcouteurBoutonFerme(FenetreFin fen) {
        this.fen =fen;
    }

    public void actionPerformed(ActionEvent ae){
        System.exit(0);
    }
	
}
