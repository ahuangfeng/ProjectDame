
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cronometre extends JPanel implements Runnable, ActionListener {

    public static int onoff = 0;
    private JLabel temps;
    private Thread fil;
    private boolean cronoActive;
    private String tempsFinal;
    private JButton btn;

    public Cronometre() {
        this.temps = new JLabel("Temps ecoule : 00:00:00:000");
        setLayout(new FlowLayout());
        add(temps);

        //Bouton Start
        this.btn = new JButton("Start");
        btn.addActionListener(this);
        add(btn);
    }

    public void run() {
        Integer minutes = 0, secondes = 0, milesimes = 0, heures = 0;
        //
        //min est minutes, seg est secondes et mil sont des milesimes de seconde, heur = heures
        String min = "", seg = "", mil = "", heur = "";
        try {
            while (cronoActive) {
                Thread.sleep(4);
                milesimes += 4;
                if (milesimes == 1000) {
                    milesimes = 0;
                    secondes += 1;
                    if (secondes == 60) {
                        secondes = 0;
                        minutes++;
                        if (minutes == 60) {
                            minutes = 0;
                            heures++;
                        }
                    }
                }
                //stetique
                if (heures < 10) {
                    heur = "0" + heures;
                } else {
                    heur = heures.toString();
                }
                if (minutes < 10) {
                    min = "0" + minutes;
                } else {
                    min = minutes.toString();
                }
                if (secondes < 10) {
                    seg = "0" + secondes;
                } else {
                    seg = secondes.toString();
                }

                if (milesimes < 10) {
                    mil = "00" + milesimes;
                } else if (milesimes < 100) {
                    mil = "0" + milesimes;
                } else {
                    mil = milesimes.toString();
                }

                //on change l'etiquette
                temps.setText("Temps ecoule : " + heur + ":" + min + ":" + seg + ":" + mil);
            }
            this.tempsFinal = heur + ":" + min + ":" + seg + ":" + mil;
        } catch (Exception e) {
        }
        //temps.setText("Temps ecoule : 00:00:000");
    }

    public void actionPerformed(ActionEvent evt) {
        Object o = evt.getSource();
        if (o instanceof JButton) {
            JButton btn = (JButton) o;
            if (btn.getText().equals("Start") || btn.getText().equals("Restart")) {
                if (onoff == 0) {
                    onoff = 1;
                    initCrono();
                    this.btn.setText("Stop");
                }
            } else if (btn.getText().equals("Stop")) {
                if (onoff == 1) {
                    onoff = 0;
                    stopCrono();
                    this.btn.setText("Restart");
                }
            }
        }
    }

    //Iniciar el cronometro poniendo cronoActive 
    //en verdadero para que entre en el while
    public void initCrono() {
        cronoActive = true;
        fil = new Thread(this);
        fil.start();
    }

    //Esto es para parar el cronometro
    public void stopCrono() {
        cronoActive = false;
        onoff = 0;
    }

    public String getTemps() {
        return this.tempsFinal;
    }

}
