package core;

import gui.InputField;
import scenario_villa.ControlloScenarioVilla;

/**
 * Classe facente parte della catena per il controllo dell'input utente
 * 
 * <p>Classe di tipo Control	 
 * 
 * <p>Questa classe fa parte della catena per il controllo dell'input utente.
 * Autorizza al controllo dell'applicazione una classe da lei gestita, altrimenti passa il controllo al prossimo oggetto della catena
 * La classe è un Singleton
 * 
 * @author Nico Visci
*/
public class CoreInputControl implements InputControlFlowComponent {
	
	private static CoreInputControl coreInputControl = null;
	private static InputControlFlowComponent nextInTheChain;
	
	private String swearRegex = ".*(culo|cazzo|succhiamelo|ciucciamelo|trimone).*";
	private String inventarioRegex = ".*((visualizza|vedi|esamina|guarda)(\\s+)(.*))?(inventario|oggetti).*";
	private String listaIndiziRegex =  ".*((visualizza|vedi|esamina|guarda)(\\s+)(.*))?(lista|lista indizi|indizi).*";
	//private String ambientiRegex = ".*(vai|nord|sud|est|ovest|esamina|guarda|analizza|prendi|combina|sveglia|tocca|scuoti|disattiva|spegni|disabilita|disconnetti|accendi|perchè non l'hai detto subito\\?).*";
	
	
	private CoreInputControl() {
		nextInTheChain = ControlloScenarioVilla.getInstance();
	}
	
	public static CoreInputControl getInstance() {
		if(coreInputControl == null) {
			coreInputControl = new CoreInputControl();
		}
		return coreInputControl;
	}
	
	@Override
	public void decodifica(String comando) {
		
		if(AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].controllore) {
			AppMain.getGame().getPlayer().setControllato(true);
		}
		else {
			AppMain.getGame().getPlayer().setControllato(false);
		}
		if (comando.matches(swearRegex)) {
			System.out.println("\nL'uso di queste parole non è consentito in questa applicazione\nCome punizione, questa partita è stata cancellata");
			AppMain.setGame(null);
		}
		else if(comando.matches(inventarioRegex)) {
			AppMain.getGame().getPlayer().printInventario();
		}
		else if(comando.matches(listaIndiziRegex)) {
			AppMain.getGame().getPlayer().printListaIndizi();
		}
		else {
			nextInTheChain.decodifica(comando);
		}
		try {
			if(AppMain.getGame().getPlayer().isControllato() && AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].controllore) {
				System.out.println("\nLa telecamera ti ha notato ed è scattato l'allarme! Sei stato scoperto!\n");
				AppMain.setGame(null);
			}
		}
		catch(NullPointerException e) {
			
		}
		if(AppMain.getGame() == null) {
			System.out.println("\nLa partita è terminata!");
			InputField.setFocus(false);
			AppMain.setNewPlayToken(true);
		}
		
	}

	public void mancatoMatch() {
		System.out.println("Ma cosa stai dicendo? Non capisco ");
	}
}
