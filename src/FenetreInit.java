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

public class FenetreInit extends JFrame{
    //hola
    private JLabel titre = new JLabel("JEU DE DAME");
    private JLabel joueur1 = new JLabel("Joueur 1 ");
    private JLabel joueur2 = new JLabel("Joueur 2 ");
    private JLabel pseudo = new JLabel("Pseudo : ");
    private JLabel pseudo2 = new JLabel("Pseudo : ");
    private JLabel age1 = new JLabel("age");
    private JLabel age2 = new JLabel("age");
    private JTextField nom = new JTextField(5);
    private JTextField nom2 = new JTextField(5);
    private JTextField textAge1 = new JTextField(5);
    private JTextField textAge2 = new JTextField(5);
    private String[] options = {"Blanc","Noir"};
    private JComboBox liste=new JComboBox(options);
    private JButton regles = new JButton("Regle du jeu");
    private JButton commencer = new JButton("Commence le jeu");
    private JLabel phrase = new JLabel("Info : le joueur le plus jeune commencera la partie ");
    
    private EcouteurBoutonRegle ecouteurBtnRegle;
    
    public FenetreInit(){
        super("Jeu de dame");


		ecouteurBtnRegle = new EcouteurBoutonRegle(this);
		regles.addActionListener(ecouteurBtnRegle);
        
        JPanel cadre = new JPanel(new BorderLayout());
        JPanel tete = new JPanel(new FlowLayout());
        JPanel jou1= new JPanel(new FlowLayout());
        JPanel jou2= new JPanel(new FlowLayout());
        JPanel grid = new JPanel(new GridLayout(7,1));
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
        
        cadre.add(grid,BorderLayout.CENTER);
        //cadre.add(vide,BorderLayout.NORTH);
        
        setContentPane(cadre);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
	public String getSaisieNom1(){
		return (nom.getText());
	}
	
	public String getSaisieNom2(){
		return (nom2.getText());
	}

	public String getSaisieAge1(){
		return (textAge1.getText());
	}
	
	public String getSaisieAge2(){
		return (textAge2.getText());
	}
	
	public int getSelectedIndex() {
        return liste.getSelectedIndex();
    }

  
   public static void main(String[] args) {
        new FenetreInit();
    }
    
}

