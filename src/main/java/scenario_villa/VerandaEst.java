package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class VerandaEst extends Ambiente implements Stanza, Serializable	{
	
	private String solariumRegex = ".*(guarda|esamina|analizza|entra)\\s+((nel|il)(\\s)+)?(solarium).*";
	private String idroRegex     = ".*(guarda|esamina|analizza|entra)\\s+((nell'|l')(\\s*))?(idro).*";
	private String soleRegex     = ".*(prendi il sole).*";
	
	protected VerandaEst() {
		this.nomeAmbiente = "Veranda (Lato Est)";
		this.setCoords(4, 0, 0);
	}
	
	@Override
	public void decodifica(String comando) {
		if(comando.matches(solariumRegex)) {
			System.out.println("\nE' un solarium per abbronzarsi nelle giornate più belle\n");
		}
		else if(comando.matches(idroRegex)) {
			System.out.println("\nQuesta famiglia non si fa mancare mai nulla: hanno persino un idromassaggio\n");
		}
		else if(comando.matches(soleRegex)) {
			System.out.println("\nMa cosa ti viene in mente? Siamo in piena notte!\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDa questa parte si esce dalla villa, non penso sia il caso\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nDa questa parte c'è il solarium\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel lato est della veranda della villa: c'è un solarium con un indromassaggio\n");
		
	}

}
