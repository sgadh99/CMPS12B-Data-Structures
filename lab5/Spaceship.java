public abstract class Spaceship{
	protected int shields;
	protected int weapon; 
	protected boolean dead;
	public Spaceship() {
		shields=0;
		weapon=0;
		dead=false;
	}
	public int getWeapon() {
		return weapon;
	}
	public boolean isDead() {
		return dead;
	}
	public void hit(int damage) {
		shields= shields-damage;
		if(shields<0) {
			System.out.println("Boom.");
			dead= true;
		}
	}
	public String toString() {
		return "SpaceShip";
	}
}
