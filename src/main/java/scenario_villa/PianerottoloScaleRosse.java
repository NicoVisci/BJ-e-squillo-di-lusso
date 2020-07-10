package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class PianerottoloScaleRosse extends Ambiente implements Stanza, Serializable {
	
	private String telefonoRegex = ".*(guarda|esamina|analizza)(\\s)+((il)(\\s+))?(telefono).*";
	
	protected PianerottoloScaleRosse() {
		this.nomeAmbiente = "Pianerottolo (Scale Rosse)";
		this.setCoords(2, 0, 3);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(telefonoRegex)) {
			System.out.println("\nE' un telefono ma non mi sembra il momento adatto per chiamare qualcuno\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nel pianerottolo delle scale rosse, le scale che portano alle stanze private degli Alfieri\n");
	}

	@Override
	public void vaiOvest() {
		System.out.println("\nEhi c'è un telefono qui\n");

	}

}
