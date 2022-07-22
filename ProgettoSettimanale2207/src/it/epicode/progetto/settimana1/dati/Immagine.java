package it.epicode.progetto.settimana1.dati;

import it.epicode.progetto.settimana1.dati.interfacce.Visualizzabile;

public class Immagine extends Multimediale implements Visualizzabile {
	public int luminosita = 5;

	public Immagine(String titolo) {
		super(titolo);

	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int liminosita) {
		this.luminosita = liminosita;
	}

	public void aumentaLuminosita() {
		int l = getLuminosita();
		l++;
		setLuminosita(l);

	}

	public void diminuisciLuminosita() {
		int l = getLuminosita();
		l--;
		setLuminosita(l);

	}

	@Override
	public void show() {
		String asterischi = "";
		for (int i = 0; i < getLuminosita(); i++) {
			asterischi += "*";
		}

		System.out.println(getTitolo() + " " + asterischi);

	}

}
