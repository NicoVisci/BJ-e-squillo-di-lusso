package scenario_villa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import core.Scenario;
import core.Ambiente;
import core.AppMain;

/**
 * Questa classe è la classe entità principale dello scenario di partita VILLA. Contiene le caratteristiche e gli attributi dello scenario.
 * 
 * <p>Classe di tipo Entity	 
 * 
 * @author Nico Visci
*/
@SuppressWarnings({ "serial" })
public class ScenarioVilla extends Scenario implements Serializable {
	
	protected static ArrayList<String> listaIndizi = new ArrayList<String>(Arrays.asList(
											    "Nella combinazione sono presenti 3 divisori del numero 18", 
			                                    "La somma del primo e dell'ultimo numero della combinazione è uguale alla somma del secondo e del quarto numero",
			                                    "L'ultimo numero della combinazione è 8",
			                                    "Il terzo e il quarto numero della combinazione hanno un divisore in comune",
			                                    "Il secondo numero della combinazione è esattamente la metà del quinto numero",
			                                    "Il primo numero della combinazione è esattamente la metà del secondo numero",
			                                    "Il primo numero della combinazione è 2",
			                                    "Il quarto numero della combinazione è i 2/3 del terzo numero",
			                                    "La somma del primo e del secondo numero della combinazione è pari al quarto numero",
			                                    "Il numero centrale della combinazione è un quadrato perfetto"	
			                                    ));
	
	@Override
	public void attivaCamere() {
		this.scenario[0][0][0].setControllore(true);    //Ingresso principale
		this.scenario[2][0][0].setControllore(true);    //Ingresso veranda
		this.scenario[0][0][5].setControllore(true);    //Ingresso laterale
		this.scenario[4][0][3].setControllore(true);	//Giardino Nord
		this.scenario[2][0][3].setControllore(true);	//Pianerottolo scale rosse
		
		this.scenario[0][1][0].setControllore(true);	//Corridoio libri sud
		this.scenario[0][1][3].setControllore(true);	//Corridoio piante nord
		this.scenario[2][1][2].setControllore(true);	//Sala trofei
		this.scenario[1][1][6].setControllore(true);	//Sala relax
	}
	
	@Override
	public void disattivaCamere() {
		this.scenario[0][0][0].setControllore(false);    //Ingresso principale
		this.scenario[2][0][0].setControllore(false);    //Ingresso veranda
		this.scenario[0][0][5].setControllore(false);    //Ingresso laterale
		this.scenario[4][0][3].setControllore(false);	//Giardino Nord
		this.scenario[2][0][3].setControllore(false);	//Pianerottolo scale rosse
		
		this.scenario[0][1][0].setControllore(false);	//Corridoio libri sud
		this.scenario[0][1][3].setControllore(false);	//Corridoio piante nord
		this.scenario[2][1][2].setControllore(false);	//Sala trofei
		this.scenario[1][1][6].setControllore(false);	//Sala relax
	}
	
	@Override
	public void playerStarting() {
		//Inizio dal bagno degli Ospiti
		AppMain.getGame().getPlayer().setCoords(0, 0, 4);
	}
	
	public ScenarioVilla()	{
		
		this.maxCordX = 5;
		this.maxCordY = 2;
		this.maxCordZ = 7;
		
		//Piano Terra
		
		this.scenario = new Ambiente[this.maxCordX][this.maxCordY][this.maxCordZ];
		
		this.scenario[0][0][0] = new IngressoPrincipale();
		this.scenario[1][0][0] = new ScalePrincipali();
		this.scenario[2][0][0] = new IngressoVeranda();
		this.scenario[3][0][0] = new VerandaOvest();
		this.scenario[4][0][0] = new VerandaEst();
		this.scenario[0][0][1] = new Biblioteca();
		this.scenario[1][0][1] = new StudioArianna();
		this.scenario[2][0][1] = new CorridoioQuadriSud();
		this.scenario[3][0][1] = new AngoloBar();
		this.scenario[4][0][1] = new VerandaNord();
		this.scenario[0][0][2] = new StudioContabile();
		this.scenario[1][0][2] = new PiccoloCaveau();
		this.scenario[2][0][2] = new CorridoioQuadriNord();
		this.scenario[3][0][2] = new SalaMusica();
		this.scenario[4][0][2] = new GiardinoSud();
		this.scenario[0][0][3] = new SalottoOspiti();
		this.scenario[1][0][3] = new SoggiornoSud();
		this.scenario[2][0][3] = new PianerottoloScaleRosse();
		this.scenario[3][0][3] = new ScaleRosse();
		this.scenario[4][0][3] = new GiardinoNord();
		this.scenario[0][0][4] = new BagnoOspiti();
		this.scenario[1][0][4] = new SoggiornoNord();
		this.scenario[2][0][4] = new CorridoioFioriSud();
		this.scenario[3][0][4] = new SalaPranzoOvest();
		this.scenario[4][0][4] = new SalaPranzoEst();
		this.scenario[0][0][5] = new IngressoLaterale();
		this.scenario[1][0][5] = new CorridoioFioriOvest();
		this.scenario[2][0][5] = new CorridoioFioriNord();
		this.scenario[3][0][5] = new Cucina();
		this.scenario[4][0][5] = new Dispensa();
		this.scenario[0][0][6] = new ScaleBlu();
		this.scenario[1][0][6] = new StanzaTelecamere();
		this.scenario[2][0][6] = new StanzeServituOvest();
		this.scenario[3][0][6] = new StanzeServituEst();
		this.scenario[4][0][6] = new BagnoServitu();
		
		//Secondo Piano
		
		this.scenario[0][1][0] = new CorridoioLibriSud();
		this.scenario[1][1][0] = new ScalePrincipali2ndFloor();
		this.scenario[2][1][0] = new StudioRiccardo();
		this.scenario[3][1][0] = new AmbienteVuoto();
		this.scenario[4][1][0] = new AmbienteVuoto();
		this.scenario[0][1][1] = new CorridoioLibriNord();
		this.scenario[1][1][1] = new SalaBiliardo();
		this.scenario[2][1][1] = new SalaMeeting();
		this.scenario[3][1][1] = new BalconeSud();
		this.scenario[4][1][1] = new AmbienteVuoto();
		this.scenario[0][1][2] = new CorridoioPianteSud();
		this.scenario[1][1][2] = new CaveauPrincipale();
		this.scenario[2][1][2] = new SalaTrofei();
		this.scenario[3][1][2] = new BalconeNord();
		this.scenario[4][1][2] = new AmbienteVuoto();
		this.scenario[0][1][3] = new CorridoioPianteNord();
		this.scenario[1][1][3] = new CorridoioPianteEst();
		this.scenario[2][1][3] = new Salottino();
		this.scenario[3][1][3] = new ScaleRosse2ndFloor();
		this.scenario[4][1][3] = new AmbienteVuoto();
		this.scenario[0][1][4] = new CameraOspiti();
		this.scenario[1][1][4] = new CameraAriannaSud();
		this.scenario[2][1][4] = new Anticamera();
		this.scenario[3][1][4] = new CameraPadronaleSud();
		this.scenario[4][1][4] = new CameraPadronaleEst();
		this.scenario[0][1][5] = new BagnoOspiti2ndFloor();
		this.scenario[1][1][5] = new CameraAriannaNord();
		this.scenario[2][1][5] = new DressingRoom();
		this.scenario[3][1][5] = new CameraPadronaleOvest();
		this.scenario[4][1][5] = new CameraPadronaleNord();
		this.scenario[0][1][6] = new ScaleBlu2ndFloor();
		this.scenario[1][1][6] = new SalaRelax();
		this.scenario[2][1][6] = new BagnoPadronaleOvest();
		this.scenario[3][1][6] = new BagnoPadronaleEst();
		this.scenario[4][1][6] = new CabinaArmadio();
		
		this.attivaCamere();
		
	}
	
	@Override
	public void introScenario()	{
	   System.out.println("Ok, adesso eccoti un debriefing della situazione\n"
						+ "Ti stai per introdurre nella villa di un noto imprenditore, Riccardo Alfieri\n"
						+ "Da molti conosciuto perchè attuale capostipite di una famosa famiglia di imprenditori\n"
						+ "Quello che a noi interessa però è il suo Caveau all'interno della villa\n"
						+ "Un vero incubo per gli scassinatori ma la fortuna ci viene incontro\n"
						+ "La combinazione è custodita dalla famiglia Alfieri come un indovinello\n"
						+ "Una nostra complice ci ha confermato che i vari pezzi di questo indovinello sono nascosti all'interno della casa,\n"
						+ "sotto forma di indizi\n"
						+ "Il tuo obbiettivo primario sarà raccogliere quanti più indizi possibili e decifrare la combinazione a 5 cifre\n"
						+ "Ma una volta aperto il caveau, avrai tra le mani il famoso Diamante delle Antille dal valore di 5 MILIONI DI EURO!\n\n"
						+ "Ovviamente sappiamo anche come introdurti:\n"
						+ "i sensori delle finestre dei bagni hanno dei problemi e non sono funzionanti;\n"
						+ "Ti introdurrai quindi da uno dei bagni della villa, il bagno degli ospiti al piano Terra\n"
						+ "Una volta dentro inizia la parte difficile: per tutta la villa ci sono troppe telecamere; "
						+ "C'è una stanza dedicata al controllo delle telecamere ma c'è sempre un uomo fidato all'interno: "
						+ "forse possiamo trovare una maniera per farlo uscire di lì e disattivarle.\n"
						+ "Stai molto attento a non svegliare gli inquilini e la servitù della villa: in quel caso la tua missione "
						+ "sarà dichiarata decisamente fallita.\n"
						+ "Ricorda: durante l'impresa non sarò in collegamento con te. Buona fortuna\n");
	}

}
