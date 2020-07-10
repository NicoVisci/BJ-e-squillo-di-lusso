package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class SalaMeeting extends Ambiente implements Stanza, Serializable {
	
	private String schermoRegex = ".*(guarda|analizza|esamina|accendi)(\\s)+((lo)(\\s+))?(schermo).*";
	private String tavoloRegex = ".*(guarda|analizza|esamina)(\\s)+((il)(\\s+))?(tavolo).*";
	
	protected SalaMeeting() {
		this.nomeAmbiente = "Sala Meeting";
		this.setCoords(2, 1, 2);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(schermoRegex)) {
			System.out.println("\nUno schermo piatto gigante da 60 pollici, probabilmente usato per le videoconferenze, ma non vedo "
							 + "l'utilità che può avere per noi\n");
		}
		else if(comando.matches(tavoloRegex)) {
			System.out.println("\nNon vedo il motivo di analizzare un tavolo da riunione\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nSei nella sala riunioni del signor Alfieri, non c'è molto all'infuori di uno schermo e di un grande tavolo ovale\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nNon c'è alcun passaggio da questa parte: c'è solo lo schermo da 60 pollici\n");

	}

}
