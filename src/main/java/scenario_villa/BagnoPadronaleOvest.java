package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BagnoPadronaleOvest extends Ambiente implements Stanza, Serializable {
	
	private String vascaRegex = ".*(guarda|analizza|esamina)(\\s)+((la)(\\s+))?(vasca|sanitari|doccia).*";
	private String specchioRegex = ".*(guarda|analizza|esamina)(\\s)+((lo)(\\s+))?(specchio).*";
	
	protected BagnoPadronaleOvest() {
		this.nomeAmbiente = "Bagno padronale (Lato Ovest)";
		this.setCoords(2, 1, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(vascaRegex)) {
			System.out.println("\nMa questi qui hanno anche i sanitari dorati in casa: la prossima volta che torniamo rubiamo questi\n");
		}
		else if(comando.matches(specchioRegex)) {
			System.out.println("\nHo perso il conto degli specchi che ho visto in questa casa\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nIl bagno padronale è davvero imponente: i sanitari sono fatti addirittura di oro!\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nDa questo lato c'è solo l'ennesimo specchio della casa: ne vanno proprio matti\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nDa questa parte c'è un'immensa vasca tutta d'oro!\n");

	}

}
