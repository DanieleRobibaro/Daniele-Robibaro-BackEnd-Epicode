package it.epicode;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.CatalogoDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.entities.library.Elemento;
import it.epicode.entities.library.Libro;
import it.epicode.entities.library.Periodicità;
import it.epicode.entities.library.Rivista;
import it.epicode.entities.prestito.Prestito;
import it.epicode.entities.prestito.Utente;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void popolazione() {
		Elemento elemento1 = new Libro("987-543-104-2", "il Libro dei libri", "2022", 126, "Autore1", "Genere1");
		Elemento elemento2 = new Rivista("009-687-819-4", "Rivista2", "2021", 28, Periodicità.MENSILE);
		Elemento elemento3 = new Libro("736-014-623-5", "Libro3", "2020", 173, "Autore3", "Genere3");
		Elemento elemento4 = new Rivista("728-366-990-1", "Rivista4", "2019", 30, Periodicità.SETTIMANALE);
		Elemento elemento5 = new Libro("267-892-541-2", "Libro5", "2018", 105, "Autore5", "Genere5");

		var ServiceCatalogo = new CatalogoDAO();

		ServiceCatalogo.aggiungiElemento(elemento1);
		ServiceCatalogo.aggiungiElemento(elemento2);
		ServiceCatalogo.aggiungiElemento(elemento3);
		ServiceCatalogo.aggiungiElemento(elemento4);
		ServiceCatalogo.aggiungiElemento(elemento5);

		Utente utente1 = new Utente("nome1", "cognome1", LocalDate.of(1985, 1, 19), 3266732);
		Utente utente2 = new Utente("nome2", "cognome2", LocalDate.of(1990, 8, 3), 3266732);
		Utente utente3 = new Utente("nome3", "cognome3", LocalDate.of(1999, 12, 21), 3266732);

		Prestito prestito1 = new Prestito(utente1, elemento1, LocalDate.now());
		Prestito prestito2 = new Prestito(utente1, elemento3, LocalDate.of(2000, 5, 21));
		Prestito prestito3 = new Prestito(utente1, elemento2, LocalDate.of(2011, 5, 21), LocalDate.of(2011, 5, 25));

		var ServicePrestito = new PrestitoDAO();

		ServicePrestito.aggiungiUnUtente(utente1);
		ServicePrestito.aggiungiUnUtente(utente2);
		ServicePrestito.aggiungiUnUtente(utente3);
		ServicePrestito.aggiungiUnPrestito(prestito1);
		ServicePrestito.aggiungiUnPrestito(prestito2);
		ServicePrestito.aggiungiUnPrestito(prestito3);

	}

	public static void main(String[] args) {

		popolazione();

		var ServiceCatalogo = new CatalogoDAO();
		var ServicePrestito = new PrestitoDAO();
		
		ServiceCatalogo.rimuoviElemento("267-892-541-2");

		log.info("-----RICERCA PER ISBN-----");
		Elemento el = ServiceCatalogo.ricercaPerISBN("987-543-104-2");
		log.info("{}", el);

		log.info("-----RICERCA PER ANNO-----");
		List<Elemento> lista1 = ServiceCatalogo.ricercaPerAnno("2019");
		for (Elemento e : lista1) {
			log.info("{}", e);
		}

		log.info("-----RICERCA PER AUTORE-----");
		List<Libro> lista2 = ServiceCatalogo.ricercaPerAutore("Autore3");
		for (Libro e : lista2) {
			log.info("{}", e);
		}

		log.info("-----RICERCA PER TITOLO-----");
		List<Elemento> lista3 = ServiceCatalogo.ricercaPerTitolo("dei");
		for (Elemento e : lista3) {
			log.info("{}", e);
		}

		log.info("-----RICERCA PRESTITO PER N TESSERA-----");
		List<Prestito> listaP1 = ServicePrestito.ricercaPrestitoPerNTessera(3266732);
		for (Prestito p : listaP1) {
			log.info("{}", p);
		}

		log.info("-----RICERCA PRESTITI SCADUTI E NON RESTITUITI-----");
		List<Prestito> listaP2 = ServicePrestito.ricercaPrestitiScadutiNonRestituiti();
		for (Prestito p : listaP2) {
			log.info("{}", p);
		}
	}
}
