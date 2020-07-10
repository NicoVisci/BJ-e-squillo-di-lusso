package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Classe che rappresenta il bottone del tutorial
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta il bottone del tutorial, richiamato dal builder della schermata di partita.
 * Quando cliccato, il bottone stamperà sulla console attiva il tutorial per l'utente.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
class TutrBTN extends JButton {

	static private TutrBTN tutorialButton = null;
	
	
	private TutrBTN() {

		this.setFont(OptionsPanel.italicFont);
		
		String playLabel = "<html>"+"Tutorial"+ "</html>";
		this.setText(playLabel);
		this.setFocusable(true);
		this.setToolTipText("Clicca per visualizzare il tutorial");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tutorialPrint();
			}
		});
	}
	
	static public TutrBTN getInstance() {
		if(tutorialButton == null) {
			tutorialButton = new TutrBTN();
		}
		return tutorialButton;
	}
	
	private static void tutorialPrint() {
		System.out.println("\nTUTORIAL\n"
				 		 + "Le avventure testuali sono programmi per computer che simulano un ambiente nel quale"
						 + " i giocatori usano comandi testuali per istruire il personaggio della storia a interagire con l'ambiente "
						 + "in cui si trova.\n Come giocatore, per controllare il gioco dovrai inserire le tue risposte (O comandi)"
						 + "nell'area sottostante chiamata Area di Risposta, mentre la situazione di gioco ti verrà descritta qui "
						 + "nell'Area di Dialogo. Ogni situazione di gioco è rappresentata da una stanza che potrai esplorare tramite comandi, "
						 + "oppure potrai spostarti in altre stanze sempre tramite comandi"
						 + "\nI comandi che potrai scrivere sono sotto forma di semplici frasi telegrafiche "
						 + "all'imperativo, del tipo \"prendi chiave\" o \"vai est\" oppure \"Guarda stanza\" o \"Guarda lavagna\"."
						 + "\n\nUna tipica risposta al comando \"tira leva\" "
						 + "potrebbe essere:\n" 
						 + "\n"
						 + "Tiri la leva. La porta si apre, e vieni abbagliato dalla vista di uno splendente scrigno del tesoro."
						 + "\n\nOppure al comando \" vai nord\":\n"
						 + "\nSei entrato nella Sala della Musica\n"
						 + "Potrai anche combinare 2 oggetti trovati sul campo grazie alla parola chiave \"Combina\" e poi elenchi i due oggetti."
						 + "Per esempio:\n\nCombina pezzo di torta veleno per topi\nHai combinato con successo questi oggetti e hai ottenuto "
						 + "Torta avvelenata\n"
						 + "\nClicca sul bottone \"Dizionario\" qui accanto per visualizzare la lista di parole con cui potrai costruire "
						 + "i tuoi comandi.\n"
						 + "\nDevi anche prestare attenzione alle telecamere all'interno della villa: se entri in una stanza controllata e non vai via "
						 + "subito la missione fallirà\n"
						 + "Il consiglio primario è di usare sempre la parola GUARDA per guardare la stanza in cui si trova e leggerne la descrizione\n"
						 + "\nAlle volte, il gioco stesso ti farà capire che hai terminato le opzioni di interazione nella stanza e che quindi "
						 + "non ci sarà più \"Nulla di interessante da guardare\"\n");
	}
}
