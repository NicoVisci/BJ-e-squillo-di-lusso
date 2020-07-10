package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.CoreInputControl;
@SuppressWarnings("serial")
class SalaRelax extends Ambiente implements Stanza, Serializable {
	
	private String homeTRegex = ".*(guarda|analizza|esamina|siediti)(\\s)+((il|l')(\\s+))?(home|theatre).*";
	private String accendiTRegex = ".*(accendi)(\\s)+((il|l')(\\s+))?(home|theatre).*";
	
	protected SalaRelax() {
		this.nomeAmbiente = "Sala Relax";
		this.setCoords(1, 1, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(homeTRegex)) {
			System.out.println("\nUn impianto di ultima generazione. Hanno praticamente un cinema in casa\n");
		}
		else if(comando.matches(accendiTRegex)) {
			System.out.println("\nNON ACCENDERLO! Sveglierai qualcuno!\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nIn questa stanza la famiglia Alfieri viene per rilassarsi: hanno anche un home theatre.\n");
	}

	@Override
	public void vaiNord() {
		System.out.println("\nNon ci sono vie da questa parte\n");
	}

}
