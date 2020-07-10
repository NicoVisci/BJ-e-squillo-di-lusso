package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class GiardinoNord extends Ambiente implements Stanza, Serializable {
	
	private String fontanaRegex = ".*(guarda|esamina|analizza)(\\s)+((la)(\\s+))?(fontana|statua|pietra|base).*";
	
	protected GiardinoNord() {
		this.nomeAmbiente = "Giardino (Lato Nord)";
		this.indizio = "Il quarto numero della combinazione è i 2/3 del terzo numero";
		this.indizioAcq = false;
		this.setCoords(4, 0, 3);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(fontanaRegex)) {
			System.out.println("\nE' una fontana bellissima con la statua di una sirena che la sormonta. Noti qualcosa inciso sulla base in pietra.\n");
			if(!this.indizioAcq){
				this.acquireIndizio();
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel giardino della villa: c'è una bellissima fontana\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDa questo lato si esce dalla villa, non penso sia il caso\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nIl freddo muro ocra ti suggerisce che non ci sono vie da questa parte\n");

	}

}
