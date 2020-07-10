package scenario_villa;

import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings({ "serial" })
class AngoloBar extends Ambiente implements Stanza, Serializable{
	
	private String banconeRegex = "(guarda|analizza|esamina)\s+(il(\s+))?(bancone|bar|bancone antico).*";
	private String credenzaRegex = "(guarda|analizza|esamina)\s+((la|i|gli)(\s+))?(credenza|vini|alcolici|liquori|bottiglie).*";
	private String bottigliaRegex = "(guarda|analizza|esamina|prendi)\s+((la)(\s+))?(bottiglia|vino|alcolico|)\s.*";

	protected AngoloBar() {
		this.nomeAmbiente = "Angolo Bar";
		this.indizio = "Nella combinazione sono presenti 3 cifre divisori del numero 18";
		this.indizioAcq = false;
		this.setCoords(3, 0, 1);
	}
	
	@Override
	public void decodifica (String comando) {
		if(comando.matches(banconeRegex)) {
			System.out.println("\nIl bancone è composto da legni pregiati; alcuni bicchieri vuoti ancora giaciono sul piano"
							 + "ma non sembra esserci nulla di interessante\n");
		}
		else if(comando.matches(credenzaRegex)) {
			System.out.println("\nUna vera e propria collezzione dei liquori e vini più rari e pregiati del mondo, affiancati"
							 + "ai classici alcolici della vita mondana. Una bottiglia davvero speciale spicca al centro "
							 + "della credenza\n");
		}
		else if(comando.matches(bottigliaRegex)) {
			System.out.println("\nUna bottiglia di pregiato Barolo di riserva 1979; la maneggi con cura. "
							+  "Trovi un curioso biglietto sul fondo della bottiglia.\n");
			if(!this.indizioAcq) {
				this.acquireIndizio();
			}
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void vaiEst() {
		System.out.println("\nDavanti a te c'è una parete piena di bottiglie di ogni alcolico "
						 + "conosciuto ma non c'è alcun passaggio verso un'altra stanza");
	}

	@Override
	public void guarda() {
		System.out.println("\nSei in un'ampia stanza molto rustica con una credenza"
				         + " piena di alcolici che riempie la parete est, con un ampio bancone da bar antico davanti ad essa");
		
	}

}
