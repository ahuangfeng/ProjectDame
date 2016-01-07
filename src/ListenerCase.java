import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerCase implements MouseListener{
    
    private Case case1;
    private Plateau plateau;

    
    public ListenerCase(Case case1, Plateau plateau) {
        super();
        this.case1 = case1;
        this.plateau = plateau;
    }

    //ensemble des méthodes relatifs aux déplacements et clics de la souris
    public void mouseClicked(MouseEvent arg0) {
    
    }

    public void mouseEntered(MouseEvent arg0) {
        
    }

    public void mouseExited(MouseEvent arg0) {
        
    }

    public void mousePressed(MouseEvent arg0) {
        if(case1.estChoisie()){
            plateau.deplacer(case1);
        }
    }

    public void mouseReleased(MouseEvent arg0) { 
    }
}
