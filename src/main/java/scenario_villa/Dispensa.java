package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class Dispensa extends Ambiente implements Stanza, Serializable {
	
	private String scaffaliRegex = "(guarda|analizza|esamina)\\s+((gli|le|la|lo)(\\s+))?(scaffali|provviste|scaffale|robe|roba)\\s?.*";
	private String velenoRegex = "(guarda|analizza|esamina|prendi)\\s+((il)(\\s+))?(veleno|veleno per topi)\\s?.*";
	
	final String veleno = "Veleno per topi";
	
	protected Dispensa() {
		this.inventario.add(veleno);
		this.nomeAmbiente = "Dispensa";
		this.posizioneX = 4;
		this.posizioneY = 0;
		this.posizioneZ = 5;
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(scaffaliRegex)) {
			System.out.println("\nLa stanza è gremita dagli scaffali, pieni di roba, ma una scatoletta attrae la tua attenzione: è veleno per topi\n");
		}
		else if(comando.matches(velenoRegex)) {
			System.out.println("\nIl veleno per topi provoca effetti indesiderati al malcapitato che lo ingerisce. "
							 + "Ne prendi un po': può sempre essere utile\n");
			this.acquireOggetto(this.getOggettoFromInventario(veleno));
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nUn'ambiente pieno di provviste ammassate su degli scaffali posti su ogni parete\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nUn immenso scaffale pieno di roba è appoggiato alla parete: "
						 + "forse potresti trovarci qualcosa di interessante\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nUn immenso scaffale pieno di roba è appoggiato alla parete: "
						 + "forse potresti trovarci qualcosa di interessante\n");
	}

	@Override
	public void vaiSud() {
		System.out.println("\nUn immenso scaffale pieno di roba è appoggiato alla parete: "
				 		 + "forse potresti trovarci qualcosa di interessante\n");
	}

}
