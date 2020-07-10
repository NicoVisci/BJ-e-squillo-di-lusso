package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CorridoioFioriNord extends Ambiente implements Stanza, Serializable {
	
	protected CorridoioFioriNord() {
		this.nomeAmbiente = "Corridoio dei Fiori (Lato Nord)";
		this.setCoords(2, 0, 5);
	}

	@Override
	public void decodifica(String comando) {
		
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel corridoio dei fiori, non c'è nulla di interessante\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nIl pacchiano motivo a fiori della parete ti suggerisce che non ci sono vie da questa parte\n");

	}
	
	@Override
	public void vaiEst() {
		System.out.println("\nIl pacchiano motivo a fiori della parete ti suggerisce che non ci sono vie da questa parte\n");
	}

}
