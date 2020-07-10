package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraOspiti extends Ambiente implements Stanza, Serializable {
	
	protected CameraOspiti() {
		this.nomeAmbiente = "Camera degli Ospiti";
		this.setCoords(0, 1, 4);
	}

	@Override
	public void decodifica(String comando) {
		
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella camera da letto degli ospiti, fortuna che non ci dorme nessuno\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon c'è null\na di interessante da questa parte");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nNon c'è null\na di interessante da questa parte");
		
	}

}
