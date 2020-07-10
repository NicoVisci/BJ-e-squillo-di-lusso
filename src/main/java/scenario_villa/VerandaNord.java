package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class VerandaNord extends Ambiente implements Stanza, Serializable {
	
	private String serraRegex = ".*(guarda|esamina|analizza)\\s+((la)(\\s)+)?(serra).*";

	protected VerandaNord() {
		this.nomeAmbiente = "Veranda (Lato Nord)";
		this.setCoords(4, 0, 1);
	}
	
	@Override
	public void decodifica(String comando) {
		if(comando.matches(serraRegex)) {
			System.out.println("\nE' una piccola serra dove la signora Alfieri coltiva la sua passione da pollice verde\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon è possibile andare da questa parte\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nNon è possibile andare da questa parte\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel lato nord della veranda della villa: c'è una piccola serra da questa parte\n");
		
	}

}
