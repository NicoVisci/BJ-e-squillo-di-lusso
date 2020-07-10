package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/**
 * Classe che gestisce il controllo del salvataggio di partita e del caricamento della partita salvata
 * 
 * <p>Classe di tipo Control	 
 * 
 * <p>Questa classe gestisce il controllo del salvataggio dello stato di partita corrente e del caricamento sull'applicazione di una partita
 *  precedentemente salvata. La classe non viene istanziata ed i metodi devono essere invocati in maniera statica.
 * 
 * @author Nico Visci
*/
public class SavingControl {

	private static File fileSav = null;
	
	private static ObjectOutputStream outStream = null;
	
	private static ObjectInputStream inStream = null;
	
	private static String dir = "Salvataggi The Heist";
	
	private static Player bufferPlayer = null;
	
	private static StatusScenario bufferScenario = null;
	
	
	
	private SavingControl() {
		//Not called
	}
	
	public static void saveErrorPrint() {
		JOptionPane.showMessageDialog(null, "Non è stato possibile salvare la partita!");
	}
	
	public static void saveSuccessPrint() {
		JOptionPane.showMessageDialog(null, "Partita salvata con successo!");
	}
	
	public static void loadErrorPrint() {
		JOptionPane.showMessageDialog(null, "Non è stato possibile caricare la partita salvata!");
	}
	
	protected static void setSaveDir(String path) {
		dir = path;
	}
	
	/*
	 * Metodo scritto in maniera generica, così da poter essere usato per ogni tipo di scenario compatibile
	 */
	public static synchronized void salvaPartita (String nomeFile, Player player)  {
		
		File f = new File("\\"+dir);
		f.mkdirs();
		fileSav = new File(f, nomeFile);
		
		//if(fileSav.exists() && fileSav.delete()) {
			try {
				//fileSav = new File(f, nomeFile);
				
				outStream = new ObjectOutputStream(new FileOutputStream(fileSav));
				
				StatusScenario status = new StatusScenario();
				
				outStream.writeObject(player);
				outStream.writeObject(status);
				
				outStream.close();
				
				saveSuccessPrint();
				
			}
			catch (IOException e) {
				SavingControl.saveErrorPrint();
				e.printStackTrace();
			}
		}
		/*else {
			SavingControl.saveErrorPrint();
		}
	}*/
	public static void caricaPartita(String nomeFile) {
		
		File f = new File("\\"+dir);
		f.mkdirs();
		fileSav = new File(f, nomeFile);
		
		try {
			if(fileSav.exists()) {
				
				inStream = new ObjectInputStream(new FileInputStream(fileSav));
				
				bufferPlayer = (Player) inStream.readObject();
				bufferScenario = (StatusScenario) inStream.readObject();
				
				inStream.close();
				
				AppMain.newGame();
				AppMain.getGame().setPlayer(bufferPlayer);
				//AppMain.getGame().newScenario();
				bufferScenario.setStatus();
				
				System.out.println("\nPartita caricata con successo!");
				System.out.println("\nTi trovi in " + AppMain.currentAmbiente());
				
			}
			else {
				loadErrorPrint();
			}
		}
		catch (ClassNotFoundException | IOException es) {
			SavingControl.loadErrorPrint();
			es.printStackTrace();
		}
	}
}
