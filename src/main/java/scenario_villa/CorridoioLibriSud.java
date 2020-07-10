package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioLibriSud extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioLibriSud() {
		this.nomeAmbiente = "Corridoio dei Libri (Lato Sud)";
		this.setCoords(0, 1, 0);
	}

	@Override
	public void decodifica(String comando) {
		CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei libri, non c'è nulla di interessante\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nUna libreria ti suggerisce che non c'è alcun passaggio da questa parte\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nUna libreria ti suggerisce che non c'è alcun passaggio da questa parte\n");

	}

}
