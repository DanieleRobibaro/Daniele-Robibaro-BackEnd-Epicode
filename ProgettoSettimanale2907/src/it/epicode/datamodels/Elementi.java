package it.epicode.datamodels;

public abstract class Elementi {

	protected String codiceISBN;
	protected String titolo;
	protected String annoPublicazione;
	protected int nPagine;

	public Elementi(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.nPagine = nPagine;
	}

	public Elementi() {
		super();
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAnnoPublicazione() {
		return annoPublicazione;
	}

	public int getnPagine() {
		return nPagine;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAnnoPublicazione(String annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public void setnPagine(int nPagine) {
		this.nPagine = nPagine;
	}

}
