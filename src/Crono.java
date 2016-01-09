import java.util.Timer;
import java.util.TimerTask;
public class Crono extends Timer{
    private Timer timer;
    private int secondes=0;
    private Compteur contador;
    //Crea un timer, inicia segundos a 0 y comienza a contar
    public Crono(){
        this.timer= new Timer();
        this.contador=new Compteur();
    }
    
    public void Compter(){
        this.secondes=0;
        timer = new Timer();
        timer.schedule(this.contador, 0, 1000);
    }
    //Detiene el contador
    public void Detenir(){
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public int getSegundos(){
        return this.secondes;
    }
    public Compteur getCompteur(){
        return this.contador;
    }
}
