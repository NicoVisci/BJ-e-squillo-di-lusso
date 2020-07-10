package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class IngressoVeranda extends Ambiente implements Stanza, Serializable {
	
	protected IngressoVeranda() {
		this.nomeAmbiente = "Ingresso Veranda";
		this.setCoords(2, 0, 0);
		}

	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon c'è nulla di interessante da questa parte\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nDa questa stanza si può accedere alla veranda o immettersi nel corridoio principale\n");
		
	}

}
