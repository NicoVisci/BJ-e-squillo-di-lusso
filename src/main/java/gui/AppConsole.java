package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Classe che rappresenta la console di output dell'applicazione
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe è un Singleton che rappresenta la console di output, richiamata dal builder della schermata di partita.
 * La console mostrerà all'utente i system output, e i system error nel caso venisse stampato lo stack trace.
 * 
 * @param none
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class AppConsole extends JTextArea {

	
	
	private PrintStream printStream;
	
	private static AppConsole appConsole = null;
	
	static Font italicFont = new Font("Sanserif", Font.ITALIC, 20);
	
	static Font font = new Font("Comic Sans", Font.PLAIN, 20);
	
	
	
	private AppConsole() {
		
		printStream = new PrintStream (new ConsolePrintStream());
		
		//Costruzione della Console
		this.setEditable(false);
		
		System.setOut(this.getPrintStream());
		System.setErr(this.getPrintStream());

		this.setFont(font);
		this.setBackground(Color.black);
		this.setForeground(Color.white);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		
		TitledBorder border = new TitledBorder("Area di Dialogo");
		border.setTitleFont(font);
		border.setTitleColor(Color.white);
		this.setBorder(border);
	}
	
	
	public PrintStream getPrintStream() {
		return printStream;
	}
	
	static public AppConsole getInstance() {
		
		if (appConsole == null) {
			appConsole = new AppConsole();
		}
		return appConsole;
	}
	
	
	/*
	 * Inner class che ridefinisce il metodo write così che ogni flusso di byte che viene scritto sullo stream
	 * viene ridirezionato sulla JTextArea tramite il metodo append()
	 */
	private class ConsolePrintStream extends ByteArrayOutputStream {
		public synchronized void write(byte[] b, int off, int len)	{
			setCaretPosition(getDocument().getLength());
			String str = new String(b);
			append(str.substring(off, len));
		}
	}
	
	
}
