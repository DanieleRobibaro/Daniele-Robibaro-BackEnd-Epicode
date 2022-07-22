package it.epicode.progetto.settimana1.dati;

import it.epicode.progetto.settimana1.dati.interfacce.Riproducibile;

public class Video extends Multimediale implements Riproducibile {
	public int volume = 6;
	public int luminosita = 5;
	private int durata;

	public Video(String titolo, int durata) {
		super(titolo);
		this.durata = durata;

	}

	public int getVolume() {
		return volume;
	}

	public int getLuminosita() {
		return luminosita;
	}

	public int getDurata() {
		return durata;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}

	public void setDurata(int durata) {
		this.durata = durata;
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

	public void alzaVolume() {
		int v = getVolume();
		v++;
		setVolume(v);

	}

	public void abbassaVolume() {
		int v = getVolume();
		v--;
		setVolume(v);

	}

	@Override
	public void play() {
		for (int i = 0; i < getDurata(); i++) {
			String asterischi = "";
			for (int a = 0; a < getLuminosita(); a++) {
				asterischi += "*";
			}
			String esclamativi = "";
			for (int e = 0; e < getVolume(); e++) {
				esclamativi += "!";
			}
			System.out.println(getTitolo() + " " + asterischi + " " + esclamativi);
		}
	}

}
