package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StudioRiccardo extends Ambiente implements Stanza, Serializable {
	
	private String quadroRegex = ".*(guarda|analizza|esamina|prendi)\\s+((il)(\\s+))?(quadro|ritratto|dipinto).*";
	private String scrivaniaRegex = ".*(guarda|analizza|esamina)\\s*((la)(\\s*))?(scrivania).*";
	private String documentiRegex = ".*(guarda|analizza|esamina|prendi)\\s*((i)(\\s*))?(documenti).*";
	private String cassettoRegex = ".*(guarda|analizza|esamina|apri)\\s+((il)(\\s+)?(cassett).*";
	
	protected StudioRiccardo() {
		this.nomeAmbiente = "Studio di Riccardo";
		this.indizio = "Il numero centrale della combinazione è un quadrato perfetto";
		this.indizioAcq = false;
		this.setCoords(2, 1, 0);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(quadroRegex)) {
			System.out.println("\nUn quadro molto bello ma nulla di interessante\n");
		}
		else if(comando.matches(scrivaniaRegex)) {
			System.out.println("\nLa scrivania è molto grande ma sembra piccola rispetto a quanti documenti ci sono poggiati. Un cassetto non è chiuso\n");
		}
		else if(comando.matches(documentiRegex)) {
			System.out.println("\nQuesti sono i documenti degli affari del signor Alfieri, ma non sono il nostro obbiettivo ora\n");
		}
		else if(comando.matches(cassettoRegex)) {
			System.out.println("\nApri il cassetto e ci trovi un curioso biglietto\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nLo studio dove Riccardo Alfieri lavora e gestisce i suoi affari: la sua scrivania è piena di documenti"
				 		 + " mentre uno schermo per le videoconferenze è appeso alla parete, assieme ad un quadro.\n");
	}

	@Override
	public void vaiSud() {
		System.out.println("\nLa maestosa scrivania di Alfieri ti blocca la via\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDa questo lato ci sono solo finestre\n");

	}

}
