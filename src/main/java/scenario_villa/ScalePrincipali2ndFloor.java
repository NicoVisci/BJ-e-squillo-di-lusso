package scenario_villa;

import java.io.Serializable;

import core.Stanza;
import core.StanzaScale;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
@SuppressWarnings("serial")
class ScalePrincipali2ndFloor extends Ambiente implements Stanza, StanzaScale, Serializable {
	
	private static String sopraRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(su|sopra|piano di sopra).*";
	private static String sottoRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(sotto|gi|piano di sotto).*";
	
	protected void ScalePrincipali() {
		this.nomeAmbiente = "Scale Principali (Primo Piano)";
		this.setCoords(1, 1, 0);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(sottoRegex)) {
			this.vaiSotto();
		}
		else if(comando.matches(sopraRegex)) {
			this.vaiSopra();
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella tromba delle scale principali\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nSei nella tromba delle scale principali\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nSei nella tromba delle scale principali\n");

	}
	
	@Override
	public void vaiSopra() {
		System.out.println("\nSei all'ultimo piano di questa tromba di scale\n");
		
	}

	@Override
	public void vaiSotto() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY-1, (this.posizioneZ));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY-1][this.posizioneZ].getNomeAmbiente());
		
	}

}
