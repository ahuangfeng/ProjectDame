import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cronometre extends JPanel implements Runnable, ActionListener{
    public static int onoff = 0;
    private JLabel tiempo;
    private Thread hilo;
    private boolean cronometroActivo;
    
    public Cronometre(){
    this.tiempo = new JLabel( "Temps ecoule : 00:00:000" );
    setLayout( new FlowLayout() );
    add( tiempo);

    //Bouton Start
    JButton btn = new JButton( "Start" );
    btn.addActionListener( this );
    add(btn);


    //this.setLocationRelativeTo( null );
    }
    
    public void run(){
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min="", seg="", mil="";
        try{
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            while( cronometroActivo ){
                Thread.sleep(4 );
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;

                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if( milesimas == 1000 ){
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if( segundos == 60 ){
                        segundos = 0;
                        minutos++;
                    }
                }

                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                //Colocamos en la etiqueta la informacion
                tiempo.setText("Temps ecoule : "+ min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){}
        //Cuando se reincie se coloca nuevamente en 00:00:000
        tiempo.setText( "Temps ecoule : 00:00:000" );
    }
    
    //Esto es para el boton iniciar y reiniciar
    public void actionPerformed( ActionEvent evt ) {
        Object o = evt.getSource();
        if( o instanceof JButton ){
            JButton btn = (JButton)o;
            if( btn.getText().equals("Start") ){
                if(onoff == 0){
                   onoff = 1;
                   iniciarCronometro();
                }
            }
        }
    }

    //Iniciar el cronometro poniendo cronometroActivo 
    //en verdadero para que entre en el while
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }

    //Esto es para parar el cronometro
    public void pararCronometro(){
        cronometroActivo = false;
    }
    
}
    

