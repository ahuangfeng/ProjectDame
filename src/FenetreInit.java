/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */
import javax.swing.*;
import java.awt.*;

public class FenetreInit extends JFrame {
    //création des éléments constitutifs de la fenetre

    private JLabel titre;
    private JLabel joueur1;
    private JLabel joueur2;
    private JLabel pseudo;
    private JLabel pseudo2;
    private JLabel age1;
    private JLabel age2;
    private JTextField nom;
    private JTextField nom2;
    private JTextField textAge1;
    private JTextField textAge2;
    private String[] options = {"Marron", "Blanc"};
    private JComboBox liste;
    private JButton regles;
    private JButton commencer;
    private JLabel phrase;

    //création des écouteurs
    private EcouteurBoutonRegle ecouteurBtnRegle;
    private EcouteurBoutonCommencerJeu ecouteurBtnCommencerLeJeu;

    public FenetreInit() {
        super("Jeu de dame");
        // initialitation des elements de la fenetre
        this.titre = new JLabel("JEU DE DAME");
        this.titre.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        this.joueur1 = new JLabel("Joueur 1 ");
        this.joueur1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        this.joueur2 = new JLabel("Joueur 2 ");
        this.joueur2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        this.pseudo = new JLabel("Pseudo : ");
        this.pseudo2 = new JLabel("Pseudo : ");
        this.age1 = new JLabel("Age");
        this.age2 = new JLabel("Age");
        this.nom = new JTextField(5);
        this.nom2 = new JTextField(5);
        this.textAge1 = new JTextField(5);
        this.textAge2 = new JTextField(5);
        this.liste = new JComboBox(options);
        this.regles = new JButton("Regle du jeu");
        this.commencer = new JButton("Commence le jeu");
        this.phrase = new JLabel("Info : le joueur le plus jeune commencera la partie ");
        this.phrase.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

        ecouteurBtnRegle = new EcouteurBoutonRegle(this);
        regles.addActionListener(ecouteurBtnRegle);
        ecouteurBtnCommencerLeJeu = new EcouteurBoutonCommencerJeu(this);
        commencer.addActionListener(ecouteurBtnCommencerLeJeu);

        //création des éléments constructifs de la fenetre
        JPanel cadre = new JPanel(new BorderLayout());
        JPanel tete = new JPanel(new FlowLayout());
        JPanel jou1 = new JPanel(new FlowLayout());
        JPanel jou2 = new JPanel(new FlowLayout());
        JPanel grid = new JPanel(new GridLayout(7, 1));
        JPanel ligne1 = new JPanel(new FlowLayout());
        JPanel ligne2 = new JPanel(new FlowLayout());
        JPanel frase = new JPanel(new FlowLayout());
        JPanel fin = new JPanel(new FlowLayout());
        ligne1.add(this.pseudo);
        ligne1.add(this.nom);
        ligne1.add(this.age1);
        ligne1.add(this.textAge1);
        ligne1.add(this.liste);
        ligne2.add(this.pseudo2);
        ligne2.add(this.nom2);
        ligne2.add(this.age2);
        ligne2.add(this.textAge2);

        tete.add(this.titre);
        grid.add(tete);
        jou1.add(this.joueur1);
        grid.add(jou1);
        grid.add(ligne1);
        jou2.add(this.joueur2);
        grid.add(jou2);
        grid.add(ligne2);
        frase.add(this.phrase);
        grid.add(frase);
        fin.add(this.regles);
        fin.add(this.commencer);
        grid.add(fin);

        cadre.add(grid, BorderLayout.CENTER);

        setContentPane(cadre);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    //methodes pour pouvoir se servir des informations saisie par l'utilisateur du programme
    public String getSaisieNom1() {
        return (nom.getText());
    }

    public String getSaisieNom2() {
        return (nom2.getText());
    }

    public String getTextAge1() {
        return textAge1.getText();
    }

    public String getTextAge2() {
        return textAge2.getText();
    }

    public int getSaisieAge1() {
        return Integer.parseInt(textAge1.getText());
    }

    public int getSaisieAge2() {
        return Integer.parseInt(textAge2.getText());
    }

    public int getSelectedIndex() {
        return liste.getSelectedIndex();
    }

}
