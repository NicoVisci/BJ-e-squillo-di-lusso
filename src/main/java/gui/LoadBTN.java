package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.AppMain;

/**
 * Classe che rappresenta il bottone del caricamento della partita salvata
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il bottone del caricamento della partita salvata, richiamato dal builder della schermata di partita.
 * Quando cliccato, il bottone notificherà l'evento alla classe AppMain.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
class LoadBTN extends JButton {
	
	
	static private LoadBTN loadButton = new LoadBTN();

	
	private LoadBTN() {
		
		this.setFont(OptionsPanel.italicFont);
		
		String playLabel = "<html>"+"Carica"+"<br>"+"Partita"+"</html>";
		this.setText(playLabel);
		this.setFocusable(true);
		this.setToolTipText("Clicca per caricare una partita salvata");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AppMain.setLoadToken(true);
				AppMain.caricaPartita();
			}
		});
		
	}
	
	public static LoadBTN getInstance() {
		if(loadButton == null) {
			loadButton = new LoadBTN();
		}
		
		return loadButton;
	}

}
