package it.epicode.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import it.epicode.datamodels.Elementi;
import it.epicode.datamodels.Libri;
import it.epicode.datamodels.Riviste;

public class OperazioniService {
	private static final String FILE_PATH = "./CatalogoBibliotecario.txt";

	List<Elementi> elementi = new ArrayList<>();
	List<Libri> libri = new ArrayList<>();

	public void aggiungiElemento(Elementi elemento) {
		elementi.add(elemento);
	}

	public void rimozioneElementoPerISBN(String isbn) {
		List<Elementi> l = elementi.stream().filter(e -> e.getCodiceISBN().equals(isbn)).collect(Collectors.toList());
		l.remove(0);
	}

	public List<Elementi> ricercaPerISBN(String isbn) {

		return elementi.stream().filter(e -> e.getCodiceISBN().equals(isbn)).collect(Collectors.toList());
	}

	public List<Elementi> ricercaPerAnnoPublicazione(String anno) {
		return elementi.stream().filter(e -> e.getAnnoPublicazione().equals(anno)).collect(Collectors.toList());
	}

	public List<Elementi> ricercaPerAutore(String autore) {
		return elementi.stream().filter(e -> e instanceof Libri && ((Libri) e).getAutore().equals(autore))
				.collect(Collectors.toList());
	}

	public void salvataggioSuDisco() {

		String testo = "";
		for (Elementi e : elementi) {
			testo += e.toString();
		}
		File catalogo = new File(FILE_PATH);

		try {
			FileUtils.writeStringToFile(catalogo, testo, "UTF-8");
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	public void caricaDalDisco() {

		File catalogo = new File(FILE_PATH);

		String testo = "";
		try {
			testo = FileUtils.readFileToString(catalogo, "UTF-8");
		} catch (IOException e) {

			e.printStackTrace();

		}
		List<String> splitElementi = Arrays.asList(testo.split("@"));

		for (String c : splitElementi) {
			Elementi el = null;
			if (c.startsWith(Libri.class.getSimpleName())) {

				el = Libri.fromStringFile(c);
				;
			} else if (c.startsWith(Riviste.class.getSimpleName())) {

				el = Riviste.fromStringFile(c);
			}
			this.elementi.add(el);
		}
	}

	public void stampa() {
		elementi.stream().forEach(e -> System.out.println(e.toString()));

	}

}
