package core;

import java.io.Serializable;

/*
 * Classe astratta che definisce e restringe il tipo di oggetti che possono essere inseriti all'interno 
 * della struttura dati con cui è codificato lo scenario in questione, secondo il Principio di sostituzione di Liskov
 */
import java.util.ArrayList;

/**
 * Classe che definisce le linee guida per ogni tipo di ambiente che può essere inserito nello scenario di partita
 * 
 * <p>Classe di tipo Entity	 
 * 
 * <p>Questa classe contiene tutte le caratteristiche minime per ogni ambiente inserito nello scenario.
 * Ogni classe da inserire nello scenario come stanza o ambiente dovrà estendere questa.
 * 
 * @author Nico Visci
*/
@SuppressWarnings({ "serial" })
public abstract class Ambiente implements Stanza, Serializable {

	protected ArrayList<String> inventario = new ArrayList<String>(); 
	
	protected String indizio = null;
	protected String nomeAmbiente = null;
	
	protected int posizioneX;
	protected int posizioneY;
	protected int posizioneZ;
	
	protected boolean controllore = false;
	protected boolean indizioAcq = false;
	
	public ArrayList<String> getInventario() {
		return this.inventario;
	}
	
	public String getOggettoFromInventario(String nomeOggetto) {
		for (String string : inventario) {
			if(string.equals(nomeOggetto)) {
				return string;
			}
		}
		return null;
		//return this.inventario.get(pos);
	}
	
	public void addToInventario(String oggetto) {
		this.inventario.add(oggetto);
	}
	
	public void removeFromInventario(String oggetto) {
		this.inventario.remove(oggetto);
	}
	
	public String getIndizio() {
		return this.indizio;
	}
	
	public void setIndizio(String newIndizio) {
		this.indizio = newIndizio;
	}
	
	public String getNomeAmbiente() {
		return this.nomeAmbiente;
	}
	
	public void setNomeAmbiente(String newNomeAmbiente) {
		this.nomeAmbiente = newNomeAmbiente;
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
	
	public boolean getControllore() {
		return this.controllore;
	}
	
	public void setControllore(boolean newValue) {
		this.controllore = newValue;
	}
	
	public void acquireIndizio() {
		this.indizioAcq = true;
		AppMain.getGame().getPlayer().addIndizio(this.indizio);
		System.out.println("\nUn indizio è stato aggiunto alla tua lista\n");
	}
	
	public void acquireOggetto(String oggetto) {
		AppMain.getGame().getPlayer().addOggetto(oggetto);
		System.out.println("\nUn oggetto è stato aggiunto al tuo inventario\n");
	}
	
	public void removeOggetto(String oggetto) {
		AppMain.getGame().getPlayer().removeOggetto(oggetto);
		System.out.println("\nUn oggetto è stato rimosso dal tuo inventario\n");
	}
	
	protected void checkControllo() {
		if(AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].controllore) {
			System.out.println("\nIn questa stanza c'è una telecamera attiva! Esci dalla stanza prima che ti scoprano\n");
			
		}
	}
	public void vaiNord() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY, (this.posizioneZ+1));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY][this.posizioneZ+1].getNomeAmbiente());
		checkControllo();
	}
	
	public void vaiEst() {
		AppMain.getGame().getPlayer().setCoords((this.posizioneX+1), this.posizioneY, this.posizioneZ);
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX+1][this.posizioneY][this.posizioneZ].getNomeAmbiente());
		checkControllo();
	}
	
	public void vaiSud() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY, (this.posizioneZ-1));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY][this.posizioneZ-1].getNomeAmbiente());
		checkControllo();
	}
	
	public void vaiOvest() {
		AppMain.getGame().getPlayer().setCoords((this.posizioneX-1), this.posizioneY, (this.posizioneZ));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX-1][this.posizioneY][this.posizioneZ].getNomeAmbiente());
		checkControllo();
	}

	public void decodifica(String comando) {
	
	}

	public void guarda() {
		
	}
}
