package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class BagnoPadronaleEst extends Ambiente implements Stanza, Serializable {
	
	private String wcRegex = ".*(guarda|analizza|esamina)(\\s)+((il)(\\s+))?(wc|gabinetto|cesso).*";
	private String armadiettoRegex = ".*(guarda|analizza|esamina)(\\s)+((l')(\\s+))?(armadietto|armadio).*";
	
	protected BagnoPadronaleEst() {
		this.nomeAmbiente = "Bagno padronale (Lato Est)";
		this.setCoords(3, 1, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(wcRegex)) {
			System.out.println("\nPerchè lo trovi così interessante?\n");
		}
		else if(comando.matches(armadiettoRegex)) {
			System.out.println("\nNon vedo molto di interessante in un armadietto per i medicinali\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nIl bagno padronale è davvero imponente: quel WC è fatto addirittura di oro!\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nDa questa parte c'è solo una bella finestra in legno ed un WC\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDa questa parte c'è solo un armadietto per i medicinali\n");

	}
	
}
