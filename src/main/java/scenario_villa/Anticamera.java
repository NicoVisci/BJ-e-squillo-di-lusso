package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class Anticamera extends Ambiente implements Stanza, Serializable {
	
	private String divanoRegex = ".*(guarda|analizza|esamina|siediti)(\\s)+((sul|il)(\\s+))?(divano|sof�).*";
	
	protected Anticamera() {
		this.nomeAmbiente = "Anticamera alle camere da letto";
		this.setCoords(2, 1, 4);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(divanoRegex)) {
			System.out.println("\nIl divano � davvero invitante ma non � il momento di riposare\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}
	

	@Override
	public void guarda() {
		System.out.println("\nE' la stanza d'ingresso alle camere da letto, c'� anche un divano appoggiato alla parete\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nNon c'� nulla da questa parte all'infuori del sof�\n");

	}

}
