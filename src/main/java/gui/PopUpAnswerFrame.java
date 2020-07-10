package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Classe che rappresenta la finestra popup per l'inserimento di un testo
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe rappresenta la finestra popup con un campo di testo per l'inserimento e un bottone per notificare la fine dell'inserimento.
 * Può essere istanziata da chiunque.
 * 
 * @param title Il titolo della finestra che dovrebbe indicare lo scopo della stessa
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class PopUpAnswerFrame extends JFrame {

	private JTextField field = null;
	private JButton button = null;
	
	public PopUpAnswerFrame(String title) {
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension screenSize = new Dimension(300, 150);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setSize(screenSize);
		this.setPreferredSize(screenSize);
		
		this.getContentPane().setLayout(new GridLayout(2, 1, 10, 10));
		this.setBackground(Color.CYAN);
		
		field = new JTextField();
		Dimension fieldDim = new Dimension(30, 5);
		field.setMinimumSize(fieldDim);
		field.setPreferredSize(fieldDim);
		field.setMaximumSize(fieldDim);
		field.setFont(new Font(title, NORMAL, 20));
		field.setBorder(new LineBorder(Color.black));
		field.setEnabled(true);
		field.setVisible(true);
		
		button = new JButton("Conferma");
		
		this.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        field.requestFocusInWindow();
		    }
		});
		
		this.add(field);
		this.add(button);
		
	}
	
	public String popUpReturn() {
		return field.getText();
	}
	
	public void closeFrame() {
		this.dispose();
	}
	
	public JTextField getField() {
		return this.field;
	}
	
	public JButton getButton() {
		return this.button;
	}
}
