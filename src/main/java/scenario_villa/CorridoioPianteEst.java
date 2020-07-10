package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioPianteEst extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioPianteEst() {
		this.nomeAmbiente = "Corridoio delle Piante (Lato Est)";
		this.setCoords(1, 1, 3);
	}

	@Override
	public void decodifica(String comando) {
		CoreInputControl.getInstance().mancatoMatch();
	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio delle piante, non c'è nulla di interessante\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nUna pianta ti suggerisce che non c'è alcun passaggio da questa parte\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nUna pianta ti suggerisce che non c'è alcun passaggio da questa parte\n");

	}
	
}
