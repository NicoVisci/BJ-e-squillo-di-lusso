package scenario_villa;

import java.io.Serializable;

import core.Stanza;
import core.StanzaScale;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
@SuppressWarnings("serial")
class ScaleRosse extends Ambiente implements Stanza, StanzaScale, Serializable {
	
	private static String sopraRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(su|sopra|piano di sopra).*";
	private static String sottoRegex    = ".*(vai)(\\s)+(al|verso)?(\\s)?(sotto|gi|piano di sotto).*";
	
	protected ScaleRosse() {
		this.nomeAmbiente = "Scale rosse (Piano terra)";
		this.setCoords(3, 0, 3);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(sopraRegex)){
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
		System.out.println("\nSei nella tromba delle scale rosse\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nSei nella tromba delle scale rosse\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nSei nella tromba delle scale rosse\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nSei nella tromba delle scale rosse\n");

	}

	@Override
	public void vaiSopra() {
		AppMain.getGame().getPlayer().setCoords(this.posizioneX, this.posizioneY+1, (this.posizioneZ));
		System.out.println("Stai entrando in " + AppMain.getGame().getScenario().scenario[this.posizioneX][this.posizioneY+1][this.posizioneZ].getNomeAmbiente());
		
	}

	@Override
	public void vaiSotto() {
		System.out.println("\nNon puoi andare più in basso di così\n");
		
	}

}
