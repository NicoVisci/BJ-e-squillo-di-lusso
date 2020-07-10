package core;

import java.util.Scanner;
import java.util.TimerTask;

import java.util.Timer;

/**
 * Classe che racchiude le utilities per il controllo e l'input/output dell'applicazione
 * 
 * <p>Classe di tipo Control	 
 * 
 * <p>Questa classe che racchiude le utilities per il controllo e l'input/output dell'applicazione. 
 * La classe non viene istanziata e i metodi devono essere invocati in modo statico
 * 
 * @author Nico Visci
*/

//Non utilizzata nella current release
public final class AppUtil {
	
	private AppUtil() {
		//not called
	}
	
	public static String userInput() {

	    Scanner input = new Scanner(System.in, "UTF-8");

	    System.out.print("\n  >\t");
	    String answer = input.next();	    
	    return answer;
	}
	
	
	public static String timedUserInput(Timer timer, final int millis) {

	    Scanner input = new Scanner(System.in, "UTF-8");
		
	    writeIn(timer, millis, "\n  >\t");
	    String answer = input.next();
	    
	    return answer;
	}
	
	
	public static void writeIn(Timer timer, final int millis, final String text){
	    TimerTask task = new TimerTask() {
	        @Override
	        public void run() {
	            System.out.println(text);
	        }
	    };
	    timer.schedule(task, millis);
	}

	public static void closeTimerIn(final Timer timer, final int millis){
	    TimerTask task = new TimerTask() {
	        @Override
	        public void run() {
	            timer.cancel();
	        }
	    };
	    timer.schedule(task, millis);
	}

}
