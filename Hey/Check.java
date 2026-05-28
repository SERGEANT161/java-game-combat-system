package fightingGame21;
import java.util.Random;
import java.util.Scanner;

public class Check {
	public static void main(String[] args) {
		
		
	}
	
	public static void checkHP1(Player user,Knight npc) {
		if (user.getHP() <= 0) {System.out.println("");System.out.println("Oh no, you lose.");checkReplay();}
		if (npc.getHP() <= 0) {System.out.println("");System.out.println("The Knight finally collapsed.");Plot.talk(user,npc);}
		
		
	}
	
	public static void checkHP2(Player user,Knight npc) {
		if (user.getHP() <= 0) {System.out.println("");System.out.println("Oh no, you lose.");checkReplay();}
		if (npc.getHP() <= 0) {
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
	
	public static void checkPower(Player user,Knight npc) {
		
		if (user.getPower() >= 100) {
			System.out.println("Your powerful skill can be used. Do you want to use it? ");
			Scanner input=new Scanner(System.in);
		    String choice=input.next();
		    String choice1=choice.toLowerCase();
		    if (choice1.contains("yes")) {user.usePower(100);System.out.println("You uses Shock Pulse! The Knight is hurt hard.");
		    npc.takeDamage(30);}}
		if (npc.getPower() >= 100) {
			System.out.println("The Knight uses his powerful skill: Rage Charge!"); 
		    npc.usePower(100);
		    user.takeDamage(30);}
		
	
	
	}
	
	
	
	
	public static void checkReplay() {
		Scanner input=new Scanner(System.in);
		String choice1;
		while(true) {
		System.out.println("Do you want to try again? ");
		String choice=input.nextLine();
	    choice1=choice.toLowerCase();
	    if (choice1.contains("yes")||choice1.contains("no"))break;
	    else System.out.println("Text recognition failed.");
		}
		if (choice1.contains("yes")){System.out.println("Game restarting...");System.out.println("");FightingGame.main(null);}
	    if (choice1.contains("no")) {System.out.println("Game over.");System.exit(0);}
	}
	
	public static boolean checkAction1(Player user,Knight npc,String action) {
		boolean okay=true;
		String action1=action.toLowerCase();
		if (action1.contains("punch")&&action1.contains("kick")&&action1.contains("slash")) {
			DebugLog.write("[PARSE] Player action matched: punch + kick + slash");
			okay=user.punchKickSlash(npc);
			return okay;
		}
		else if (action1.contains("punch")&&action1.contains("kick")) {
			DebugLog.write("[PARSE] Player action matched: punch + kick");
			okay=user.punchKick(npc);
			return okay;
		}
		else if (action1.contains("kick")&&action1.contains("slash")) {
			DebugLog.write("[PARSE] Player action matched: kick + slash");
			okay=user.kickSlash(npc);
			return okay;
		}
		else if (action1.contains("punch")&&action1.contains("slash")) {
			DebugLog.write("[PARSE] Player action matched: punch + slash");
			okay=user.punchSlash(npc);
			return okay;
		}
		else if (action1.contains("punch")) {
			DebugLog.write("[PARSE] Player action matched: punch");
			user.attack(npc,"punch");
			return okay;
			}
		else if (action1.contains("kick")) {
			DebugLog.write("[PARSE] Player action matched: kick");
			user.attack(npc,"kick");
			return okay;
			}
		else if (action1.contains("slash")) {
			DebugLog.write("[PARSE] Player action matched: slash");
			user.attack(npc,"slash");
			return okay;
			}
		else {
			DebugLog.write("[PARSE] Player action not matched.");
			System.out.println("Text recognition failed.");
			okay=false;
			return okay;}
		
		
		
		
	}
	
	public static boolean checkAction2(Player user,Knight npc,String action) {
		boolean okay=true;
		if (action.contains("heavy slash")&&action.contains("bash")&&action.contains("war cry")) {
			DebugLog.write("[PARSE] NPC action matched: heavy slash + bash + war cry");
			okay=npc.combo1(user);
			return okay;
			}
		else if (action.contains("heavy slash")&&action.contains("bash")) {
			DebugLog.write("[PARSE] NPC action matched: heavy slash + bash");
			okay=npc.heavyslashBash(user);
			return okay;
			}
		else if (action.contains("bash")&&action.contains("war cry")) {
			DebugLog.write("[PARSE] NPC action matched: bash + war cry");
			okay=npc.bashWarcry(user);
			return okay;
			}
		else if (action.contains("heavy slash")&&action.contains("war cry")) {
			DebugLog.write("[PARSE] NPC action matched: heavy slash + war cry");
			okay=npc.heavyslashWarcry(user);
			return okay;
			}
		else if (action.contains("heavy slash")) {
			DebugLog.write("[PARSE] NPC action matched: heavy slash");
			npc.attack(user,"uses Heavy Slash to");
			return okay;
			}
		else if (action.contains("bash")) {
			DebugLog.write("[PARSE] NPC action matched: bash");
			npc.attack(user,"bashes");
			return okay;
			}
		else if (action.contains("war cry")) {
			DebugLog.write("[PARSE] NPC action matched: war cry");
			npc.warCry("uses War Cry, healing some of his wounds.");
			return okay;
			}
		else{
			DebugLog.write("[PARSE] NPC action not matched.");
			return false;
		    }
		
	}
	
	public static boolean checkAction3(Player user,Knight npc,String action) {
		boolean okay=true;
		if (action.contains("iron spike thrust")&&action.contains("trial blade")&&action.contains("crushing arc")) {
			DebugLog.write("[PARSE] NPC action matched: iron spike thrust + trial blade + crushing arc");
			okay=npc.combo2(user);
			return okay;
		}
		else if (action.contains("iron spike thrust")&&action.contains("trial blade")) {
			DebugLog.write("[PARSE] NPC action matched: iron spike thrust + trial blade");
			okay=npc.ironspikethrusTrialblade(user);
			return okay;
		}
		else if (action.contains("trial blade")&&action.contains("crushing arc")) {
			DebugLog.write("[PARSE] NPC action matched: trial blade + crushing arc");
			okay=npc.trialbladeCrushingarc();
			return okay;
		}
		else if (action.contains("iron spike thrust")&&action.contains("crushing arc")) {
			DebugLog.write("[PARSE] NPC action matched: iron spike thrust + crushing arc");
			okay=npc.ironspikethrustCrushingarc(user);
			return okay;
		}
		else if (action.contains("iron spike thrust")) {
			DebugLog.write("[PARSE] NPC action matched: iron spike thrust");
			npc.normalAttack(user,"uses Iron Spike Thrust to");
			return okay;}
		else if (action.contains("trial blade")) {
			DebugLog.write("[PARSE] NPC action matched: trial blade");
			npc.normalAttack(user,"uses Trial Blade to");
			return okay;}
		else if (action.contains("crushing arc")) {
			DebugLog.write("[PARSE] NPC action matched: crushing arc");
			npc.normalAttack(user,"uses Crushing Arc to");
			return okay;}
		else{
			DebugLog.write("[PARSE] NPC action not matched.");
			return false;
			}
		
	}
	
	public static void checkWord(Knight npc) {
		String[] word1=npc.getWord1();
		String[] word2=npc.getWord2();
		String[] word3=npc.getWord3();
		String[] word4=npc.getWord4();
		String[] word5=npc.getWord5();
		int phase=npc.getPhase();
		Random rand=new Random();
		int num1=rand.nextInt(word1.length);
		if (phase==1) {
		if (npc.getHP()>64) System.out.println(word1[num1]);
		else if (npc.getHP()>40) System.out.println(word2[num1]);
		else if (npc.getHP()>16) System.out.println(word3[num1]);
		else if (npc.getHP()>0) System.out.println(word4[num1]);
	}else {System.out.println(word5[num1]);}
	}
	
	
	
}
