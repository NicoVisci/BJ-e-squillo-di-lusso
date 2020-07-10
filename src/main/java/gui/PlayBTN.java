package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.AppMain;

/**
 * Classe che rappresenta il bottone di avvio di una nuova partita
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il bottone di avvio di una nuova partita, richiamato dal builder della schermata di partita.
 * Quando cliccato, il bottone notificherà l'evento alla classe AppMain.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
class PlayBTN extends JButton {
	
	
	private static PlayBTN playButton = null;

	
	private PlayBTN() {
		
		this.setFont(OptionsPanel.italicFont);
		
		String playLabel = "<html>"+"Nuova"+"<br>"+"Partita"+"</html>";
		this.setText(playLabel);
		this.setFocusable(true);
		this.setToolTipText("Clicca per iniziare una nuova partita");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AppMain.appPlayMode();
			}
		});
	}
	
	public static PlayBTN getInstance() {
		if(playButton == null) {
			playButton = new PlayBTN();
		}
		
		return playButton;
	}

}
