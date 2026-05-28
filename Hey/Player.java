package fightingGame21;

public class Player extends Character {
public String[] action1={"punch","kick","slash"};
 public Player(String name, int HP, int MP, int Power, int TS) {
	 super(name,HP,MP,Power,TS);
	 
 }
 
 public void attack(Character target, String action) {
	 normalAttack(3);
	 gainPower(5);
	 target.takeDamage(10);
	 System.out.println(getName()+" "+action+" "+target.getName());
 }
 
public boolean punchKick(Character target) {
	DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
	if(getMP()>=20) {
	 useMP(20);
	 gainPower(10);
	 target.takeDamage(16);
	 System.out.println(getName()+" use Crushing Impact. "+target.getName()+" staggers backward, almost losing balance.");
	 DebugLog.write("[CHECK] Result=true");
	 return true;
	}else {
		System.out.println("You don't have enough MP.");
		DebugLog.write("[CHECK] Result=false");
		return false;
	}
	 
 }

public boolean kickSlash(Character target) {
	DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
	if(getMP()>=20) {
		 useMP(20);
		 gainPower(10);
		 target.takeDamage(16);
		 System.out.println(getName()+" use Cyclone Break. "+target.getName()+" raises arms to guard, sliding back across the ground.");
		 DebugLog.write("[CHECK] Result=true");
		 return true;
		}else {
			System.out.println("You don't have enough MP.");
			DebugLog.write("[CHECK] Result=false");
			return false;
		}
}

public boolean punchSlash(Character target) {
	DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
	if(getMP()>=20) {
		 useMP(20);
		 gainPower(10);
		 target.takeDamage(16);
		 System.out.println(getName()+" use Raging Cross. "+target.getName()+" gets knocked sideways, feet digging into the dirt to recover.");
		 DebugLog.write("[CHECK] Result=true");
		 return true;
		}else {
			System.out.println("You don't have enough MP.");
			 DebugLog.write("[CHECK] Result=false");
			return false;
		}
}

public boolean punchKickSlash(Character target) {
	DebugLog.write("[CHECK] MP required=40, current MP="+getMP());
	if(getMP()>=40) {
		 useMP(40);
		 gainPower(20);
		 target.takeDamage(24);
		 System.out.println(getName()+" use Dragon Burst. "+target.getName()+" drops to one knee, then manages to get up.");
		 DebugLog.write("[CHECK] Result=true");
		 return true;
		}else {
			System.out.println("You don't have enough MP.");
			 DebugLog.write("[CHECK] Result=false");
			return false;
		}
}

}
