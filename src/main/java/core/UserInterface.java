package core;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import gui.AppConsole;
import gui.InputField;
import gui.OptionsPanel;
import gui.TitleScreen;

/**
 * La classe che gestisce l'interfaccia utente del programma
 *
 * <p>Classe di tipo Control
 *
 * <p>Questa classe ha l'accesso alla finestra dell'applicazione e si occupa di eseguire sullo schermo i metodi che hanno il controllo.
 * Costruisce la finestra dell'applicazione con le classi entità del package Gui a cui si appoggia
 *
 * <p><b>DO NOT RENAME</b>
 */

public class UserInterface {
	
	private static JFrame appFrame;
	
	private UserInterface() {
		//Not called
	}
	
	public static JFrame getAppFrame() {
		return appFrame;
	}
	
	public static void openAppFrame() {
		appFrame = new JFrame("The Heist");
		appFrame.setBounds(325, 10, 850, 800);
		appFrame.setBackground(Color.black);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void closeAppFrame() {
		appFrame = null;
	}

	public static void titleScreenBuilder()	{
		
		openAppFrame();
		
		appFrame.add(TitleScreen.getTitleScreen(), BorderLayout.CENTER);
		
		appFrame.setVisible(true);
		
	}      
	
	public static void appScreenBuilder() {
		
		appFrame.setVisible(false);
		
		closeAppFrame();
		openAppFrame();
		
		appFrame.add(OptionsPanel.getInstance(), BorderLayout.EAST);
		appFrame.add(InputField.getInstance(), BorderLayout.SOUTH);
		appFrame.add(new JScrollPane(AppConsole.getInstance()), BorderLayout.CENTER);
		
		appFrame.setVisible(true);
		
		AppMain.appOpening();
		
	}
	 
    
	
}