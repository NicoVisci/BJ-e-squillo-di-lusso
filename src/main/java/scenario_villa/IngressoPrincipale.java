package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class IngressoPrincipale extends Ambiente implements Stanza, Serializable {
	
	private String orologioRegex = ".*(guarda|esamina|analizza)(\\s)+((l')(\\s+))?(orologio).*";
	
	protected IngressoPrincipale() {
		this.nomeAmbiente = "Ingresso Principale";
		this.setCoords(0, 0, 0);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(orologioRegex)) {
			System.out.println("\nE' uno splendido orologio a pendolo, ma non possiamo stare ad osservarlo tutto il giorno\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon c'è molto da questo lato all'infuori di un sontuoso orologio a pendolo\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questa parte c'è l'ingresso principale della villa, non penso sia una buona idea uscire ora\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nell'ingresso principale della villa, anche se è piuttosto inquietante: un antico orologio a pendolo"
						 + " scandisce i minuti e dando alla stanza un aspetto lugubre\n");
		
	}

}
