package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Classe che rappresenta la finestra popup per confermare o negare una scelta
 * 
 * <p>Classe di tipo Boundary	 
 * 
 * <p>Questa classe rappresenta la finestra popup per confermare o negare una scelta, con due bottoni che notificano l'avvenuta della scelta.
 * Può essere istanziata da chiunque.
 * 
 * @param title Il titolo della finestra che dovrebbe indicare lo scopo della stessa
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class PopUpChoiseFrame extends JFrame {
	
	private JTextField field = null;
	private JButton firstButton = null;
	private JButton secondButton = null;
	private JPanel panel = null;
	
	
	public JButton getFirstButton() {
		return firstButton;
	}
	
	public JButton getSecondButton() {
		return secondButton;
	}
	
	public JPanel getButtonPanel() {
		return panel;
	}
	
	public JTextField getField() {
		return field;
	}
	
	public PopUpChoiseFrame(String title) {
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension screenSize = new Dimension(300, 150);
		this.pack();
		this.setLocationRelativeTo(null);
		
		this.setSize(screenSize);
		this.setPreferredSize(screenSize);
		
		this.getContentPane().setLayout(new GridLayout(2, 1, 10, 10));
		this.setBackground(Color.CYAN);
		
		field = new JTextField(title);
		Dimension fieldDim = new Dimension(30, 5);
		field.setMinimumSize(fieldDim);
		field.setPreferredSize(fieldDim);
		field.setMaximumSize(fieldDim);
		field.setFont(new Font(title, NORMAL, 20));
		field.setBorder(new LineBorder(Color.black));
		field.setVisible(true);
		
		firstButton = new JButton("Accetta");
		firstButton.setVisible(true);
		
		secondButton = new JButton("Rifiuta");
		secondButton.setVisible(true);
		
		this.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        panel.requestFocusInWindow();
		    }
		});
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		this.add(field);
		panel.add(firstButton);
		panel.add(secondButton);
		this.add(panel);
	}
	
	public void closeFrame() {
		this.dispose();
	}
}
