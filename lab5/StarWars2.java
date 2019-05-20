class StarWars2{
	private void duel(Spaceship x, Spaceship t) {
		while(!x.isDead() && !t.isDead()) {
			x.hit(t.getWeapon());
			if(x.isDead()){
				System.out.println(x+ " is dead");
			}
			else {
				t.hit(x.getWeapon());
				if(t.isDead()) {
					System.out.println(t + "is dead");
				}		
			}
		}
	}
	
	private int nextTie(int i, Spaceship[] fighters) {
		assert(i>=0);
		while(i<fighters.length) {
			if(fighters[i] instanceof Tie) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
	private int nextXWing(int i, Spaceship[] fighters) {
		while(i<fighters.length) {
			if(fighters[i] instanceof XWing) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	void battle(Spaceship []fighters) {
		int s=0;
		int x= nextXWing(0, fighters);
		int t= nextTie(0, fighters);
		int xCount= 0;
		int tieCount= 0;
		int wings= 0;
		int ties= 0;
		int goodDeaths= 0;
		int evilDeaths= 0;
		while(s<fighters.length) {
			if(nextXWing(s,fighters)==s) {
				wings++;
			}
			if(nextTie(s,fighters)==s) {
				ties++;
			}
			s++;
		}
	
		while(x!=-1 && t!=-1) {
			System.out.println("battling X-Wing #"+xCount+" versus Tie Fighter #"+tieCount);
			duel(fighters[x], fighters[t]);
			if(fighters[x].isDead()) {
				x=nextXWing(x+1, fighters);
				goodDeaths++;
				xCount++;
			}
			if(fighters[t].isDead()) {
				t= nextTie(t+1,fighters);
				evilDeaths++;
				tieCount++;
			}
		}
		
		int finalGood= wings-goodDeaths;
		int finalEvil= ties-evilDeaths;
		System.out.println();
		System.out.println("Battle Report:\t\tX-Wings\t\tTie Fighters");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("Initial ships:\t\t"+wings+ "\t\t"+ties);
		System.out.println();
		System.out.println("Killed ships:\t\t"  + goodDeaths  + "\t\t" + evilDeaths);
	    System.out.println();
	    System.out.println("Final ships:\t\t"   + finalGood   + "\t\t" + finalEvil);
	    System.out.println();
	    if (finalGood > finalEvil) {
	       System.out.println("The rebel alliance is victorious!");
	    }
	    else {
	         System.out.println("The dark side has conquered!");
	    }
	    System.out.println();
	    }
	}
