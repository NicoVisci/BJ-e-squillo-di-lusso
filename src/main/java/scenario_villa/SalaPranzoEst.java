package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.CoreInputControl;
@SuppressWarnings("serial")
class SalaPranzoEst extends Ambiente implements Stanza, Serializable {
	
	private String tavoloRegex = ".*(guarda|analizza|esamina|siediti)(\\s)+((il|al)(\\s+))?(tavolo).*";
	
	protected SalaPranzoEst() {
		this.nomeAmbiente = "Sala Pranzo (Lato Est)";
		this.setCoords(4, 0, 4);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(tavoloRegex)) {
			System.out.println("\nLa grandezza del tavolo da pranzo è proporzionale all'importanza della famiglia nell'alta società\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella sala da Pranzo della villa: c'è un immenso tavolo da 16 posti\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nDa questa parte c'è solo un quadro raffigurante una cena\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nC'è un immensa finestra da questa parte: in questa villa tutto è di grandi dimensioni\n");

	}

}
