 package scenario_villa;
import java.io.Serializable;

import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class CameraAriannaNord extends Ambiente implements Stanza, Serializable {
	
	private String lettoRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(letto|arianna).*";
	private String svegliaRegex = "((.*(sveglia|tocca|scuoti).*)|(.*(fai rumore).*))";
	
	protected CameraAriannaNord() {
		this.nomeAmbiente = "Camera di Arianna (Lato Nord)";
		this.setCoords(1, 1, 5);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(lettoRegex)) {
			System.out.println("\nArianna sta dormendo in quel letto! Attento a non svegliarla!\n");
		}
		else if(comando.matches(svegliaRegex)) {
			System.out.println("\nMa cosa fai! Arianna si è svegliata ed ha iniziato ad urlare! Sei stato scoperto!\n");
			AppMain.setGame(null);
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella camera da letto di Arianna, la figlia di Alfieri. Sta dormendo! Fai attenzione a non svegliarla!\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa quella parte c'è il letto dove dorme Arianna. Fai attenzione a non svegliarla!\n");

	}

}
