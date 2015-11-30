
import java.util.Arrays;

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
				
                            if((i%2)==0){
                                if(((j%2))==0){
                                    this.tableau[i][j]=new Case(i,j,false,0);
                                }else{
                                    this.tableau[i][j]=new Case(i,j,false,1);
                                }
                            }else if((i%2)==1){
                                if(((j%2))==0){
                                    this.tableau[i][j]=new Case(i,j,false,1);
                                }else{
                                    this.tableau[i][j]=new Case(i,j,false,0);
                                }
                            }
                            
                            
			}
			
		}
	}
        
        public String toString(){
            String res="";
            for(int i=0;i<this.tableau.length;i++){
                for(int j=0;j<this.tableau[0].length;j++){
                    res=res+this.tableau[i][j];
                }
                res+= "\n";
            }
            return res;
        }
}


