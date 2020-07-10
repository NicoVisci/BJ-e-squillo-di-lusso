package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StanzaTelecamere extends Ambiente implements Stanza, Serializable {
	
	private String quadroRegex = ".*(guarda|analizza|esamina|prendi)\\s+((il)(\\s+))?(quadro|ritratto).*";
	private String schermiRegex = ".*(guarda|analizza|esamina)\\s+((gli|il|le|l')(\\s+))?(telecamere|schermi|apparecchio).*";
	private String telecamereRegex = ".*(spegni|disattiva|disabilita|disconnetti)\\s+((le|i)(\\s+))?(telecamere|dispositivo|dispositivi).*";
	
	protected StanzaTelecamere() {
		this.nomeAmbiente = "Stanza delle telecamere";
		this.indizio = "Il secondo numero della combinazione è esattamente la metà del quinto numero";
		this.indizioAcq = false;
		this.posizioneX = 1;
		this.posizioneY = 0;
		this.posizioneZ = 6;
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(quadroRegex)) {
			System.out.println("\nUn ritratto fiero e maestoso del padrone di casa Riccardo Alfieri che scruta "
							 + "con il suo sguardo arcigno il malcapitato sottoposto\nC'è un biglietto sul retro\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else if(comando.matches(schermiRegex)) {
			System.out.println("\nUn pannello di controllo che gestisce un complesso sistema di antifurti e telecamere sparsi"
							 + "per tutta la casa. Puoi davvero controllare tutto da qui\n");
		}
		else if(comando.matches(telecamereRegex)) {
			AppMain.getGame().getScenario().disattivaCamere();
			System.out.println("\nLe telecamere sono state disattivate.\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nUna stanza dedita al controllo della villa, con schermi che trasmettono immagini "
						 + "da tutte le telecamere: ci sono i comandi per disattivarle; alle spalle della sedia "
						 + "c'è un ritratto del Signor Alfieri che scruta la situazione\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nC'è solo una parete bianca da questa parte\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nIl ritratto del Signor Alfieri ha uno sguardo arcigno. Non ci sono passaggi da questa parte\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nIl quadro dei comandi domina questo lato della stanza\n");

	}

}
