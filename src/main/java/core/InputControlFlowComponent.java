package core;

/**
 * Interfaccia che descrive un oggetto di controllo facente parte della catena per il controllo dell'input utente
 * 
 * <p>Interfaccia di tipo Control	 
 * 
 * @author Nico Visci
*/

public interface InputControlFlowComponent {
	
	/**
	 * Questo metodo deve implementare il controllo della String comando fornita in input per passare il controllo dell'applicazione
	 * ad un specifico oggetto in caso di matching o in alternativa passare il controllo ad un metodo decodifica di un altro InputControlFlowComponent, 
	 * fornendo in input lo stesso parametro comando oppure un messaggio di errore.
	 * 
	 * @param comando comando fornito in input dall'utente, già ripulito da eventuali eccessi e pronto per il controllo
	 */
	public void decodifica(String comando);
	
}
