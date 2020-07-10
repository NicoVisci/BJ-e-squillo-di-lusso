package scenario_villa;

import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BalconeSud extends Ambiente implements Stanza, Serializable {
	
	private String fioriRegex = ".*(guarda|esamina|analizza)(\\s)+((i)(\\s+))?(fiori|vasi|piante|fiorellini).*";

	protected BalconeSud() {
		this.nomeAmbiente = "Balcone (Lato Sud)";
		this.setCoords(3, 1, 1);
	}
	
	@Override
	public void decodifica(String comando) {
		if(comando.matches(fioriRegex)) {
			System.out.println("\nSono molto carini questi fiori ma ora concentrati sul tuo obbiettivo\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nQuesto balcone che da' sul giardino è davvero imponente: ci crescono anche dei fiori\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon vorrai mica buttarti di sotto, spero\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon vorrai mica buttarti di sotto, spero\n");

	}

}
