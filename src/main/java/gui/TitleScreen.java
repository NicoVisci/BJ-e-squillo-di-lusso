package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

import core.UserInterface;

/**
 * Classe che rappresenta lo schermo del titolo dell'applicazione
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta lo schermo del titolo, richiamato all'avvio dell'applicazione.
 * Lo schermo avrà il titolo stampato in forma di Ascii Art.
 * Quando rileva la pressione del tasto Enter, fornisce il controllo al builder della schermata di partita.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class TitleScreen extends JTextArea {
	
	static private TitleScreen titleScreen = null;

	private TitleScreen(String text) {
		
		super(text);
		
		Font font = new Font("Consolas", Font.PLAIN, 30);
		
		this.setBackground(Color.black);
		this.setEditable(false);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setFocusable(true);
		
		class enterListener implements KeyListener	{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					UserInterface.appScreenBuilder();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		this.addKeyListener( new enterListener());
		
	}
	
	static public TitleScreen getTitleScreen() {
	
		if(titleScreen == null) {
			titleScreen = new TitleScreen(getTitle());
		}
		return titleScreen;
	}
	
	private static String getTitle() {
    	return   "                                                  \n"
				+ "                                                  \n"
				+ "                                                  \n"
				+ "   _______  _            _    _      _     _   \n"
                + "  |__   __|| |          | |  | |    (_)   | |\n"
                + "     | |   | |___  ___  | |__| | ___ _ ___| |_\n"
                + "     | |   | '_  |/ _ | |  __  |/ _ | / __| __| \n" 
                + "     | |   | | | || __| | |  | || __/ |__ | |\n"
                + "     |_|   |_| |_||___| |_|  |_||___|_|___|__|\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "            Premi Invio per iniziare";
    }
}
