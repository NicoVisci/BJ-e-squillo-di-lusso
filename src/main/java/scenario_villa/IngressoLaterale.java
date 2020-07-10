package scenario_villa;
import java.io.Serializable;
import core.Ambiente;
import core.CoreInputControl;
import core.Stanza;

@SuppressWarnings("serial")
class IngressoLaterale extends Ambiente implements Stanza, Serializable {
	
	public IngressoLaterale() {
		this.nomeAmbiente = "Ingresso Laterale";
		this.setCoords(0, 0, 5);
	}

	@Override
	public void decodifica(String comando) {
			CoreInputControl.getInstance().mancatoMatch();

	}

	@Override
	public void guarda() {
		System.out.println("\nSei finito nell'ingresso laterale di servizio, usato dagli inservienti\n");

	}

	@Override
	public void vaiOvest() {
		System.out.println("\nDa questo lato c'è una porta che da sull'esterno, ma di certo non c'è motivo di uscire dalla villa\n");

	}

}
