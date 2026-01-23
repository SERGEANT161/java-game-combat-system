package Hey;
import java.util.Scanner;
import java.util.Random;
public class FightingSystem {

	
	public static void fightingAction1(Player user,Player npc){
		
			
			Scanner input=new Scanner(System.in);
			System.out.print("Enter your action: ");
			String action1=input.nextLine();
			boolean okay=Check.checkMP1(user,npc,action1);
			if (okay)Check.checkAction1(user,npc,action1);
			else return;
			Check.checkHP1(user,npc);
			Check.checkPower(user,npc);
			Check.checkHP1(user,npc);
			System.out.println("");
			System.out.println("Now the Knight's HP is "+npc.HP+". MP is "+npc.MP+". Power is "+npc.Power+".");
			return;
			 
			
			
		
	}
	
	public static void fightingAction2(Player user,Player npc) {
		Check.checkWord(npc);
		Random rand=new Random();
		String action2="";
		int num1=rand.nextInt(3)+1;//(max-min+1)+min
		for(int num2=1;num2<=num1;num2++) {
			int num3=rand.nextInt(3);
			String action3=npc.action1[num3];
			action2+=action3;
		}
		boolean okay=Check.checkMP2(user,npc,action2);
		if (okay)Check.checkAction2(user,npc,action2);
		else return;
		Check.checkHP1(user,npc);
		Check.checkPower(user,npc);
		Check.checkHP1(user,npc);
		System.out.println("");
		System.out.println("Now Your HP is "+user.HP+". MP is "+user.MP+". Power is "+user.Power+".");
		
		
	}
	
	
	public static void fightingAction3(Player user,Player npc) {
		Random rand=new Random();
		int num4=rand.nextInt(npc.word5.length-1);
		System.out.println(npc.word5[num4]);
		String action2="";
		int num1=rand.nextInt(3)+1;//(max-min+1)+min
		for(int num2=1;num2<=num1;num2++) {
			int num3=rand.nextInt(3);
			String action3=npc.action2[num3];
			action2+=action3;
		}
		boolean okay=Check.checkMP3(user,npc,action2);
		if (okay)Check.checkAction3(user,npc,action2);
		else return;
		Check.checkHP2(user,npc);
		Check.checkPower(user,npc);
		Check.checkHP2(user,npc);
		System.out.println("");
		System.out.println("Now Your HP is "+user.HP+". MP is "+user.MP+". Power is "+user.Power+".");
		
		
	}
	
	
	public static void fightingAction4(Player user,Player npc){
		
		
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your action: ");
		String action1=input.nextLine();
		boolean okay=Check.checkMP4(user,npc,action1);
		if (okay)Check.checkAction1(user,npc,action1);
		else return;
		Check.checkHP2(user,npc);
		Check.checkPower(user,npc);
		Check.checkHP2(user,npc);
		System.out.println("");
		System.out.println("Now the Knight's HP is "+npc.HP+". MP is "+npc.MP+". Power is "+npc.Power+".");
		return;
		 
		
		
	
}
	
	
}
