package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BalconeNord extends Ambiente implements Stanza, Serializable {
	
	private String telescopioRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(telescopio|cannocchiale|binocolo).*";
	
	protected BalconeNord() {
		this.nomeAmbiente = "Balcone (Lato Nord)";
		this.setCoords(3, 1, 2);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(telescopioRegex)) {
			System.out.println("\nE' sempre uno spettacolo ammirare le stelle!\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nQuesto balcone che da' sul giardino è davvero imponente: oh guarda c'è anche un binocolo\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nC'è solo un freddo muro davanti a te\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon vorrai mica buttarti di sotto, spero\n");

	}

}
