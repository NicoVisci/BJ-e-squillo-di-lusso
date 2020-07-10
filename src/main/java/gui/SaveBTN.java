package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.AppMain;

/**
 * Classe che rappresenta il bottone del salvataggio della partita in corso
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il bottone del salvataggio della partita in corso, richiamato dal builder della schermata di partita.
 * Quando cliccato, il bottone notificherà l'evento alla classe AppMain.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
class SaveBTN extends JButton {
	
	
	static private SaveBTN saveButton = null;

	
	private SaveBTN() {
		
		this.setFont(OptionsPanel.italicFont);
		
		String playLabel = "<html>"+"Salva"+"<br>"+"Partita"+"</html>";
		this.setText(playLabel);
		this.setFocusable(true);
		this.setToolTipText("Clicca per salvare la partita in corso");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AppMain.salvaPartita();
			}
		});
		
	}
	
	public static SaveBTN getInstance() {
		if(saveButton == null) {
			saveButton = new SaveBTN();
		}
		
		return saveButton;
	}

	
}
