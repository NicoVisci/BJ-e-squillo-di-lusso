package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class VerandaOvest extends Ambiente implements Stanza, Serializable {
	
	protected VerandaOvest() {
		this.nomeAmbiente = "Veranda (Lato Ovest)";
		this.setCoords(3, 0, 0);
	}

	@Override
	public void decodifica(String comando) {
		
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon si può andare da questa parte\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel lato ovest della veranda della villa: non c'è nulla di interessante\n");
		
	}

}
