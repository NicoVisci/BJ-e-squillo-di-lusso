package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraPadronaleOvest extends Ambiente implements Stanza, Serializable {
	
	private String quadriRegex = ".*(guarda|esamina|analizza)(\\s)+((i|il)(\\s+))?(quadri|quadro).*";
	
	protected CameraPadronaleOvest() {
		this.nomeAmbiente = "Camera da letto padronale (Lato Ovest)";
		this.setCoords(3, 1, 5);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(quadriRegex)) {
			System.out.println("\nSono dei bei quadri di Renoir e Van Gogh\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella camera da letto dei coniugi Alfieri: ci sono dei bei quadri da questa parte\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nLa parete è stata riempita da bei quadri francesi e olandesi\n");

	}

}
