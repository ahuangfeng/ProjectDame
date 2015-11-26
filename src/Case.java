/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexHF
 */

public class Case {
	
        private int ligne;
        private int colonne;
        private boolean presence;

        public Case(int ligne,int colonne, boolean presence) {
                this.ligne=ligne;
                this.colonne=colonne;
                this.presence=presence;
        }

        public int getLigne(){
                return this.ligne;
        }

        public int getColonne(){
                return this.colonne;
        }

        public void setPresence(boolean pre){
                this.presence=pre;
        }
}
