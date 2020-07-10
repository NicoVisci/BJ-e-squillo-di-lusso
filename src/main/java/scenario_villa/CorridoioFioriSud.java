package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioFioriSud extends Ambiente implements Stanza, Serializable {

	protected CorridoioFioriSud() {
		this.nomeAmbiente = "Corridoio dei Fiori (Lato Sud)";
		this.setCoords(2, 0, 4);
	}
	
	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei fiori, non c'è nulla di interessante\n");

	}

}
