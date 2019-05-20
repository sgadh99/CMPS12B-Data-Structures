public class StarWarsBattle{
	public static void main(String []args) {
		StarWars2 galaxy= new StarWars2();
		Spaceship[] fighters= new Spaceship[6];
		for(int i=0; i<fighters.length; i++){
			if(i%2==0) 
				fighters[i]= new XWing();
			else
				fighters[i]= new Tie();
		}
		galaxy.battle(fighters);
		for(int i=0;i<fighters.length;i++){
			if(i<fighters.length/2)
				fighters[i]= new XWing();
			else
				fighters[i]= new Tie();
		}
		galaxy.battle(fighters);
	}
}
