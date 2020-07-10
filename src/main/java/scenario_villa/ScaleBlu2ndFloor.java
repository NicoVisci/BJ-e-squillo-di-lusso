package scenario_villa;

import java.io.Serializable;

import core.Stanza;
import core.StanzaScale;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
@SuppressWarnings("serial")
class ScaleBlu2ndFloor extends Ambiente implements Stanza, StanzaScale, Serializable {
	
	private static String sopraRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(su|sopra|piano di sopra).*";
	private static String sottoRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(sotto|gi|piano di sotto).*";
	
	protected ScaleBlu2ndFloor() {
		this.nomeAmbiente = "Scale Blu (Primo Piano)";
		this.setCoords(0, 1, 6);
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
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiSopra() {
		System.out.println("\nSei all'ultimo piano\n");
		
	}

	@Override
	public void vaiSotto() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY-1, (this.posizioneZ));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY-1][this.posizioneZ].getNomeAmbiente());
		
	}

}
