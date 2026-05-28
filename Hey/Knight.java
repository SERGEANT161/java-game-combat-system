package fightingGame21;

public class Knight extends Character{
	private int phase;
	private String[] action1={"heavy slash","bash","war cry"};
	private String[] action2={"iron spike thrust","trial blade","crushing arc"};
	private String[] word1={
			"“This is all you’ve got?”",
			"“I’ve taken worse hits training squires.”",
			"“You’re persistent. I’ll give you that.”",
			"“Pain reminds me I’m still standing.”",
			"“Keep going. Maybe you'll earn the right to kill me.”",
			"“I haven’t even started fighting seriously.”",
			"“Your resolve is louder than your strength.”",
			"“Don’t slow down now. You’ll disappoint me.”"};
	private String[] word2={
			"“Why do you fight this hard...? For glory? For guilt?”",
			"“You think I haven't bled for better reasons than yours?”",
			"“Don’t pretend you’re righteous. None of us are.”",
			"“You're not afraid to fall. I respect that.”",
			"“If you're here to kill me, stop hesitating.”",
			"“Every strike... reminds me what I’ve lost.”",
			"“You want a monster? You're shaping one.”",
			"“You're strong. But strength alone won't save you.”"};
	private String[] word3={
    		"“I won't die before I protect what's mine.”",
    		"“If the world wants me broken — they can break with me.”",
    		"“Do you enjoy this? Watching me fall?”",
    		"“You don’t understand what you’re destroying!”",
    		"“Heroes... killers... you’re all the same.”",
    		"“My body fails. My will doesn't.”",
    		"“Every cut you give me — I remember a face I couldn't save.”",
    		"“You want the truth? You're too late for it.”"};
	private String[] word4={
    		"“Even if I crawl... I stand between them and death.”",
    		"“You can break my bones — not the promise I made.”",
    		"“If I fall here... then you protect them. Swear it.”",
    		"“Kill me if you must — but don’t you dare forget why I fought.”",
    		"“I have nothing left except the reason I draw breath.”",
    		"“I bleed so they don’t. That’s my sin.”",
    		"“If strength is what you want — THEN DIE PROVING IT.”",
    		"“Finish it. Or I will.”"};
	private String[] word5={
    		"“If the world wants a beast — I’ll show them a BEAST.”",
    		"“Mercy is gone. So is restraint.”",
    		"“You opened this door. Walk through it.”",
    		"“I don’t care who you are anymore. I will break you.”",
    		"“My purpose died. Now only rage remains.”",
    		"“The only language left between us is pain.”",
    		"“I refuse peace. I refuse salvation. I refuse YOU.”",
    		"“You wanted a fight — then DROWN in it!”"};
	public Knight(String name, int HP, int MP, int Power, int TS) {
		 super(name,HP,MP,Power,TS);
		 phase=1;
	 }
	
	public int getPhase() {
		return phase;
	}
	
	public String[] getWord1() {
		return word1;
	}
	
	public String[] getWord2() {
		return word2;
	}
	
	public String[] getWord3() {
		return word3;
	}
	
	public String[] getWord4() {
		return word4;
	}
	
	public String[] getWord5() {
		return word5;
	}
	
	 //phase 1
	public String[] getAction1(){
		return action1;
	}
	
	 public void attack(Character target, String action) {
		 normalAttack(3);
		 gainPower(5);
		 target.takeDamage(5);
		 System.out.println(getName()+" "+action+" "+target.getName());
	 }
	 
	 public void warCry(String action) {
		 normalAttack(3);
		 gainPower(5);
		 heal(12);
		 System.out.println(getName()+" "+action);
	 }
	 
	public boolean heavyslashBash(Character target) {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
		 useMP(20);
		 gainPower(5);
		 target.takeDamage(8);
		 System.out.println(getName()+" uses Crushing Blade Strike, swinging down with brutal momentum.");
		 DebugLog.write("[CHECK] Result=true");
		 return true;
		}else {
			DebugLog.write("[CHECK] Result=false");
			return false;
		}
		 
	 }

	public boolean bashWarcry(Character target) {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
			 useMP(20);
			 gainPower(10);
			 target.takeDamage(8);
			 System.out.println(getName()+" uses Rallying Execution, roaring and striking in a single overwhelming motion.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}

	public boolean heavyslashWarcry(Character target) {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
			 useMP(20);
			 gainPower(10);
			 target.takeDamage(8);
			 System.out.println(getName()+" uses Iron Will Impact, slams forward, fueled by a furious battle shout.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}

	public boolean combo1(Character target) {
		DebugLog.write("[CHECK] MP required=40, current MP="+getMP());
		if(getMP()>=40) {
			 useMP(40);
			 gainPower(20);
			 target.takeDamage(12);
			 System.out.println(getName()+" uses Valiant Judgment. With a deafening shout, "+getName()+" unleashes a decisive finishing blow.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}
	
	//phase 2
	public String[] getAction2(){
		return action2;
	}
	
	public void normalAttack(Character target, String action) {
		 normalAttack(6);
		 gainPower(10);
		 target.takeDamage(10);
		 System.out.println(getName()+" "+action+" "+target.getName());
	}
	
	public boolean ironspikethrusTrialblade(Character target) {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
			 useMP(20);
			 gainPower(20);
			 target.takeDamage(12);
			 System.out.println(getName()+" uses Obsidian Break. A chained strike combining raw weight and precision.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}
	
	public boolean trialbladeCrushingarc() {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
			 useMP(20);
			 gainPower(20);
			 heal(20);
			 System.out.println(getName()+" uses Steel Requiem. His wounds recovers quickly.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}
	
	public boolean ironspikethrustCrushingarc(Character target) {
		DebugLog.write("[CHECK] MP required=20, current MP="+getMP());
		if(getMP()>=20) {
			 useMP(20);
			 gainPower(20);
			 target.takeDamage(12);
			 System.out.println(getName()+" uses Cathedral Shatter. A relentless advance that leaves no room to retreat.");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}
	
	public boolean combo2(Character target) {
		DebugLog.write("[CHECK] MP required=40, current MP="+getMP());
		if(getMP()>=40) {
			 useMP(40);
			 gainPower(40);
			 target.takeDamage(18);
			 System.out.println(getName()+" uses Godsplitter!");
			 DebugLog.write("[CHECK] Result=true");
			 return true;
			}else {
				DebugLog.write("[CHECK] Result=false");
				return false;
			}
	}
	
	public void transform() {
		phase=2;
		setHP(getHP()+20);
		setMP(getMP()+20);
		DebugLog.write("[STATE] Knight phase=2 HP="+getHP()+" MP="+getMP());
	}
	
}
