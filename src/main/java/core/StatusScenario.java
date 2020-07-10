package core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe che descrive lo status corrente dello scenario di partita corrente, permettendo di serializzarlo oppure ricaricarlo su un nuovo scenario
 * 
 * <p>Classe di tipo Entity	 
 * 
 * @author Nico Visci
*/
@SuppressWarnings("serial")
public class StatusScenario implements Serializable {
	
	protected boolean[][][] acqIndizioState ;
	
	protected boolean[][][] controlloreState;
	
	protected ArrayList<ArrayList<ArrayList<ArrayList<String>>>> scenarioInventarioState;
	
	protected ArrayList<ArrayList<ArrayList<String>>> secondLevel = new ArrayList<ArrayList<ArrayList<String>>>();
	protected ArrayList<ArrayList<String>> firstLevel = new ArrayList<ArrayList<String>>();
	
	public StatusScenario() {
		
		Scenario scenario = AppMain.getGame().getScenario();
		
		this.acqIndizioState  = new boolean [scenario.maxCordX][scenario.maxCordY][scenario.maxCordZ];
		this.controlloreState = new boolean [scenario.maxCordX][scenario.maxCordY][scenario.maxCordZ];
		this.scenarioInventarioState = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					this.acqIndizioState[x][y][z] = scenario.scenario[x][y][z].indizioAcq;
				}
			}
		}
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					this.controlloreState[x][y][z] = scenario.scenario[x][y][z].controllore;
				}
			}
		}
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					this.firstLevel.add(scenario.scenario[x][y][z].inventario);
				}
				this.secondLevel.add(this.firstLevel);			
			}
			this.scenarioInventarioState.add(this.secondLevel);
		}	
	}

	public void setStatus() {
		
		Scenario scenario = AppMain.getGame().getScenario();
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					scenario.scenario[x][y][z].indizioAcq = this.acqIndizioState[x][y][z];
				}
			}
		}
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					scenario.scenario[x][y][z].controllore = this.controlloreState[x][y][z];
				}
			}
		}
		
		for(int x = 0; x<scenario.maxCordX; x++) {
			for(int y = 0; y<scenario.maxCordY; y++) {
				for(int z = 0; z<scenario.maxCordZ; z++) {
					scenario.scenario[x][y][z].inventario.addAll(this.scenarioInventarioState.get(x).get(y).get(z));
				}
			}
		}
	}
}
