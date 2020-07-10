package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;


@SuppressWarnings("serial")
class CameraPadronaleSud extends Ambiente implements Stanza, Serializable {
	
	private String caminoRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(camino).*";
	
	protected CameraPadronaleSud() {
		this.nomeAmbiente = "Camera da letto padronale (Lato Sud)";
		this.setCoords(3, 1, 4);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(caminoRegex)) {
			System.out.println("\nC'è un camino per riscaldare la stanza nei giorni più freddi\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella camera da letto dei coniugi Alfieri. C'è un camino lì nell'angolo\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nC'è solo un camino da questa parte\n");

	}

}
