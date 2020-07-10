package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.AppMain;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class StanzeServituOvest extends Ambiente implements Stanza, Serializable {
	
	private String svegliaRegex = ".*sveglia.*";
	
	protected StanzeServituOvest() {
		this.nomeAmbiente = "Stanze della Servitù (Lato Ovest)";
		this.setCoords(2, 0, 6);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(svegliaRegex)) {
			System.out.println("\nMa cosa fai! La servitù si è svegliata ed hanno iniziato ad urlare! Sei stato scoperto!\n");
			AppMain.setGame(null);
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nelle stanze private della servitù. Stanno dormendo! Non svegliarli|\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nNon ci sono porte da questo lato\n");

	}
	
	@Override
	public void vaiSud() {
		System.out.println("\nNon ci sono porte da questo lato\n");

	}
	
	@Override
	public void vaiOvest() {
		System.out.println("\nNon ci sono porte da questo lato\n");

	}

}
