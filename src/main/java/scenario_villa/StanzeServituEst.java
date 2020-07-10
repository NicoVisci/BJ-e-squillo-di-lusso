package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StanzeServituEst extends Ambiente implements Stanza, Serializable {
	
	protected StanzeServituEst() {
		this.nomeAmbiente = "Stanze della Servit� (Lato Est)";
		this.setCoords(3, 0, 6);
	}

	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella living room della servit�, non c'� niente di interessante\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nC'� solo una finestra da questo lato\n");

	}

}
