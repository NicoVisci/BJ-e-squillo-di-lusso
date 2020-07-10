package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class DressingRoom extends Ambiente implements Stanza, Serializable {

	private String vestitiRegex = ".*(guarda|esamina|analizza)(\\s)+((i|gli|l'|la)(\\s+))?(vestiti|abiti|armadio|cabina armadio).*";
	
	protected DressingRoom() {
		this.nomeAmbiente = "Dressing Room";
		this.setCoords(2, 1, 5);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(vestitiRegex)) {
			System.out.println("\nDavvero mi chiedo: qualcuno avrà mai indossato tutti questi vestiti?\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nella Dressing Room di Arianna Alfieri\n");
	}

	@Override
	public void vaiNord() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

	@Override
	public void vaiSud() {
		System.out.println("\nVestiti! Vestiti! Ci sono vestiti ovunque!\n");

	}

}
