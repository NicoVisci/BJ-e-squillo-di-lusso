package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class SalaBiliardo extends Ambiente implements Stanza, Serializable {
	
	private String biliardoRegex = ".*(guarda|analizza|esamina)(\\s)+((il)(\\s+))?(biliardo|tavolo da biliardo).*";
	private String barRegex = ".*(guarda|analizza|esamina)(\\s)+((il|gli)(\\s+))?(bar|bancone|alcolici).*";
	private String freccetteRegex = ".*(guarda|analizza|esamina)(\\s)+((il|le)(\\s+))?(bersaglio|freccette).*";
	
	protected SalaBiliardo() {
		this.nomeAmbiente = "Sala Biliardo";
		this.indizio = "La somma del primo e del secondo numero della combinazione è pari al quarto numero";
		this.indizioAcq = false;
		this.setCoords(1, 1, 1);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(barRegex)) {
			System.out.println("\nTante bottiglie anche qui: ci vanno a nozze con l'alcool da queste parti\n");
		}
		else if(comando.matches(biliardoRegex)) {
			System.out.println("\nE' il tavolo da biliardo, di certo non possiamo metterci a giocare ora\n");
		}
		else if(comando.matches(freccetteRegex)) {
			System.out.println("\nLe freccette sono belle ma non sembra che il bersaglio sia stato molto usato. "
							 + "Un biglietto è conficcato in una delle freccette\n");
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
		System.out.println("\nSei nel posto in cui il signor Alfieri si intrattiene con i suoi ospiti: c'è un tavolo da biliardo professionale e "
						 + "un bancone da bar con alcolici. C'è anche un bersaglio per le freccette!\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nDa questa parte c'è solo quel fantastico tavolo da biliardo: viene voglia si farsi una partita\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nNon ci sono vie da questo lato, c'è però il bersaglio per le freccette\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nIl bancone del bar domina la scena: sembra proprio che ad Altieri piaccia molto l'alcool\n");

	}

}
