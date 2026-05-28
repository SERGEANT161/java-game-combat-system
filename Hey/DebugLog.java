package fightingGame21;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DebugLog {
   private static final String FILE_PATH=("/Users/bluvel/eclipse-workspace/firstone/src/test.txt");
   private static boolean work=true;
   
   public static void setWork(boolean value) {
	   work=value;
   }
   
   public static void cleanLog() {
	    if (!work) return;
	    try{
	        PrintWriter output = new PrintWriter(new File(FILE_PATH));
	        output.close();
	    } catch (IOException e) {
	        System.out.println("Failed to clear debug log.");
	    }
   }
	    
   public static void write(String message) {
	   if (!work )return;
	   try {
		   PrintWriter output = new PrintWriter(new FileOutputStream(FILE_PATH, true));
		   output.println(message);
		   output.close();
	   }catch(IOException e){
		   System.out.println("Failed to write debug log.");
	   }
   
	}
}
