package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class Cucina extends Ambiente implements Stanza, Serializable {
	
	private String credenzaRegex = ".*(guarda|analizza|esamina)(\\s)+((la|le|i)(\\s+))?(credenza|tegami|pentole|piatti).*";
	private String isolaRegex = ".*(guarda|analizza|esamina)(\\s)+((la)(\\s*))?(cucina|isola|l'isola|fornelli).*";
	private String lavagnaRegex = ".*(guarda|analizza|esamina|prendi|leggi)(\\s)+((la|i)(\\s*))?(lavagna|lavagnetta|promemoria).*";
	private String tortaRegex = ".*(guarda|analizza|esamina|prendi)(\\s)+((la|un)(\\s*))?(torta|pezzo di torta).*";
	
	final String torta = "Pezzo di torta";
	
	protected Cucina() {
		
		this.inventario.add(torta);                            //add(posTorta, "Pezzo di torta");
		this.nomeAmbiente = "Cucina";
		this.indizio = "La somma del primo e dell'ultimo numero della combinazione è uguale alla somma del secondo e del quarto numero";
		this.indizioAcq = false;
		this.setCoords(3, 0, 5);

	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(credenzaRegex)) {
			System.out.println("\nC'è una credenza gremita di pentole, piatti e tegami ma non vedi nulla di interessante\n");
		}
		else if(comando.matches(isolaRegex)) {
			System.out.println("\nC'è una spaziosa e moderna isola centrale con tutti gli elettrodomestici di ultima generazione."
							 + " C'è una lavagnetta per i promemoria e una torta abbandonata\n");
		}
		else if(comando.matches(lavagnaRegex)) {
			System.out.println("\nSulla lavagnetta c'è un promemoria: \"Ricordati di portare un pezzo di torta a Marco, il ragazzo addetto alle telecamere\"."
							 + " C'è anche un appunto appena leggibile");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else if(comando.matches(tortaRegex)) {
			System.out.println("\nQuesta torta sembra molto invitante: ne prendi un pezzo. Forse potrai farci qualcosa\n");
			this.acquireOggetto(this.getOggettoFromInventario(torta));
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}
	}

	@Override
	public void guarda() {
		System.out.println("\nLa cucina non è molto grande ma è ben organizzata, con un'isola per i fornelli al centro della stanza."
						 + " Una credenza per i tegami ricopre un'intera parete. C'è anche una lavagnetta per i promemoria e una torta "
						 + "abbandontata sul pianale\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nLa credenza dei tegami ricopre tutta la parete: non ci sono vie da questa parte\n");

	}

}
