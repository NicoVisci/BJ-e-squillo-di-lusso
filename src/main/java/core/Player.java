package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe che rappresenta il profilo di un giocatore con le sue caratteristiche
 * 
 * <p>Classe di tipo Entity	 
 * 
 * <p>Questa classe descrive un giocatore dell'applicazione con le sue caratteristiche peculiari, fornendo un accesso sicuro alle stesse
 * 
 * @author Nico Visci
*/

@SuppressWarnings("serial")
public class Player implements Serializable  {

	private int posizioneX;
	private int posizioneY;
	private int posizioneZ;
	
	private String playerName;
	private boolean controllato;
	//private int remainingAttempts;
	
	private ArrayList<String> listaIndizi = new ArrayList<String>();
	
	private ArrayList<String> inventario = new ArrayList<String>();
	
	public Player() {
		this.setControllato(false);
	}
	
	public int getX()	{
		return this.posizioneX;
	}
	
	public void setX(int newValue)	{
		this.posizioneX=newValue;
	}
	
	public int getY()	{
		return this.posizioneY;
	}

	public void setY(int newValue)	{
		this.posizioneY=newValue;
	}
	
	public int getZ()	{
		return this.posizioneZ;
	}
	
	public void setZ(int newValue)	{
		this.posizioneZ=newValue;
	}
	
	public void setCoords(int newX, int newY, int newZ) {
		this.posizioneX = newX;
		this.posizioneY = newY;
		this.posizioneZ = newZ;
	}
	
	public String getPlayerName()	{
		return this.playerName;
	}
	
	public void setPlayerName(String newName)	{
		this.playerName = new String(newName);
	}

	public boolean isControllato() {
		return controllato;
	}

	public void setControllato(boolean controllato) {
		this.controllato = controllato;
	}
	/*
	public int getRemainingAttempts() {
		return remainingAttempts;
	}

	public void setRemainingAttempts(int remainingAttempts) {
		this.remainingAttempts = remainingAttempts;
	}
	*/
	public void addIndizio(String indizio) {
		this.listaIndizi.add(indizio);
	}
	
	public void removeIndizio(String indizio) {
		this.listaIndizi.remove(indizio);
	}
	
	public ArrayList<String> getListaIndizi() {
		return this.listaIndizi;
	}
	
	public void addOggetto(String oggetto) {
		this.inventario.add(oggetto);
	}
	
	public void removeOggetto(String oggetto) {
		this.inventario.remove(oggetto);
	}
	
	public ArrayList<String> getInventario() {
		return this.inventario;
	}
	
	public void printListaIndizi() {
		System.out.println("\nGli indizi che hai raccolto:\n");
		for (String indizi : this.listaIndizi) {
			System.out.println("->  "+indizi);
		}
	}
	
	public void printInventario() {
		System.out.println("\nIl tuo inventario:\n");
		for (String oggetto : this.inventario) {
			System.out.println("->  "+oggetto);
		}
	}

}
