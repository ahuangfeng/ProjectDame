import java.util.TimerTask;
public class Compteur extends TimerTask{
    int seg=0;
    public void run() {
        
        System.out.println("segundo: " + seg);
        seg++;
    }
    
    public int getSecondes(){
        return this.seg;
    }
}
