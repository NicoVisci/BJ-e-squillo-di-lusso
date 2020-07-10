package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Classe che rappresenta il bottone del vocabolario
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il bottone del vocabolario, richiamato dal builder della schermata di partita.
 * Quando cliccato, il bottone stamperà sulla console attiva il vocabolario delle parole permesse con le istruzioni per scrivere correttamente i comandi.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
class VocbBTN extends JButton {

	
	static private VocbBTN vocabularyButton = null;
	
	
	private VocbBTN() {

		this.setFont(OptionsPanel.italicFont);
		
		String playLabel = "<html>"+"Dizionario"+"</html>";
		this.setText(playLabel);
		this.setFocusable(true);
		this.setToolTipText("Clicca per visualizzare il vocabolario delle parole possibili");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vocabularyPrint();
				
			}
		});
	}
	
	public static VocbBTN getInstance() {
		if(vocabularyButton == null) {
			vocabularyButton = new VocbBTN();
		}
		return vocabularyButton;
	}
	
	private static void vocabularyPrint() {
		System.out.println("\nVOCABOLARIO\n\nPer costruire le tue frasi potrai usare le seguenti parole chiave:\n"
						 + "ESAMINA oppure ANALIZZA oppure GUARDA con a seguire il nome dell'oggetto interessato per analizzarlo a fondo\n"
						 + "\nUsando la parola chiave senza un riferimento ad un oggetto, si analizzerà direttamente la stanza. Per esempio:\n"
						 + "\"Guarda\" ne corrisponderà una descrizione della stanza dove ci si trova\n\n"
						 + "Nel caso in cui un oggetto abbia un riferimento alla soluzione del caso, un indizio verrà aggiunto alla Sua lista "
						 + "dopo essere stato analizzato\n\n"
						 + "Può visualizzare la lista degli indizi in suo possesso digitando le parole chiave INDIZI o LISTA INDIZI\n"
						 + "mentre per visualizzare l'inventario degli oggetti in suo possesso basterà usare la parola chiave INVENTARIO\n\n"
						 + "Per spostarsi da una stanza ad un'altra, bisognerà indicare la direzione con i punti cardinali NORD o SUD o EST o OVEST\n"
						 + "preceduti o meno dalla parola vai.\n"
						 + "(I comandi \"Vai nord\"  \"Vai a nord\"  \"Nord\" sono indifferenti e producono tutti e 3 l'effetto di andare a nord.)\n"
						 + "Bada bene: non tutte le stanze hanno tutte le direzioni percorribili, perciò alcune volte ad un comando di spostamento "
						 + "può corrispondere una risposta di mancato spostamento.\n\n"
						 + "Puoi usare la parola chiave PRENDI per aggiungere un oggetto al tuo inventario, prendendolo dalla stanza dove l'oggetto si trova\n"
						 + "Consiglio: prova ad usare la parola PRENDI + (NOME OGGETTO) su tutti gli oggetti che ti sembreranno interessanti\n"
						 + "Mentre puoi usare la parola chiave COMBINA seguita da 2 nomi di oggetti per combinarli: se i due oggetti si trovano nel tuo inventario "
						 + "e sono combinabili, verranno sostituiti nel tuo inventario dal nuovo oggetto combinato\n\n"
						 + "Puoi usare combinazioni particolari in determinate situazioni, per esempio \"DISATTIVA TELECAMERE\" o \"SVEGLIA\" per"
						 + "attivare interazioni speciali nella stanza in cui ti trovi\n\n");
	}
}
