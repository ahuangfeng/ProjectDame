public Case(int u){
		setLayout(new GridLayout(1,0));
		this.couleur=u;
		if(u==0){
			setBackground(Color.DARK_GRAY);
		}else if(u==1){
			setBackground(Color.WHITE);
		}
	}
	
	public boolean estChoisie(){
		return choisie;
	}
	
	public void setChoisie(boolean choisie){
		this.choisie=choisie;
	}
	
	
	
	
}
	


