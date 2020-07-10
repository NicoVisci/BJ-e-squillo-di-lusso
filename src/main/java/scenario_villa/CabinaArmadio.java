package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CabinaArmadio extends Ambiente implements Stanza, Serializable{
	
	private String vestitiRegex = ".*(guarda|esamina|analizza)(\\s)+((i|gli|l'|la)(\\s+))?(vestiti|abiti|armadio|cabina armadio).*";
	
	public CabinaArmadio() {
		this.nomeAmbiente = "Cabina Armadio";
		this.setCoords(4, 1, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(vestitiRegex)) {
			System.out.println("\nDavvero mi chiedo: qualcuno avrà mai indossato tutti questi vestiti?\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nell'immensa cabina armadio dei coniugi Alfieri\n");
	}

	@Override
	public void vaiNord() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

}
