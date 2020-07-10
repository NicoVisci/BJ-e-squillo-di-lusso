package scenario_villa;

import java.util.ArrayList;

import core.AppMain;
import core.InputControlFlowComponent;
import core.Player;

/**
 * 
 * La classe di controllo principale del package che gestisce gli eventi possibili nello scenario VILLA
 * 
 * <p>Classe di tipo Control
 * 
 * @author Nico Visci
 *
 */

public class ControlloScenarioVilla implements InputControlFlowComponent {
	
	private static ControlloScenarioVilla controlloScenarioVilla = null;
	
	private static String nordRegex    = ".*((vai)(\\s+))?(a\\s|verso\\s)?(nord).*";
	private static String eastRegex    = ".*((vai)(\\s+))?(a\\s|verso\\s)?[^ov](est).*";
	private static String southRegex   = ".*((vai)(\\s+))?(a\\s|verso\\s)?(sud).*";
	private static String westRegex    = ".*((vai)(\\s+))?(a\\s|verso\\s)?(ovest).*";
	
	private static String guardaRegex  = ".*(guarda|esamina|analizza)(\\s+(stanza))?";
	private static String cheatRegex   = "(perchè non l'hai detto subito\\?)";
	
	private static String combinaTortaVelenoRegex = ".*(combina)\\s+(pezzo di torta|torta)\\s+(veleno|veleno per topi).*";
	
	private ControlloScenarioVilla() {
		//Empty
	}
	
	public static ControlloScenarioVilla getInstance() {
		if(controlloScenarioVilla == null) {
			controlloScenarioVilla = new ControlloScenarioVilla();
		}
		return controlloScenarioVilla;
	}

	@Override
	public void decodifica(String comando) {
		try {
			if(comando.matches(nordRegex)) {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].vaiNord();
			}
			else if(comando.matches(eastRegex)) {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].vaiEst();
			}
			else if(comando.matches(southRegex)) {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].vaiSud();
			}
			else if(comando.matches(westRegex)) {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].vaiOvest();
			}
			else if(comando.matches(guardaRegex)) {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].guarda();
			}
			else if(comando.matches(combinaTortaVelenoRegex)) {
				ArrayList<String> thisInvent = AppMain.getGame().getPlayer().getInventario();
				if(thisInvent.contains("Pezzo di torta") && thisInvent.contains("Veleno per topi")) {
					thisInvent.remove("Pezzo di torta");
					thisInvent.remove("Veleno per topi");
					thisInvent.add("Torta avvelenata");
					System.out.println("\nHai combinato con successo i due oggetti ed hai ottenuto Torta avvelenata\n");
				}
				else {
					System.out.println("\nNon possiedi questi oggetti!\n");
				}
			}
			else if(comando.matches(cheatRegex)) {
				
				Player thisPlayer = AppMain.getGame().getPlayer();
				thisPlayer.getListaIndizi().addAll(ScenarioVilla.listaIndizi);
				AppMain.getGame().getScenario().disattivaCamere();
				thisPlayer.setCoords(2, 1, 2);
				System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[thisPlayer.getX()][thisPlayer.getY()][thisPlayer.getZ()].getNomeAmbiente());
				
			}
			else {
				AppMain.getGame().getScenario().scenario[AppMain.getGame().getPlayer().getX()][AppMain.getGame().getPlayer().getY()][AppMain.getGame().getPlayer().getZ()].decodifica(comando);
			}
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.err.println("\nNON ESISTE UN'AMBIENTE IN QUESTO PUNTO!\n");
		}
		
	}
	
}
