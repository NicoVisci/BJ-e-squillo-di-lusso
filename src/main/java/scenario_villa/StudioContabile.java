package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StudioContabile extends Ambiente implements Stanza, Serializable {
	
	private String scrivaniaRegex = ".*(guarda|analizza|esamina)\\s+((la|i|gli)(\\s+))?(scrivania|documenti|schedari).*";
	private String libroRegex = ".*(guarda|analizza|esamina|prendi)\\s+((il)(\\s+))?(libro).*";
	private String pCaveauRegex = ".*(guarda|analizza|esamina)\\s+((il)(\\s+))?(piccolo caveau|caveau|porta del caveau|porta caveau).*";
	
	protected StudioContabile() {
		this.nomeAmbiente = "Studio del contabile";
		this.indizio = "L'ultimo numero della combinazione è 8";
		this.indizioAcq = false;
		this.posizioneX = 0;
		this.posizioneY = 0;
		this.posizioneZ = 2;
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(scrivaniaRegex)) {
			System.out.println("\nUna scrivania piena zeppa di documenti: un libro rilegato spicca al centro del piano\n");
		}
		else if(comando.matches(pCaveauRegex)) {
			System.out.println("\nLa porta di un caveau piccolo ma ben robusto, forzarlo non è neanche pensabile; Non conosci neanche la combinazione\n");
		}
		else if(comando.matches(libroRegex)) {
			System.out.println("\nUn professionale libro paga pieno zeppo di annotazioni, cifre e date. Un biglietto cade "
							 + "dall'interno delle pagine\n");
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
		System.out.println("\nLo studio del contabile è pieno di schedari e documenti impilati sulla sua enorme scrivania, "
						 + "su cui giace un professionale libro paga. La porta di un piccolo Caveau spicca dall'angolo est della stanza\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nLa porta di un piccolo caveau si staglia in un angolo di una parete tinteggiata giallo crema\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nUna spaziosa finestra la fa da padrone sulla parete, ma non ci sono vie accessibili da questa parte\n");

	}

}
