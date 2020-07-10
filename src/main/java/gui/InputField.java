package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import core.AppMain;

/**
 * Classe che rappresenta l'area di input dell'applicazione
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta l'area di input, richiamata dal builder della schermata di partita.
 * L'area rileverà qualsiasi messaggio scritto nel suo campo di testo e, alla pressione del tasto Enter, manderà il messaggio sotto forma di stringa
 * alla classe AppMain per processarlo, poi preparerà l'area per la ricezione di un nuovo messaggio. 
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class InputField extends JTextArea {
	
	static private InputField inputField = null;

	
	
	private InputField() {
		
		this.setEditable(false);
		
		Dimension dim = new Dimension(850, 200);
		this.setFont(AppConsole.font);
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		
		this.setBackground(Color.black);
		this.setForeground(Color.white);
		
		TitledBorder border = new TitledBorder("Area di Risposta");
		border.setTitleFont(AppConsole.font);
		border.setTitleColor(Color.white);
		this.setBorder(border);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					AppMain.setComando(InputField.getInstance().getText());
					AppConsole.getInstance().setFont(AppConsole.italicFont);
					System.out.println("\n>  "+(InputField.getInstance().getText().trim()) + "\n");
					AppConsole.getInstance().setVisible(false);
					AppConsole.getInstance().setFont(AppConsole.font);
					AppConsole.getInstance().setVisible(true);
					InputField.getInstance().setText("");
					AppMain.checkModeOpening(AppMain.getComando());
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
	}
	
	
	static public InputField getInstance() {
		if(inputField == null) {
			inputField  = new InputField();
		}
		return inputField;
	}
	
	/*
	 * Permette di cambiare lo stato dell'area di testo per renderla modificabile o no: nel caso sia resa modificabile, le fornisce 
	 * Sanche il focus dell'applicazione
	 */
	static public void setFocus(boolean value) {
		InputField.getInstance().setEditable(value);
		if (value) {
			InputField.getInstance().requestFocusInWindow();
		}
	}
}
