package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Classe che rappresenta il contenitore dei bottoni delle opzioni dell'applicazione
 * 
 * <p>Classe di tipo Entity	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il contenitore dei bottoni delle opzioni, richiamato dal builder della schermata di partita.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {

	
	static Font font = new Font("Comic Sans", Font.PLAIN, 20);
	
	static Font italicFont = new Font("Comic Sans", Font.ITALIC, 25);
	
	private static OptionsPanel optionsPanel = null;
	
	
	
	private OptionsPanel() {
		
		//Costruzione della Box delle opzioni
		
		Dimension dim = new Dimension(150, 600);
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setBackground(Color.black);
		this.setForeground(Color.white);
		
		TitledBorder optionsPanelTitle = new TitledBorder("Opzioni");
		optionsPanelTitle.setTitleColor(Color.white);
		optionsPanelTitle.setTitleFont(font);
		this.setBorder(optionsPanelTitle);
		
		PlayBTN playBTN = PlayBTN.getInstance();
		SaveBTN saveBTN = SaveBTN.getInstance();
		LoadBTN loadBTN = LoadBTN.getInstance();
		TutrBTN vocbBTN = TutrBTN.getInstance();
		VocbBTN invtBTN = VocbBTN.getInstance();
		
		this.setLayout(new GridLayout(5, 1, 0, 0));
		
		this.add(playBTN);
		this.add(saveBTN);
		this.add(loadBTN);
		this.add(vocbBTN);
		this.add(invtBTN);
		
		this.setVisible(true);
	}
	
	
	static public synchronized OptionsPanel getInstance() {
		
		if (optionsPanel == null) {
			optionsPanel = new OptionsPanel();
		}
		return optionsPanel;
	}
}
