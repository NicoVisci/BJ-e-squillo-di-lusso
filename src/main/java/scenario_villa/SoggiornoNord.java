package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class SoggiornoNord extends Ambiente implements Stanza, Serializable {
	
	protected SoggiornoNord() {
		this.nomeAmbiente = "Soggiorno (Lato Nord)";
		this.setCoords(1, 0, 4);
	}

	@Override
	public void decodifica(String comando) {

			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella soggiorno della villa, dove gli Alfieri passano le giornate. Non c'è nulla di interessante\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nNon si può andare da questa parte\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nNon si può andare da questa parte\n");

	}

}
