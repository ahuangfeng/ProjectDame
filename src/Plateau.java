
import java.awt.*;
import javax.swing.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */

public class Plateau extends JPanel{
	
	public Plateau() {
		setLayout(new GridLayout(10,10));
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
					ajouterCase(0);
				}
				else{
					ajouterCase(1);
				}
			}
		}
	}
	
	public void ajouterCase(int o){
		Case case1 = new Case(o);
		add(case1);
	}
	
}
