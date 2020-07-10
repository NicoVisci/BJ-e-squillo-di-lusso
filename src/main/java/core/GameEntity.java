package core;

import scenario_villa.ScenarioVilla;

/**
 * Classe di tipo entit� principale dell'applicazione
 * 
 * <p>Classe di tipo Entity	 
 * 
 * <p>Questa classe � l'entit� principale dell'applicazione. Contiene i riferimenti al giocatore e allo scenario attualmente attivi 
 * 
 * @author Nico Visci
*/

public class GameEntity {

	private Player player = null;
	
	private Scenario scenario = null;
	
	
	protected GameEntity() {
		this.player = new Player();
		newScenario();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	
	public void newScenario() {
		this.scenario = new ScenarioVilla();
	}
	
	public Scenario getScenario() {
		return scenario;
	}
	
	public void setScenario(Scenario newScenario) {
		scenario = newScenario;
	}
	
}
