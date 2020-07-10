package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StudioArianna extends Ambiente implements Stanza, Serializable {
	
	private String quadroRegex = ".*(guarda|analizza|esamina|prendi)\\s+((il)(\\s+))?(quadro|ritratto|dipinto).*";
	private String scrivaniaRegex = ".*(guarda|analizza|esamina)\\s*((la)(\\s*))?(scrivania).*";
	private String disegniRegex = ".*(guarda|analizza|esamina|prendi)\\s*((i)(\\s*))?(disegni|bozzetti|cavalletti).*";
	
	protected StudioArianna() {
		this.nomeAmbiente = "Studio di Arianna";
		this.indizio = "Il terzo e il quarto numero della combinazione hanno un divisore in comune";
		this.indizioAcq = false;
		this.posizioneX = 1;
		this.posizioneY = 0;
		this.posizioneZ = 1;
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(quadroRegex)) {
			System.out.println("\nUn quadro francese del periodo impressionista: molto bello ma non fornisce spunti interessanti\n");
		}
		else if(comando.matches(scrivaniaRegex)) {
			System.out.println("\nLa scrivania è piena di disegni e bozzetti di abiti\n");
		}
		else if(comando.matches(disegniRegex)) {
			System.out.println("\nCi sono disegni di abiti in tutta la stanza; uno in particolare attira la tua attenzione: "
							 + "è elegante e raffinato. C'è qualcosa scarabocchiato sul retro\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void vaiNord() {
		System.out.println("\nUn quadro impressionista domina la parete ma non c'è nulla di interessante\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDavanti a te ci sono diversi disegni di abiti ma non vedi alcuna via percorribile\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nNon ci sono passaggi da questa parte\n");

	}

	@Override
	public void guarda() {
		System.out.println("\nLo studio dove Arianna lavora e disegna i suoi abiti: una grande scrivania circolare"
						 + " domina la stanza con alle sue spalle diversi cavalletti con i bozzetti. Un quadro francese è appeso alla parete\n");
		
	}

}
