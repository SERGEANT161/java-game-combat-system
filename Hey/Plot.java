package fightingGame21;

import java.util.Scanner;

public class Plot {
	public static void talk(Player user,Knight npc) {
		System.out.println("");
		boolean fightAgain=false;boolean friend=false;
		System.out.println("The knight collapses to his knees, his weapon slipping from his grasp and clattering onto the ground.");
		System.out.println("His armor is cracked open in several places, his breath ragged and uneven.");
		System.out.println("You stand tall, battered and blood-streaked, but still holding your fighting stance.");
		System.out.println("The knight lets out a small, tired laugh — not arrogance, just exhaustion and a strange sense of relief.");
		System.out.println("“...If you’re here to finish it... go on. I’ve got nothing left to protect.”");
		System.out.println("The air goes so quiet that only the sound of breathing remains.");
		System.out.println("");
		System.out.println("1.Stand up. I’m not done with you.");
		System.out.println("2.You look... tired. How long have you been fighting?");
		System.out.print("Be cautious to your next step(1/2): ");
		Scanner input=new Scanner(System.in);
		int option1=input.nextInt();
		System.out.println("");
		switch(option1) {
		case 1:
			fightAgain=true;
			System.out.println("The Knight chuckles.");
			System.out.println("“No justice. No mercy. You just want the world to hit back harder.”");
			break;
		case 2:
			friend=true;
			System.out.println("“You want answers?”");
			System.out.println("The Knight chuckles.");
			System.out.println("“Look at you... victorious. The world always loves a hero.”");
			break;
		}
		System.out.println("“Do you even know what crime I’m being punished for? Or did someone just tell you I’m a monster, and you swung?”");
		System.out.println("");
		System.out.println("1.Who were you protecting?");
		System.out.println("2.Just tell me why did you do this.");
		System.out.print("Be cautious to your next step(1/2): ");
		int option2=input.nextInt();
		System.out.println("");
		switch(option2) {
		case 1:
			friend=true;
			System.out.println("The Knight takes a deep breath.");
			System.out.println("“Children. People. Families. But they only remember the blood... never the reason.”");
			break;
		case 2:
			fightAgain=true;
			System.out.println("“So everyone wants me dead for protecting them...”");
			System.out.println("“Hum, should've figure it out sooner.”");
			break;
		}
		System.out.println("“If I stop fighting... they die. That’s all you need to know.”");
		System.out.println("“I can take the blame... the hatred... the exile. But what I can’t bear — is one more innocent grave.”");
		System.out.println("");
		System.out.println("1.Don't be so pessimistic. Stand up. I can save you from it.");
		System.out.println("2.You think being a shield makes you noble?");
		System.out.print("Be cautious to your next step(1/2): ");
		int option3=input.nextInt();
		System.out.println("");
		switch(option3) {
		case 1:
			friend=true;
			break;
		case 2:
			fightAgain=true;
			break;
		}
		if (friend&&fightAgain) {
			System.out.println("A weary smile of relief flickers across the Knight’s face.");
			System.out.println("“You’re not cruel enough to kill me. But not kind enough to save me.”");
		    System.out.println("“Let this be my last order... End the duty.”");
		    System.out.println("With a steady breath, the knight sinks the blade into his own heart.");
		    System.out.println("The Knight died.");
		    npc.setExist(false);FightingGame.main2(user, npc);}
		else if (friend) {
			System.out.println("“Please… don’t ask me to be strong anymore.”");
		    System.out.println("“If you walk, I follow. Not because you won... but because you stopped hurting me.”");
		    System.out.println("Congradulations! The Knight becomes your team. Now continue your aventure!");
		    npc.setExist(true);FightingGame.main2(user, npc);}
		else if (fightAgain) {
			System.out.println("The knight goes still — too still — as if fury has drained every breath from his body.");
		    System.out.println("When he finally speaks, the words scrape out like iron dragged across stone.");
		    System.out.println("“Fine. If the world wants a monster — I WILL GIVE THEM ONE.”");
		    System.out.println("“You want strength? Then die by it.”");
		    FightingGame.main1(user,npc);}
	}
	
	public static void introduction() {
		System.out.println("Hey… look alive, adventurer.");
		System.out.println("You’re not here by mistake — you made it all the way to the fortress gates.");
		System.out.println("Everyone else turned back long before this point. Can’t say I blame them.");
		System.out.println("Listen, before you walk in there, I want you to know how this works.");
		System.out.println("");
		System.out.println("Your HP — that’s your life. Drop it to zero and there’s no getting back up.");
		System.out.println("Your MP — that’s your energy for pulling off the fancy stuff.");
		System.out.println("And your Power... that’s the spark that grows when you fight hard. If it hits 100, you’ll unlock something big. You’ll know when it happens.");
		System.out.println("");
		System.out.println("You’ve got three basic moves: punch, kick, slash.");
		System.out.println("Use just one? You’ll strike normally.");
		System.out.println("Put two or three in the same line — and the hit lands harder.");
		System.out.println("Don’t worry about uppercase or lowercase. Just type what you mean.");
		System.out.println("But be clear — this world listens to your words literally.");
		System.out.println("");
		System.out.println("Oh, see the Knight waiting in there? People love calling him a monster.");
		System.out.println("When you feel ready, take a breath... and type your first action to start the fight.");
		System.out.println("The Knight glances at you.");
		System.out.println("“Another fool? Fine, ready for a fight.”");
		System.out.println("");
	}
	
	public static void preOfCamp(GameTime time,Player user,Knight npc) {
		Check.checkTime(time, npc);
		System.out.println("The sun has nearly disappeared beyond the horizon, and darkness is slowly settling over the forest.");
		System.out.println("After a long day of traveling, you realize it's getting too late to continue your journey.");
		System.out.println("");
		System.out.println("After searching for a while, you come across a small clearing surrounded by tall trees.");
		System.out.println("The ground is flat and dry, making it a suitable place to set up camp.");
		System.out.println("Before long, a small campfire flickers to life, casting a warm glow across the clearing.");
		System.out.println("");
		System.out.println("The camp is ready. For now, your journey can wait.");
		camp(time,user,npc);
	}
	
	public static void camp(GameTime time,Player user,NPC npc) {
		System.out.println("-----"+time.getTime()+"-----");
		String npcAction="";
		if(npc.getExist()==true) {
			npcAction=EventSystem.randomEvent(npc);
			System.out.println(npc.getName()+" is "+npcAction);
			campChoicesNPC(time,user,npc,npcAction);
		}else {campChoicesAlone(time,user,npc,npcAction);}
	}
	
	public static void campChoicesNPC(GameTime time,Player user,NPC npc,String npcAction) {
		System.out.println("1.interact  2.observe 3.wait 4.leave");
		System.out.print("You choose to: ");
		Scanner input=new Scanner(System.in);
		String userInput=input.nextLine();
		switch(userInput) {
		case "1":
			System.out.print("Input Text: ");
		    userInput=input.nextLine();
		    try {
	            AIService.chat(time,user,npc,npcAction,userInput);
	        } catch (Exception e) {
	        	System.out.println("AI connection failed.");
		}
		    break;
		case "2":
			System.out.print("You stand there, observing him.");
			userInput="*I stand there, observing him.*";
			try {
	            AIService.chat(time,user,npc,npcAction,userInput);
	        } catch (Exception e) {
	        	System.out.println("AI connection failed.");
		}
			break;
		case "3":
			System.out.print("You wait there.");
			userInput="*I wait there.*";
			try {
	            AIService.chat(time,user,npc,npcAction,userInput);
	        } catch (Exception e) {
	        	System.out.println("AI connection failed.");
		}
			break;
		case "4":
			campChoicesAlone(time,user,npc,npcAction);
			break;
		}
	}
	
	public static void campChoicesAlone(GameTime time,Player user,NPC npc,String npcAction) {
		int option;
		System.out.println("1.go to check the others");
		System.out.println("2.rest and sleep");
		System.out.println("3.leave the camp and get back to advanture");
		System.out.print("You choose to: ");
		Scanner input=new Scanner(System.in);
		int choose=input.nextInt();
		switch(choose) {
		case 1:
			System.out.println("1.You have changed your mind");
			if(npc.getExist()==true) System.out.println("2.Knight");
			System.out.print("You want to check: ");
			option=input.nextInt();
			if(option==1)campChoicesAlone(time,user,npc,npcAction);
			else if(option==2) 
			{System.out.println(npc.getName()+" is "+npcAction);
			campChoicesNPC(time,user,npc,npcAction);}
			break;
		case 2:
			user.reset("YOU",100, 100, 0,0);
			if(npc.getExist()==true) {
				npc.reset("Knight",80, 80, 0,0);
				npc.loseFatigueMax();}
			System.out.println("You and your companion wake up feeling refreshed and ready for the journey ahead.");
			System.out.println("Your HP and MP have been fully restored!");
			time.setTime(0);
			Check.checkTime(time,npc);
			camp(time,user,npc);
			break;
		case 3:
			System.out.println("You leave the camp.");
			System.exit(0);
			break;
		}
	}
	
}

