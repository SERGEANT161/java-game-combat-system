package fightingGame21;

public abstract class Character {
	private String name;
	private int HP;
	private int MP;
	private int Power;
	private int TS;
	

	public Character(String name,int HP, int MP, int Power,int TS) {
		this.name=name;
		this.HP=HP;
		this.MP=MP;
		this.Power=Power;
		this.TS=TS;
		
		
		
	}
	
	public String getName(){ 
		return name;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getMP() {
		return MP;
	}
	
	public int getPower() {
		return Power;
	}
	
	public int getTS() {
		return TS;
	}
	
	public void setHP(int HP) {
		this.HP=HP;
	}
	
	public void setMP(int MP) {
		this.MP=MP;
	}
	
	public void setPower(int Power) {
		this.Power=Power;
	}
	
	public void setTS(int TS) {
		this.TS=TS;
	}
	
	public void takeDamage(int amount) {
		HP-=amount;
		if(HP<0) HP=0;
	}
	
	public void heal(int amount) {
		HP+=amount;
	}
	
	public void useMP(int amount) {
		MP-=amount;
		if(MP<0) MP=0;
	}
	
	public void normalAttack(int amount) {
		MP+=amount;
	}
	
	public void gainPower(int amount) {
		Power+=amount;
	}
	
	public void usePower(int amount) {
		Power-=amount;
	}
	
	public void reset(String name,int HP, int MP, int Power,int TS) {
		this.name=name;
		this.HP=HP;
		this.MP=MP;
		this.Power=Power;
		this.TS=TS;
	}
	
	public abstract void attack(Character target, String action);
}
