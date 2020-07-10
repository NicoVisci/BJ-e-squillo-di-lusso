package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BagnoOspiti2ndFloor extends Ambiente implements Stanza, Serializable {
	
	private String specchioRegex = ".*(guarda|analizza|esamina)(\\s)+((lo)(\\s+))?(specchio|bagno).*";
	
	protected BagnoOspiti2ndFloor() {
		this.nomeAmbiente = "Bagno degli ospiti (Primo Piano)";
		this.setCoords(0, 1, 5);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(specchioRegex)) {
			System.out.println("\nTi sei già specchiato abbastanza: non è il momento di essere narcisisti\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nTi trovi nel bagno degli ospiti al primo piano: uno specchio grande quando la parete riflette la tua immagine\n");

	}
	
	@Override
	public void vaiNord() {
		System.out.println("\nnon ci sono vie percorribili da questa parte\n");
	}

	@Override
	public void vaiEst() {
		System.out.println("\nFinisci per guardarti nello specchio: hai proprio l'aspetto di un criminale\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questo lato c'è la finestra da cui ti sei introdotto\n");

	}

}
