package scenario_villa;
import java.io.Serializable;

import core.Stanza;
import core.Ambiente;
import core.CoreInputControl;

@SuppressWarnings("serial")
class SalaMusica extends Ambiente implements Stanza, Serializable {
	
	private String grammofonoRegex = ".*(guarda|analizza|esamina)(\\s)+((il)(\\s+))?(grammofono).*";
	private String pianoforteRegex = ".*(guarda|analizza|esamina|suona)(\\s)+((il)(\\s+))?(pianoforte).*";
	private String strumentiRegex = ".*(guarda|analizza|esamina|suona)(\\s)+((gli)(\\s+))?(strumenti).*";
	
	protected SalaMusica() {
		this.nomeAmbiente = "Sala Musica";
		this.setCoords(3, 0, 2);
	}

	@Override
	public void decodifica(String comando) {
		if(comando.matches(pianoforteRegex)) {
			System.out.println("\nIl pianoforte è davvero bello ma non vorrai metterti a suonare proprio ora, sveglierai qualcuno\n");
		}
		else if(comando.matches(grammofonoRegex)) {
			System.out.println("\nMi domando a che serve un grammofono se oramai tutti ascoltano musica commerciale su Spotify\n");
		}
		else if(comando.matches(strumentiRegex)) {
			System.out.println("\nLascia perdere, tanto lo sappiamo che non sai suonare\n");
		}
		else {
			CoreInputControl.getInstance().mancatoMatch();
		}

	}

	@Override
	public void guarda() {
		System.out.println("\nLa sala della musica è davvero splendida: c'è un pianoforte e persino un grammofono\n");

	}

	@Override
	public void vaiNord() {
		System.out.println("\nQuesto lato della stanza è pieno di strumenti musicali ma non ci sono porte\n");

	}

	@Override
	public void vaiEst() {
		System.out.println("\nIl pianoforte è appoggiato alla parete e ti suggerisce che non ci sono vie da questo lato\n");

	}

}
