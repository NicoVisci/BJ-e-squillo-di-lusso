package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
@SuppressWarnings("serial")
class SalaTrofei extends Ambiente implements Stanza, Serializable {
	
	private String trofeiRegex = ".*(guarda|analizza|esamina)(\\s)+((i|le)(\\s+))?(trofei|premi|coppe).*";
	private String caveauRegex = ".*(guarda|analizza|esamina)(\\s)+((la|il)(\\s+))?(porta del caveau|porta|caveau|portellone del caveau).*";
	private String combinazioneRegex = ".*(inserisci|prova|esamina)(\\s)+((la)(\\s+))?(combinazione)(\\s)(\\d{5})";
	private String trueCombRegex = "24968";
	
	protected SalaTrofei() {
		this.nomeAmbiente = "Sala Trofei";
		this.indizio = "Il primo numero della combinazione è 2";
		this.indizioAcq = false;
		this.setCoords(2, 1, 2);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(trofeiRegex)) {
			System.out.println("\nCi sono anche dei trofei di golf: ma davvero c'è gente che gioca a golf?\n");
		}
		else if(comando.matches(caveauRegex)) {
			System.out.println("\nLa porta del caveau è davvero un bel gioiellino tecnologico, ma con una combinazione da 5 numeri la aprirai. "
							 + "Ma... si sono dimenticati la prima cifra inserita!\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else if(comando.matches(combinazioneRegex)) {
			boolean found = false;
			String[] strip = comando.split("\\s");
			for (String string : strip) {
				string = string.trim();
				if(string.matches(trueCombRegex)) {
					found = true;
					System.out.println("\nFantastico! La porta del Caveau si apre e lo splendore del fantastico diamante delle Antille abbaglia i tuoi occhi. "
									 + "Ce l'hai fatta! Hai portato a termine il tuo incarico\n");
					AppMain.setGame(null);
				}
			}
			if(!found) {
				System.out.println("\nPurtroppo la combinazione non è quella giusta\n");
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nLa stanza è piena di trofei di sport e caccia, ma la scena viene rubata dall'immensa porta del Caveau della villa\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nL'immenso portellone del Caveau ti si staglia davanti\n");

	}

}
