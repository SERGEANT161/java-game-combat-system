package fightingGame21;
import java.util.*;

public class EventSystem {
	private static final Random rand = new Random();
	public static String randomEvent(NPC npc) {
		String[] events={};
		String event=" ";
		if (npc.getFatigue() <= 30 && npc.getMood() >= 70){
			events = npc.getEntertainment2();
			npc.loseFatigueMin();
		}else if (npc.getFatigue() <= 50 && npc.getMood() >= 40){
			events = npc.getEntertainment1();
			npc.loseFatigueMin();
		}else if (npc.getFatigue() <= 60){
			events = npc.getWork();
			npc.gainFatigueMin();
		}else {
			events = npc.getRest();
			npc.loseFatigueMax();
			}
		int random=rand.nextInt(events.length);
		event=events[random];
		return event;
	}

}
