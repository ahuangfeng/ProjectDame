/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */
public class Plateau {
	
	private Case[][] tableau;
	
	
	public Plateau(){
		this.tableau = new Case[10][10];
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if((i % 2)==0){
                                    this.tableau[i][j]=new Case(i,j,false,0);
                                }else{
                                    this.tableau[i][j]=new Case(i,j,false,1);
                                }
			}
			
		}
	}
}


