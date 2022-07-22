package it.epicode.progetto.settimana1.dati;

import it.epicode.progetto.settimana1.dati.interfacce.Riproducibile;

public class Audio extends Multimediale implements Riproducibile {
	private int durata;
	private int volume = 3;

	public Audio(String titolo, int durata) {
		super(titolo);
		this.durata = durata;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
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
			String esclamativi = "";
			for (int e = 0; e < getVolume(); e++) {
				esclamativi += "!";
			}
			System.out.println(getTitolo() + " " + esclamativi);
		}
	}

}
