package scenario_villa;
import java.io.Serializable;
import core.Ambiente;

import core.Stanza;

@SuppressWarnings("serial")
class PiccoloCaveau extends Ambiente implements Stanza, Serializable {
	
	protected PiccoloCaveau() {
		this.nomeAmbiente = "Piccolo Caveau";
		this.setCoords(1, 0, 2);
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
