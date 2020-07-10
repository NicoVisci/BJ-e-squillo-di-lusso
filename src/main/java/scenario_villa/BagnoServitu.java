package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BagnoServitu extends Ambiente implements Stanza, Serializable {
	
	protected BagnoServitu() {
		this.nomeAmbiente = "Bagno della servitù";
		this.setCoords(4, 0, 6);
	}

	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nel bagno privato della servitù. Non c'è nulla di interessante\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nNon c'è nulla di interessante da questa parte\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon c'è nulla di interessante da questa parte\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon c'è nulla di interessante da questa parte\n");

	}
}
