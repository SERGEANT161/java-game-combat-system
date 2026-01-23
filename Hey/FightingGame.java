package Hey;

import java.util.Scanner;

public class FightingGame {
	
	public static void main(String[] args) {
		Player user=new Player("YOU",100, 100, 0,0);
        Player npc=new Player("Knight",80, 80, 0,0);
		user.action1=new String[] {"punch","kick","slash"};
		npc.action1=new String[] {"heavy slash","bash","war cry"};
		npc.action2=new String[] {"iron spike thrust","trial blade","crushing arc"};
		npc.word1=new String[] {
				"“This is all you’ve got?”",
				"“I’ve taken worse hits training squires.”",
				"“You’re persistent. I’ll give you that.”",
				"“Pain reminds me I’m still standing.”",
				"“Keep going. Maybe you'll earn the right to kill me.”",
				"“I haven’t even started fighting seriously.”",
				"“Your resolve is louder than your strength.”",
				"“Don’t slow down now. You’ll disappoint me.”"};
		npc.word2=new String[] {
				"“Why do you fight this hard...? For glory? For guilt?”",
				"“You think I haven't bled for better reasons than yours?”",
				"“Don’t pretend you’re righteous. None of us are.”",
				"“You're not afraid to fall. I respect that.”",
				"“If you're here to kill me, stop hesitating.”",
				"“Every strike... reminds me what I’ve lost.”",
				"“You want a monster? You're shaping one.”",
				"“You're strong. But strength alone won't save you.”"};
        npc.word3=new String[] {
        		"“I won't die before I protect what's mine.”",
        		"“If the world wants me broken — they can break with me.”",
        		"“Do you enjoy this? Watching me fall?”",
        		"“You don’t understand what you’re destroying!”",
        		"“Heroes... killers... you’re all the same.”",
        		"“My body fails. My will doesn't.”",
        		"“Every cut you give me — I remember a face I couldn't save.”",
        		"“You want the truth? You're too late for it.”"};
        npc.word4=new String[] {
        		"“Even if I crawl... I stand between them and death.”",
        		"“You can break my bones — not the promise I made.”",
        		"“If I fall here... then you protect them. Swear it.”",
        		"“Kill me if you must — but don’t you dare forget why I fought.”",
        		"“I have nothing left except the reason I draw breath.”",
        		"“I bleed so they don’t. That’s my sin.”",
        		"“If strength is what you want — THEN DIE PROVING IT.”",
        		"“Finish it. Or I will.”"};
        npc.word5=new String[] {
        		"“If the world wants a beast — I’ll show them a BEAST.”",
        		"“Mercy is gone. So is restraint.”",
        		"“You opened this door. Walk through it.”",
        		"“I don’t care who you are anymore. I will break you.”",
        		"“My purpose died. Now only rage remains.”",
        		"“The only language left between us is pain.”",
        		"“I refuse peace. I refuse salvation. I refuse YOU.”",
        		"“You wanted a fight — then DROWN in it!”"};
        introduction();
		while(true) {
		FightingSystem.fightingAction1(user, npc);
		FightingSystem.fightingAction2(user, npc);
		}
	}

	public static void main1(Player user,Player npc) {
		System.out.println("");
		user.HP=100;npc.HP=80;
		user.MP=100;npc.MP=80;
		user.Power=0;npc.Power=0;
		user.TS=0;npc.TS=0;
		while(true) {
			FightingSystem.fightingAction4(user, npc);
			FightingSystem.fightingAction3(user, npc);
			}
	}
	
	public static void talk(Player user,Player npc) {
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
		    System.out.println("The Knight died.");System.exit(0);}
		else if (friend) {
			System.out.println("“Please… don’t ask me to be strong anymore.”");
		    System.out.println("“If you walk, I follow. Not because you won... but because you stopped hurting me.”");
		    System.out.println("Congradulations! The Knight becomes your team. Now continue your aventure!");System.exit(0);}
		else if (fightAgain) {
			System.out.println("The knight goes still — too still — as if fury has drained every breath from his body.");
		    System.out.println("When he finally speaks, the words scrape out like iron dragged across stone.");
		    System.out.println("“Fine. If the world wants a monster — I WILL GIVE THEM ONE.”");
		    System.out.println("“You want strength? Then die by it.”");}
		main1(user,npc);
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
}
