package Hey;
import java.util.Random;
import java.util.Scanner;

public class Check {
	public static void main(String[] args) {
		
		
	}
	
	public static void checkHP1(Player user,Player npc) {
		if (user.HP <= 0) {System.out.println("");System.out.println("Oh no, you lose.");checkReplay();}
		if (npc.HP <= 0) {System.out.println("");System.out.println("The Knight finally collapsed.");FightingGame.talk(user,npc);}
		
		
	}
	
	public static void checkHP2(Player user,Player npc) {
		if (user.HP <= 0) {System.out.println("");System.out.println("Oh no, you lose.");checkReplay();}
		if (npc.HP <= 0) {
			System.out.println("");
			System.out.println("The final strike lands so cleanly that the rage drains out of him before the blood does.");
		    System.out.println("The knight sinks to one knee, fingers slipping from the hilt as if it suddenly weighs a lifetime.");
		    System.out.println("His breathing steadies, not in panic, but in acceptance.");
		    System.out.println("A faint, exhausted smile crosses his face... the first peace he’s shown in the entire fight.");
		    System.out.println("“So this is what it takes... to stop me. At least... the world chose someone stubborn enough.”");
		    System.out.println("He looks up at you, eyes no longer angry — just tired.");
		    System.out.println("“Don’t make my sin your burden. Protect something… but don’t let it destroy you the way it destroyed me.”");
		    System.out.println("His head bows forward, not collapsing — more like a soldier choosing to rest for the first time.");
		    System.out.println("“Live... where I couldn’t.”");
		    System.out.println("And his body finally goes still.");
		    System.out.println("");
		    System.out.println("The end.");System.exit(0);
		}
	}
	
	public static void checkPower(Player user,Player npc) {
		
		if (user.Power >= 100) {
			System.out.println("Your powerful skill can be used. Do you want to use it? ");
			Scanner input=new Scanner(System.in);
		    String choice=input.next();
		    String choice1=choice.toLowerCase();
		    if (choice1.contains("yes")) {user.Power-=100;System.out.println("You uses Shock Pulse! The Knight is hurt hard.");
		    npc.HP-=30;}}
		if (npc.Power >= 100) {
			System.out.println("The Knight uses his powerful skill: Rage Charge!"); 
		    npc.Power -= 100;
		    user.HP-=30;}
		
	
	
	}
	
	
	public static void checkMP11(Player user,Player npc){
		if (user.MP < 0) {
			user.MP+=user.TS;user.TS=0;System.out.println("You don't have enough MP to use this combo. Your MP now is "+user.MP+".");
			FightingSystem.fightingAction1(user, npc);}
		if (npc.MP < 0) { 
			npc.MP+=npc.TS;npc.TS=0;System.out.println();
		    FightingSystem.fightingAction2(user, npc);}
		if (npc.MP>=0&&npc.TS!=0) npc.TS=10;
		if (user.MP>=0&&user.TS!=0) user.TS=10;
	}
	
	public static void checkMP22(Player user,Player npc){
		if (user.MP < 0) {
			user.MP+=user.TS;user.TS=0;System.out.println("You don't have enough MP to use this combo. Your MP now is "+user.MP+".");
			FightingSystem.fightingAction4(user, npc);}
		if (npc.MP < 0) { 
			npc.MP+=npc.TS;npc.TS=0;System.out.println();
		    FightingSystem.fightingAction3(user, npc);}
		if (npc.MP>=0&&npc.TS!=0) npc.TS=10;
		if (user.MP>=0&&user.TS!=0) user.TS=10;
	}
	
	public static void checkReplay() {
		Scanner input=new Scanner(System.in);
		System.out.print("Do you want to try again? ");
		String choice=input.next();
	    String choice1=choice.toLowerCase();
	    if (choice1.contains("yes")) System.out.println("Game restarting...");FightingGame.main(null);
	    if (choice1.contains("no")) System.out.println("Game over.");System.exit(0);
		
		
	}
	
	public static void checkAction1(Player user,Player npc,String action) {
		String action1=action.toLowerCase();
		if (action1.contains("punch")&&action1.contains("kick")&&action1.contains("slash")) {
			user.Power+=20;npc.HP-=24;
			System.out.println("You use Dragon Burst. The Knight drops to one knee, then manages to get up.");}
		else if (action1.contains("punch")&&action1.contains("kick")) {
			user.Power+=10;npc.HP-=16;
			System.out.println("You use Crushing Impact. The Knight staggers backward, almost losing balance.");}
		else if (action1.contains("kick")&&action1.contains("slash")) {
			user.Power+=10;npc.HP-=16;
			System.out.println("You use Cyclone Break. The Knight raises arms to guard, sliding back across the ground.");}
		else if (action1.contains("punch")&&action1.contains("slash")) {
			user.Power+=10;npc.HP-=16;
			System.out.println("You use Raging Cross. The Knight gets knocked sideways, feet digging into the dirt to recover.");}
		else if (action1.contains("punch")) {
			user.MP+=3;user.Power+=5;npc.HP-=10;
			System.out.println("You punch Knight.");}
		else if (action1.contains("kick")) {
			user.MP+=3;user.Power+=5;npc.HP-=10;
			System.out.println("You kick Knight.");}
		else if (action1.contains("slash")) {
			user.MP+=3;user.Power+=5;npc.HP-=10;
			System.out.println("You slash Knight.");}
		else {
			System.out.println("Text recognition failed.");
		    FightingSystem.fightingAction1(user, npc);}
		
		
		
		
	}
	
	public static void checkAction2(Player user,Player npc,String action) {
		if (action.contains("heavy slash")&&action.contains("bash")&&action.contains("war cry")) {
			npc.Power+=20;user.HP-=12;System.out.println("The Knight uses Valiant Judgment. With a deafening shout, the knight unleashes a decisive finishing blow.");}
		else if (action.contains("heavy slash")&&action.contains("bash")) {
			npc.Power+=10;user.HP-=8;System.out.println("The Knight uses Crushing Blade Strike, swinging down with brutal momentum.");}
		else if (action.contains("bash")&&action.contains("war cry")) {
			npc.Power+=10;user.HP-=8;System.out.println("The Knight uses Rallying Execution, roaring and striking in a single overwhelming motion.");}
		else if (action.contains("heavy slash")&&action.contains("war cry")) {
			npc.Power+=10;user.HP-=8;System.out.println("The Knight uses Iron Will Impact, slams forward, fueled by a furious battle shout.");}
		else if (action.contains("heavy slash")) {
			npc.MP+=3;npc.Power+=5;user.HP-=5;System.out.println("Knight uses Heavy Slash to you.");}
		else if (action.contains("bash")) {
			npc.MP+=3;npc.Power+=5;user.HP-=5;System.out.println("Knight bashes you.");}
		else if (action.contains("war cry")) {
			npc.MP+=3;npc.Power+=5;npc.HP+=12;System.out.println("Knight uses War Cry, healing some of his wounds.");}
		
	}
	
	public static void checkAction3(Player user,Player npc,String action) {
		if (action.contains("iron spike thrust")&&action.contains("trial blade")&&action.contains("crushing arc")) {
			npc.Power+=40;user.HP-=18;System.out.println("The Knight uses Godsplitter!");}
		else if (action.contains("iron spike thrust")&&action.contains("trial blade")) {
			npc.Power+=20;user.HP-=12;System.out.println("The Knight uses Obsidian Break. A chained strike combining raw weight and precision.");}
		else if (action.contains("trial blade")&&action.contains("crushing arc")) {
			npc.Power+=20;npc.HP+=20;System.out.println("The Knight uses Steel Requiem. His wounds recovers quickly.");}
		else if (action.contains("iron spike thrust")&&action.contains("crushing arc")) {
			npc.Power+=20;user.HP-=12;System.out.println("The Knight uses Cathedral Shatter. A relentless advance that leaves no room to retreat.");}
		else if (action.contains("iron spike thrust")) {
			npc.MP+=6;npc.Power+=10;user.HP-=10;System.out.println("Knight uses Iron Spike Thrust to you.");}
		else if (action.contains("trial blade")) {
			npc.MP+=6;npc.Power+=10;user.HP-=10;System.out.println("Knight uses Trial Blade to you.");}
		else if (action.contains("crushing arc")) {
			npc.MP+=6;npc.Power+=10;user.HP-=10;System.out.println("Knight uses Crushing Arc to you.");}
		
	}
	
	public static void checkWord(Player cha) {
		Random rand=new Random();
		int num1=rand.nextInt(cha.word1.length-1);
		if (cha.HP>64) System.out.println(cha.word1[num1]);
		else if (cha.HP>40) System.out.println(cha.word2[num1]);
		else if (cha.HP>16) System.out.println(cha.word3[num1]);
		else if (cha.HP>0) System.out.println(cha.word4[num1]);
	}
	
	public static boolean checkMP1(Player user,Player npc,String action) {
		String action1=action.toLowerCase();
		if (action1.contains("punch")&&action1.contains("kick")&&action1.contains("slash")) {
			user.MP-=40;user.TS=40;checkMP11(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("punch")&&action1.contains("kick")) {
			user.MP-=20;user.TS=20;checkMP11(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("kick")&&action1.contains("slash")) {
			user.MP-=20;user.TS=20;checkMP11(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("punch")&&action1.contains("slash")) {
			user.MP-=20;user.TS=20;checkMP11(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else {user.TS=0;return true;}
		
		
		
		
	}
	
	public static boolean checkMP2(Player user,Player npc,String action) {
		if (action.contains("heavy slash")&&action.contains("bash")&&action.contains("war cry")) {
			npc.MP-=40;npc.TS=40;checkMP11(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("heavy slash")&&action.contains("bash")) {
			npc.MP-=20;npc.TS=20;checkMP11(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("bash")&&action.contains("war cry")) {
			npc.MP-=20;npc.TS=20;checkMP11(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("heavy slash")&&action.contains("war cry")) {
			npc.MP-=20;npc.TS=20;checkMP11(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else {npc.TS=0;return true;}
	}
	
	public static boolean checkMP3(Player user,Player npc,String action) {
		if (action.contains("iron spike thrust")&&action.contains("trial blade")&&action.contains("crushing arc")) {
			npc.MP-=40;npc.TS=40;checkMP22(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("iron spike thrust")&&action.contains("trial blade")) {
			npc.MP-=20;npc.TS=20;checkMP22(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("trial blade")&&action.contains("crushing arc")) {
			npc.MP-=20;npc.TS=20;checkMP22(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else if (action.contains("iron spike thrust")&&action.contains("crushing arc")) {
			npc.MP-=20;npc.TS=20;checkMP22(user,npc);if(npc.TS==10) {npc.TS=0;return true;}else return false;}
		else {npc.TS=0;return true;}
	}
	
	public static boolean checkMP4(Player user,Player npc,String action) {
		String action1=action.toLowerCase();
		if (action1.contains("punch")&&action1.contains("kick")&&action1.contains("slash")) {
			user.MP-=40;user.TS=40;checkMP22(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("punch")&&action1.contains("kick")) {
			user.MP-=20;user.TS=20;checkMP22(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("kick")&&action1.contains("slash")) {
			user.MP-=20;user.TS=20;checkMP22(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else if (action1.contains("punch")&&action1.contains("slash")) {
			user.MP-=20;user.TS=20;checkMP22(user,npc);if(user.TS==10) {user.TS=0;return true;}else return false;}
		else {user.TS=0;return true;}
		
		
		
		
	}
	
}
