package it.epicode;

import it.epicode.datamodels.Libri;
import it.epicode.datamodels.Periodicità;
import it.epicode.datamodels.Riviste;
import it.epicode.service.OperazioniService;

public class Program {

	static OperazioniService service = new OperazioniService();

	public static OperazioniService popolamentoDati() {

		Libri primoLibro = new Libri("9876543210482", "Libro1", "2022", 126, "Autore1", "Genere1");
		Libri secondoLibro = new Libri("9378920462784", "Libro2", "2021", 221, "Autore2", "Genere2");
		Libri terzoLibro = new Libri("7365014962315", "Libro3", "2020", 173, "Autore3", "Genere3");
		Libri quartoLibro = new Libri("2849164518900", "Libro4", "2019", 225, "Autore4", "Genere4");
		Libri quintoLibro = new Libri("2674892554122", "Libro5", "2018", 105, "Autore5", "Genere5");

		Riviste primaRivista = new Riviste("8902637846111", "Rivista1", "2022", 18, Periodicità.SETTIMANALE);
		Riviste secondaRivista = new Riviste("009368728194", "Rivista2", "2021", 28, Periodicità.MENSILE);
		Riviste terzaRivista = new Riviste("6637285201774", "Rivista3", "2020", 53, Periodicità.SEMESTRALE);
		Riviste quartaRivista = new Riviste("7283366499051", "Rivista4", "2019", 30, Periodicità.SETTIMANALE);
		Riviste quintaRivista = new Riviste("2552266784915", "Rivista5", "2018", 22, Periodicità.MENSILE);
		Riviste sestaRivista = new Riviste("3389025537110", "Rivista6", "2017", 60, Periodicità.SEMESTRALE);

		service.aggiungiElemento(primoLibro);
		service.aggiungiElemento(secondoLibro);
		service.aggiungiElemento(terzoLibro);
		service.aggiungiElemento(quartoLibro);
		service.aggiungiElemento(quintoLibro);

		service.aggiungiElemento(primaRivista);
		service.aggiungiElemento(secondaRivista);
		service.aggiungiElemento(terzaRivista);
		service.aggiungiElemento(quartaRivista);
		service.aggiungiElemento(quintaRivista);
		service.aggiungiElemento(sestaRivista);

		return service;

	}

	public static void ricercaPerISBN(String isbn) {
		service.ricercaPerISBN(isbn).stream().forEach(e -> System.out.println(e.toString()));

	}

	public static void ricercaPerAnno(String anno) {
		service.ricercaPerAnnoPublicazione(anno).stream().forEach(e -> System.out.println(e.toString()));

	}

	public static void ricercaPerAutore(String autore) {
		service.ricercaPerAutore(autore).stream().forEach(e -> System.out.println(e.toString()));

	}

	public static void main(String[] args) {
		popolamentoDati();
		service.stampa();
		System.out.println("-------Ricerca per Codice ISBN-----------");
		ricercaPerISBN("2552266784915");
		System.out.println("-------Ricerca per Autore-----------");
		ricercaPerAutore("Autore5");
		System.out.println("--------Ricerca per Anno di Publicazione----------");
		ricercaPerAnno("2021");
		service.salvataggioSuDisco();
		service.caricaDalDisco();
	}

}
