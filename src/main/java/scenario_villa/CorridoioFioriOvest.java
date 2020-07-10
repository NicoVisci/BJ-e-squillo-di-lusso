package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioFioriOvest extends Ambiente implements Stanza, Serializable {
	
	private boolean portaAperta = false;
	
	private String escaRegex = "((.*(posa)(\\s)+((il)(\\s+))?(esca|torta).*)|(.*(prepara)\\s+((la)\\s+)?(trappola).*))";
	private String tortaAvv = "Torta avvelenata";

	protected CorridoioFioriOvest() {
		this.nomeAmbiente = "Corridoio dei Fiori (Lato Ovest)";
		this.setCoords(1, 0, 5);
	}
	
	@Override
	public void decodifica(String comando) {
		if(comando.matches(escaRegex)) {
			if(AppMain.getGame().getPlayer().getInventario().contains(tortaAvv)) {
				
				AppMain.getGame().getPlayer().removeOggetto(tortaAvv);
				this.portaAperta = true;
				System.out.println("\nPosi la torta avvelenata davanti alla porta e bussi. L'uomo della sicurezza apre la porta e la raccoglie. "
								 + "Dopo dieci minuti esce ancora e corre verso il bagno: il veleno per topi ha fatto effetto\n"
								 + "Adesso puoi entrare nella Stanza delle Telecamere a nord di qui\n");
			}
			else {
				System.out.println("\nnon possiedi l'oggetto adatto\n");
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei fiori, la porta della stanza delle telecamere è ben visibile sulla parete nord\n");

	}

	@Override
	public void vaiNord() {
		if(!portaAperta) {
			System.out.println("\nLa porta della stanza telecamere è chiusa. Ci sarà un modo per far uscire la guardia all'interno?\n");
		}
		else {
			AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY, (this.posizioneZ+1));
			System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY][this.posizioneZ+1].getNomeAmbiente());
		}

	}

	@Override
	public void vaiSud() {
		System.out.println("\nIl pacchiano motivo a fiori della parete ti suggerisce che non ci sono vie da questa parte\n");

	}

}
