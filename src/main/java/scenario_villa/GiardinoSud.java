package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class GiardinoSud extends Ambiente implements Stanza, Serializable {
	
	protected GiardinoSud() {
		this.nomeAmbiente = "Giardino (Lato sud)";
		this.setCoords(4, 0, 2);
	}

	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel giardino della villa: la vegetazione è ben curata\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questo lato si esce dalla villa, non penso sia il caso\n");

	}

}
