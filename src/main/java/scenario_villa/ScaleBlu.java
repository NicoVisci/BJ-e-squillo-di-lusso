package scenario_villa;

import java.io.Serializable;

import core.Stanza;
import core.StanzaScale;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
@SuppressWarnings("serial")
class ScaleBlu extends Ambiente implements Stanza, StanzaScale, Serializable {
	
	private static String sopraRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(su|sopra|piano di sopra).*";
	private static String sottoRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(sotto|gi|piano di sotto).*";
	
	protected ScaleBlu() {
		this.nomeAmbiente = "Scale Blu (Piano terra)";
		this.setCoords(0, 0, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(sopraRegex)) {
			this.vaiSopra();
		}
		else if(comando.matches(sottoRegex)) {
			this.vaiSotto();
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
	public void vaiEst() {
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nSei nella tromba delle scale blu\n");

	}

	@Override
	public void vaiSopra() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY+1, (this.posizioneZ));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY+1][this.posizioneZ].getNomeAmbiente());
		
	}

	@Override
	public void vaiSotto() {
		System.out.println("\nSei all'ultimo piano di queste scale\n");
		
	}

}
