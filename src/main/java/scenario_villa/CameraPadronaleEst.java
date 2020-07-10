package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraPadronaleEst extends Ambiente implements Stanza, Serializable {
	
	private String fotografieRegex = "(guarda|analizza|esamina)\s+((il|le)(\s+))?(mobile|mobile per le fotografie|fotografie)\s.*";
	private String tappetoRegex = "(guarda|analizza|esamina)\s+((il)(\s+))?(tappeto)\s.*";

	protected CameraPadronaleEst() {
		this.nomeAmbiente = "Camera da letto padronale (Lato Est)";
		this.indizio = "Il primo numero della combinazione è esattamente la metà del secondo numero";
		this.indizioAcq = false;
		this.setCoords(4, 1, 4);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(tappetoRegex)) {
			System.out.println("\nE' uno splendido tappeto persiano, di squisita fattura\n");
		}
		else if(comando.matches(fotografieRegex)) {
			System.out.println("\nCi sono fotografie di tutta la famiglia. Una di queste non ha cornice ed è appoggiata sul mobile. C'è qualcosa "
							 + "scritto sul retro\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella camera da letto dei coniugi Alfieri. C'è uno splendido tappeto e un bel mobile per le fotografie\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nC'è un mobile per le fotografie da questa parte\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nC'è un'immensa finestra da questa parte\n");

	}

}
