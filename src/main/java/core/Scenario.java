package core;

/**
 * Classe che definisce le linee guida di uno scenario di partita
 * 
 * <p>Classe di tipo Entity	 
 * 
 * <p>Questa classe definisce le linee guida per la creazione di uno scenario di partita compatibile con l'applicazione
 * 
 * @author Nico Visci
*/
public abstract class Scenario {
	
	public Ambiente[][][] scenario;
	
	public int maxCordX, maxCordY, maxCordZ;
	
	public abstract void introScenario();
	
	public abstract void playerStarting();
	
	public abstract void attivaCamere();
	
	public abstract void disattivaCamere();

}
