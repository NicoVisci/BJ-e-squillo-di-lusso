package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class SoggiornoSud extends Ambiente implements Stanza, Serializable {
	
	private String quadriRegex = ".*(guarda|esamina|analizza)(\\s)+((i|il)(\\s+))?(quadri|quadro).*";

	protected SoggiornoSud() {
		this.nomeAmbiente = "Soggiorno (Lato Sud)";
		this.setCoords(1, 0, 3);
	}
	
	@Override
	public void decodifica(String comando) {
		if(comando.matches(quadriRegex)) {
			System.out.println("\nUn bel quadro di un tramonto, ma non ha nulla di particolare\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella soggiorno della villa, dove gli Alfieri passano le giornate. C'è il quadro di un tramonto\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon ci sono porte da questo lato\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nDa questa parte c'è un quadro raffigurante un tramonto\n");

	}

}
