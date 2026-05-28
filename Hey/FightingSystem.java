package fightingGame21;
import java.util.Scanner;
import java.util.Random;
public class FightingSystem {

	
	public static void fightingActionUSER(Player user,Knight npc){
		
		    boolean okay=false;
			Scanner input=new Scanner(System.in);
			while(!okay) {
			System.out.print("Enter your action: ");
			String action1=input.nextLine();
			DebugLog.write("[INPUT] Player raw input: "+action1);
			okay=Check.checkAction1(user,npc,action1);
			}
			if(npc.getPhase()==1) {
			Check.checkHP1(user,npc);
			}else {Check.checkHP2(user, npc);}
			Check.checkPower(user,npc);
			if(npc.getPhase()==1) {
			Check.checkHP1(user,npc);
			}else {Check.checkHP2(user, npc);}
			System.out.println("");
			System.out.println("Now the Knight's HP is "+npc.getHP()+". MP is "+npc.getMP()+". Power is "+npc.getPower()+".");
			return;
			 
			
			
		
	}
	
	public static void fightingActionNPC(Player user,Knight npc) {
		Check.checkWord(npc);
		boolean okay=false;
		while(!okay) {
		String action2=MoveEvaluator.chooseKnightMove(user,npc);
		DebugLog.write("[INPUT] NPC raw input: "+action2);
		if(npc.getPhase()==1) {
		okay=Check.checkAction2(user,npc,action2);
		}else {
		okay=Check.checkAction3(user,npc,action2);
		}
		}
		if(npc.getPhase()==1) {
		Check.checkHP1(user,npc);
		Check.checkPower(user,npc);
		Check.checkHP1(user,npc);
		}else {
		Check.checkHP2(user,npc);
		Check.checkPower(user,npc);
		Check.checkHP2(user,npc);}
		System.out.println("");
		System.out.println("Now Your HP is "+user.getHP()+". MP is "+user.getMP()+". Power is "+user.getPower()+".");
		
		
	}
	
	
	
	
	
}
