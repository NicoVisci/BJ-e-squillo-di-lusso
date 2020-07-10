package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.CoreInputControl;
@SuppressWarnings("serial")
class Salottino extends Ambiente implements Stanza, Serializable {
	
	private String poltroneRegex = ".*(guarda|analizza|esamina|siediti)(\\s)+((le|la|sulla|sulle)(\\s+))?(poltron).*";
	
	protected Salottino() {
		this.nomeAmbiente = "Salottino";
		this.setCoords(2, 1, 3);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(poltroneRegex)) {
			System.out.println("\nPerchè le trovi interessanti? Non è il momento di riposare\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nE' una stanza ampia con poltroncine ad ogni angolo\n");

	}

}
