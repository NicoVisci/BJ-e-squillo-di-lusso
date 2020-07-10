package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioLibriNord extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioLibriNord() {
		this.nomeAmbiente = "Corridoio dei Libri (Lato Nord)";
		this.setCoords(0, 1, 1);
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
	public void vaiOvest() {
		System.out.println("\nUna libreria ti suggerisce che non c'è alcun passaggio da questa parte\n");

	}

}
