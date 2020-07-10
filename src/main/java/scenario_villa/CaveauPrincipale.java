package scenario_villa;
import java.io.Serializable;

import core.Ambiente;

import core.Stanza;

@SuppressWarnings("serial")
class CaveauPrincipale extends Ambiente implements Stanza, Serializable {
	
	protected CaveauPrincipale() {
		this.nomeAmbiente = "Caveau Principale";
		this.setCoords(1, 1, 2);
	}

	@Override
	public void decodifica(String comando) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guarda() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vaiNord() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vaiEst() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vaiSud() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vaiOvest() {
		// TODO Auto-generated method stub

	}

}
