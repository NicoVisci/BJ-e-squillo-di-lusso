package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioQuadriNord extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioQuadriNord() {
		this.nomeAmbiente = "Corridoio dei Quadri (Lato Nord)";
		this.setCoords(2, 0, 2);
	}

	@Override
	public void decodifica(String comando) {
		CoreInputControl.getInstance().mancatoMatch();
	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei quadri, non c'è nulla di interessante\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questo lato ci sono solo dei quadri, non c'è nulla di interessante\n");

	}

}
