package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraPadronaleNord extends Ambiente implements Stanza, Serializable {
	
	private String lettoRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(letto|riccardo|riccardo alfieri|alfieri|moglie).*";
	private String svegliaRegex = "((.*(sveglia|tocca|scuoti).*)|(.*(fai rumore).*))";
	
	protected CameraPadronaleNord() {
		this.nomeAmbiente = "Camera da letto padronale (Lato Nord)";
		this.setCoords(4, 1, 5);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(lettoRegex)) {
			System.out.println("\nE' il letto dove stanno dormendo i coniugi Alfieri. Fa attenzione a non svegliarli!\n");
		}
		else if(comando.matches(svegliaRegex)) {
			System.out.println("\nMa cosa fai! I coniugi Alfieri si sono svegliati ed hanno iniziato ad urlare! Sei stato scoperto!\n");
			AppMain.setGame(null);
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella camera da letto di Riccardo Alfieri: c'è un immenso letto a baldacchino dove i coniugi Alfieri stanno "
						 + "dormendo! Fai attenzione a non svegliarli!\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nC'è il letto da quella parte! Non ti avvicinare!\n");

	}

}
