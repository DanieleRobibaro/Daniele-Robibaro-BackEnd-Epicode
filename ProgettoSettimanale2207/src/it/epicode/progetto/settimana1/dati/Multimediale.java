package it.epicode.progetto.settimana1.dati;

public abstract class Multimediale {
	private String titolo;

	public Multimediale(String titolo) {
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
