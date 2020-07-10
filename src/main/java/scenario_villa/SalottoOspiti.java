package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.CoreInputControl;
@SuppressWarnings("serial")
class SalottoOspiti extends Ambiente implements Stanza, Serializable {
	
	private String sofaRegex = ".*(guarda|analizza|esamina|siediti)(\\s)+((il|sul)(\\s+))?(sof|divano).*";
	
	protected SalottoOspiti() {
		this.nomeAmbiente = "Salotto degli ospiti";
		this.setCoords(0, 0, 3);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(sofaRegex)) {
			System.out.println("\nNon possiamo di certo prestare attenzione ad ogni articolo in questa casa\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nUn salottino dove i coniugi Alfieri accolgono gli ospiti su un comodissimo sofà\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nC'è solo un sofà da quella parte\n");

	}

}
