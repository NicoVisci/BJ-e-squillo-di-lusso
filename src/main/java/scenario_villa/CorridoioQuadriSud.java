package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioQuadriSud extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioQuadriSud() {
		this.nomeAmbiente = "Corridoio dei Quadri (Lato Sud)";
		this.setCoords(2, 0, 1);
	}

	@Override
	public void decodifica(String comando) {
		CoreInputControl.getInstance().mancatoMatch();
	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questo lato ci sono solo quadri, non c'è nulla di interessante\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei quadri, non c'è nulla di interessante\n");
		
	}

}
