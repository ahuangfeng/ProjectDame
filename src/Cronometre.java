
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
                //stetique: quand le numero est d'un seul chiffre, ajouter un zero devant
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
                this.tempsFinal = this.temps.getText();
            }
        } catch (Exception e) {
        }
        //temps.setText("Temps ecoule : 00:00:000");
    }

    public void actionPerformed(ActionEvent evt) {
        Object o = evt.getSource();
        if (o instanceof JButton) {
            JButton btn = (JButton) o;
            //si le text du bouton est Start ou Restart, mettre le crono en marche
            if (btn.getText().equals("Start") || btn.getText().equals("Restart")) {
                if (onoff == 0) {
                    onoff = 1;
                    initCrono();
                    this.btn.setText("Stop");
                }
                //si text du bouton = Stop, arretez le crono
            } else if (btn.getText().equals("Stop")) {
                if (onoff == 1) {
                    onoff = 0;
                    stopCrono();
                    this.btn.setText("Restart");
                }
            }
        }
    }

    //methode pour initializer le crono
    public void initCrono() {
        cronoActive = true;
        fil = new Thread(this);
        fil.start();
    }

    //arrete le crono
    public void stopCrono() {
        cronoActive = false;
        onoff = 0;
    }

    //donne le temps final
    public String getTemps() {
        return this.tempsFinal;
    }

}
