package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraAriannaSud extends Ambiente implements Stanza, Serializable {
	
	private String bozzettiRegex = ".*(guarda|esamina|analizza)(\\s)+((i)(\\s+))?(bozzetti|disegni|abiti|vestiti).*";
	
	protected CameraAriannaSud() {
		this.nomeAmbiente = "Camera di Arianna (Lato Sud)";
		this.setCoords(1, 1, 4);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(bozzettiRegex)) {
			System.out.println("\nSono dei bozzetti di abiti da sera. Si vede il tocco di una stilista alle prime armi\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella camera da letto di Arianna, la figlia di Alfieri. Ci sono tanti bozzetti di abiti anche qui\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nI bozzetti di abiti sono appesi per tutta la parete\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nI bozzetti di abiti sono appesi per tutta la parete\n");

	}

}
