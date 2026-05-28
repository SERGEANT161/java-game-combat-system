package fightingGame21;
import java.util.*;

public class MoveEvaluator {
	public static String chooseKnightMove(Player user, Knight npc) {
        if (npc.getPhase() == 1) {
            return chooseMove1(user, npc);
        } else {
            return chooseMove2(user, npc);
        }

    }
	
    public static String chooseMove1(Player user, Knight npc) {
	  int heavySlash=10;
	  int bash=10;
	  int warCry=10;
	  int combo1=0;
	  int combo2=0;
	  if(npc.getHP()<=40) {
		  warCry+=30;
	  }
	  if(npc.getMP()<=30) {
		  if(user.getHP()<=50){
			  heavySlash+=30;
			  bash+=30;
		  }
	  }
	  if(npc.getMP()>=70) {
		 combo2+=15;
	  }
	  if(npc.getMP()>=50) {
		 combo1+=20;
	  }
	  DebugLog.write("[STATE] Player HP= "+user.getHP()+" MP= "+user.getMP()+" Power= "+user.getMP());
	  DebugLog.write("[STATE] Knight HP= "+npc.getHP()+" MP= "+npc.getMP()+" Power= "+npc.getMP());
	  DebugLog.write("[AI] Phase 1 move evaluation:");
      DebugLog.write("[AI] heavy slash = " + heavySlash);
      DebugLog.write("[AI] bash = " + bash);
      DebugLog.write("[AI] war cry = " + warCry);
      DebugLog.write("[AI] combo1 = " + combo1);
      DebugLog.write("[AI] combo2 = " + combo2);
	  String[] moves= {"heavy slash","bash","war cry","combo1","combo2"};
	  int[] odds= {heavySlash,bash,warCry,combo1,combo2};
	  String move=movePick(moves,odds,user,npc);
	  DebugLog.write("[AI] selected move = " + move);
	  return move;
  }
    public static String chooseMove2(Player user, Knight npc) {
  	  int ironSpikeThrust=10;
  	  int trialBlade=10;
  	  int crushingArc=10;
  	  int trialbladeCrushingarc=0;
  	  int combo1=0;
  	  int combo2=0;
  	  if(npc.getMP()<=30) {
  		  if(user.getHP()<=50){
  			ironSpikeThrust+=30;
  			trialBlade+=30;
  			crushingArc+=30;
  		  }
  	  }
  	  if(npc.getMP()>=70) {
  		 combo2+=15;
  	  }
  	  if(npc.getMP()>=50) {
  		 combo1+=20;
  		if(npc.getHP()<=40) {
  			trialbladeCrushingarc+=30;
  		  }
  	  }
	  DebugLog.write("[STATE] Player HP= "+user.getHP()+" MP= "+user.getMP()+" Power= "+user.getMP());
	  DebugLog.write("[STATE] Knight HP= "+npc.getHP()+" MP= "+npc.getMP()+" Power= "+npc.getMP());
  	  DebugLog.write("[AI] Phase 2 move evaluation:");
      DebugLog.write("[AI] iron spike thrust = " + ironSpikeThrust);
      DebugLog.write("[AI] trial blade = " + trialBlade);
      DebugLog.write("[AI] crushing arc = " + crushingArc);
      DebugLog.write("[AI] trial blade crushing arc = " + trialbladeCrushingarc);
      DebugLog.write("[AI] combo1 = " + combo1);
      DebugLog.write("[AI] combo2 = " + combo2);
  	  String[] moves= {"iron spike thrust","trial blade","crushing arc","trial blade crushing arc","combo1","combo2"};
  	  int[] odds= {ironSpikeThrust,trialBlade,crushingArc,trialbladeCrushingarc,combo1,combo2};
  	  String move=movePick(moves,odds,user,npc);
  	  DebugLog.write("[AI] selected move = " + move);
  	  return move;
    }
    
    
    private static String movePick(String[] moves, int[] odds,Player user, Knight npc) {
    	String move="";
    	int total=0;
    	for(int num1=0;num1<odds.length;num1++) {
    		total+=odds[num1];
    	}
    	 Random rand=new Random();
         int random=rand.nextInt(total);
         int current=0;
         int num1=0;
         while(num1< moves.length) {
             current+=odds[num1];
             if (random<current) {
                 move=moves[num1];
                 break;
             }
             num1++;
         }
         if(!move.equals("combo1")&&!move.equals("combo2")){
        	 if (move.equals("")) {
                 return moves[0];
             }
             return move;
         }else {
        	 if(move.equals("combo1")) {
        		 String combo1="";
        		 String[] action1;
        		 if(npc.getPhase()==1) {
        		 action1=new String[]{"heavy slash","bash","war cry"};}
        		 else {action1=new String[]{"iron spike thrust","trial blade","crushing arc"};}
        		 int num2=rand.nextInt(3)+1;//(max-min+1)+min
        		 String picked="";
        		 for(int num3=1;num3<=num2;num3++) {
        				int num4=rand.nextInt(3);
        				picked=action1[num4];
        				while (combo1.contains(picked)) {
        		            num4=rand.nextInt(3);
        		            picked=action1[num4];
        		        }
        				combo1+=picked+" ";
        			}
        		 return combo1;
        	 }
        	 else if(move.equals("combo2")){
        		 String combo2;
        		 if(npc.getPhase()==1) {
        		 combo2="heavy slash bash war cry";
        		 }else {combo2="iron spike thrust trial blade crushing arc";}
        		 return combo2;
        	 }else {return move;}
         }
         
    }
}
