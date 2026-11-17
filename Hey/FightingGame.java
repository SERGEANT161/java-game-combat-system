package fightingGame21;

import java.util.Scanner;

public class FightingGame {
	
	public static void main(String[] args) {
		DebugLog.setWork(true);
		DebugLog.cleanLog();
		DebugLog.write("Game starts.");
		Player user=new Player("YOU",100,100,0,0);
        Knight npc=new Knight("Knight",80,80,0,0,35,60,15,55,80,10,true);
        System.out.println("1.New Game");
        System.out.println("2.Developer Mode");
        System.out.print("Select: ");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        switch(choice) {
        case 1:
        	Plot.introduction();
        	while(true) {
        		FightingSystem.fightingActionUSER(user, npc);
        		FightingSystem.fightingActionNPC(user, npc);
        		}
        case 2:
        	System.out.println("1.battle");
            System.out.println("2.dialogue");
            System.out.println("3.camp");
            System.out.print("Select: ");
            int option=input.nextInt();
            switch(option) {
            case 1:
            	Plot.introduction();
            	while(true) {
            		FightingSystem.fightingActionUSER(user, npc);
            		FightingSystem.fightingActionNPC(user, npc);
            		}
            case 2:Plot.talk(user, npc);
            case 3:main2(user, npc);
            }
            break;
        }
	}

	public static void main1(Player user,Knight npc) {
		System.out.println("");
		user.reset("YOU",100, 100, 0,0);
		npc.reset("Knight",80, 80, 0,0);
		npc.transform();
		while(true) {
			FightingSystem.fightingActionUSER(user, npc);
			FightingSystem.fightingActionNPC(user, npc);
			}
	}
	
	public static void main2(Player user,Knight npc) {
		GameTime time=new GameTime(0,0,2);
		Plot.preOfCamp(time,user,npc);
	}
	
}
