package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.InputField;
import gui.PopUpAnswerFrame;
import gui.PopUpChoiseFrame;

/**
 * La classe principale del programma
 *
 * <p>Classe di tipo Control
 *
 * <p>La classe di controllo principale del programma: assegna le priorità e gestisce il flusso di esecuzione
 * 
 * @author Nico Visci
 */

public class AppMain {

	/* Soluzione = 24968
	 * Nella combinazione sono presenti 3 divisori del numero 18
	 * La somma del primo e dell'ultimo numero è uguale alla somma del secondo e del quarto numero
	 * L'ultimo numero della combinazione è 8
	 * Il terzo e il quarto numero hanno un divisore in comune
	 * Il secondo numero è esattamente la metà del quinto numero
	 * 
	 * Il primo numero è esattamente la metà del secondo numero
	 * Il primo numero della combinazione è 2
	 * Il quarto numero della combinazione è i 2/3 del terzo numero
	 * La somma del primo e del secondo numero è pari al quarto numero
	 * Il numero centrale della combinazione è un quadrato perfetto
	 */
	
	private static GameEntity game = null;
	
	private static String comando = null;
	
	private static boolean playerNameToken = false, newPlayToken = true, loadToken = false;
	
	private static String nomeFile = "SalvataggioTheHeist";
	
	private static InputControlFlowComponent nextInTheChain = CoreInputControl.getInstance();
	
	private AppMain() {
    // not called
  	}

	public static void main(final String[] args) {
		  
		  UserInterface.titleScreenBuilder();

  	}
	
	public static boolean getNewPlayToken() {
		return newPlayToken;
	}
	
	public static void setNewPlayToken(boolean newValue) {
		newPlayToken = newValue;
	}
	
	public static GameEntity getGame() {
		return game;
	}

	public static void setGame(GameEntity game) {
		AppMain.game = game;
	}
	
	public static void newGame() {
		AppMain.game = new GameEntity();
	}
	
	public static String getComando() {
		return comando;
	}
	
	public static void setComando(String newComando) {
		AppMain.comando = newComando;
	}
	
	public static void appOpening() {
		System.out.println("Ciao, e benvenuto a The Heist\n"
						 + "Usa il pannello delle Opzioni qui accanto per iniziare una nuova partita "
						 + "oppure per caricarne una.");
	}
	
	public static void appPlayMode() {
		if(!newPlayToken) {
			PopUpChoiseFrame popUpChoise = new PopUpChoiseFrame("Vuoi iniziare una nuova partita?");
			
			popUpChoise.getFirstButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AppMain.setNewPlayToken(true);
					AppMain.newPlayMode();
					popUpChoise.closeFrame();
				}
			});
			
			popUpChoise.getSecondButton().addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					AppMain.setNewPlayToken(false);
					popUpChoise.closeFrame();
				}
				
			});
			popUpChoise.setVisible(true);
			
			popUpChoise.getButtonPanel().addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						AppMain.setNewPlayToken(true);
						AppMain.newPlayMode();
						popUpChoise.closeFrame();
					}
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
			});
		}
		else {
			newPlayMode();
		}
	}
		
	public static void newPlayMode() {
		if(newPlayToken) {
			System.out.println("\n\nNUOVA PARTITA DI THE HEIST\n"
					         + "\nPrima di tutto ti consiglio di visualizzare il tutorial\n\n");
			
			game = new GameEntity();
			game.getScenario().playerStarting();
			
			newPlayToken = false;
			
			System.out.println("Ciao, mi presento: sono il tuo assistente\n"
							 + "Inserisci il tuo nome nel box qui apparso");
			
			PopUpAnswerFrame popUpAnswer = new PopUpAnswerFrame("Inserisci nome");
			
			popUpAnswer.setFocusable(true);
			
			popUpAnswer.getButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					AppMain.setComando(popUpAnswer.popUpReturn());
					AppMain.checkModeOpening(comando);
					popUpAnswer.closeFrame();
					
				}
			});
			
			popUpAnswer.getField().addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						AppMain.setComando(popUpAnswer.popUpReturn());
						AppMain.checkModeOpening(comando);
						popUpAnswer.closeFrame();
					}
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
			});
			playerNameToken = true;
			popUpAnswer.setVisible(true);
			
		}
	}
	
	
	public static void checkModeOpening(String comando) {
		if(playerNameToken) {
			game.getPlayer().setPlayerName(comando);
			playerNameToken = false;
			System.out.println("\nQuindi ti chiami " + game.getPlayer().getPlayerName() + ", piacere di conoscerti!\n");
			getGame().getScenario().introScenario();
			System.out.println("\nTi trovi in " + AppMain.currentAmbiente());
			InputField.setFocus(true);

		}
		else {
			comando = comando.toLowerCase();
			comando = comando.trim();
			nextInTheChain.decodifica(comando);
		}
		
	}

	
	/* Logica per il controllo del salvataggio partita e del caricamento partita
	 * */
	public static void salvaPartita() {
		try {
			SavingControl.salvaPartita(nomeFile , getGame().getPlayer());
		}
		catch (NullPointerException e) {
			SavingControl.saveErrorPrint();
		}
	}
	
	public static void caricaPartita() {
		try {
			SavingControl.caricaPartita(nomeFile);
			setNewPlayToken(false);
			InputField.setFocus(true);
		}
		catch (NullPointerException e) {
			SavingControl.loadErrorPrint();
			e.printStackTrace();
		}
	}

	public static boolean getLoadToken() {
		return loadToken;
	}

	public static void setLoadToken(boolean loadToken) {
		AppMain.loadToken = loadToken;
	}
	
	public static String currentAmbiente() {
		return game.getScenario().scenario[game.getPlayer().getX()][game.getPlayer().getY()][game.getPlayer().getZ()].nomeAmbiente;
	}
	
	

	
	


 
}