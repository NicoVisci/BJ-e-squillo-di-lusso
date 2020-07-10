package core;

/**
 * Interfaccia che devono implementare quegli ambienti che permettono al giocatore di passare ad un piano differente dello scenario
 * 
 * <p>Classe di tipo Control	 
 * 
 * @author Nico Visci
*/

public interface StanzaScale {
	
	/**
	 * Questo metodo deve implementare lo spostamento verso un piano superiore o in alternativa un messaggio di errore
	 */
	public void vaiSopra();
	
	/**
	 * Questo metodo deve implementare lo spostamento verso un piano inferiore o in alternativa un messaggio di errore
	 */
	public void vaiSotto();
}
