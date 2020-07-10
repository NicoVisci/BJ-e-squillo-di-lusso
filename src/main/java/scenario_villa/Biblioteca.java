package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class Biblioteca extends Ambiente implements Stanza, Serializable {
	
	private String libriRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(libri|libro|libreria|librerie).*";
	private String poltronaRegex = ".*(guarda|esamina|analizza)(\\s)+((la)(\\s+))?(poltrona).*";
	
	public Biblioteca() {
		this.nomeAmbiente = "Biblioteca";
		this.setCoords(0, 0, 1);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(libriRegex)) {
			System.out.println("\nCi sono davvero un sacco di libri in questa stanza: ma qualcuno li leggerà mai tutti?\n");
		}
		else if(comando.matches(poltronaRegex)) {
			System.out.println("\nE' una poltrona per i lettori: sembra davvero comoda\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}
	
	@Override
	public void guarda() {
		System.out.println("\nTi trovi nell'immensa biblioteca della villa: ci sono libri ovunque si posi lo sguardo!\n");
		
	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDavanti a te vedi solo un'immensa libreria gremita di libri: non ci sono vie percorribili\n");

	}
	
}
