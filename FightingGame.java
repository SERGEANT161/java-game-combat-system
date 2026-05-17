package fightingGame12;

import java.util.Scanner;

public class FightingGame {
	
	public static void main(String[] args) {
		Player user=new Player("YOU",100, 100, 0,0);
        Knight npc=new Knight("Knight",80, 80, 0,0);
        Plot.introduction();
		while(true) {
		FightingSystem.fightingActionUSER(user, npc);
		FightingSystem.fightingActionNPC(user, npc);
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
	
	
	
}
