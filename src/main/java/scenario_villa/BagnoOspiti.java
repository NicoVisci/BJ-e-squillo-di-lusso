package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BagnoOspiti extends Ambiente implements Stanza, Serializable {
	
	private String specchioRegex = ".*(guarda|analizza|esamina)(\\s)+((lo)(\\s+))?(specchio|bagno).*";
	
	protected BagnoOspiti() {
		this.nomeAmbiente = "Bagno degli ospiti (Piano Terra)";
		this.setCoords(0, 0, 4);
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
		System.out.println("\nTi trovi nel bagno degli ospiti al pian terreno, è da qui che inizia la tua impresa\n");

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
