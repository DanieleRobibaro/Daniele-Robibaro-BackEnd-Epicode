package it.epicode.progetto.settimana1;

import java.util.Scanner;

import it.epicode.progetto.settimana1.dati.Audio;
import it.epicode.progetto.settimana1.dati.Immagine;
import it.epicode.progetto.settimana1.dati.Multimediale;
import it.epicode.progetto.settimana1.dati.Video;
import it.epicode.progetto.settimana1.dati.interfacce.Riproducibile;
import it.epicode.progetto.settimana1.dati.interfacce.Visualizzabile;

public class Program {

	public static void main(String[] args) {
		String titolo;
		int durata;
		int tipologia;

		Scanner scanner = new Scanner(System.in);
		Multimediale[] multi = new Multimediale[5];
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			while (flag) {
				System.out.println("Che tipologia di file multimediale vuoi inserire? (1 Immagine 2 Audio 3 Video)");
				System.out.println("Hai inserito " + i + " file multimediali.");
				tipologia = scanner.nextInt();
				scanner.nextLine();
				switch (tipologia) {

				case 1:
					System.out.println("Inserire titolo immagine.");
					titolo = scanner.nextLine();
					multi[i] = new Immagine(titolo);
					flag = false;
					break;
				case 2:
					System.out.println("Inserire titolo Audio. ");
					titolo = scanner.nextLine();
					System.out.println("Inserire durata Audio " + titolo + ".");
					durata = scanner.nextInt();
					scanner.nextLine();
					multi[i] = new Audio(titolo, durata);
					flag = false;
					break;
				case 3:
					System.out.println("Inserire titolo Video. ");
					titolo = scanner.nextLine();
					System.out.println("Inserire durata Video " + titolo + ".");
					durata = scanner.nextInt();
					scanner.nextLine();
					multi[i] = new Video(titolo, durata);
					flag = false;
					break;
				default:
					System.out.println("Selezione errata!");
					break;
				}
			}
		}

		int scelta = 0;
		while (true) {

			System.out.println("Scegli un elemento multimediale da 1-5. Inserisci 0 per uscire!");
			System.out.println("=============");
			System.out.println("    MENU   ");
			for (int i = 0; i < 5; i++) {

				System.out.println((i + 1) + ")" + multi[i].getTitolo());
			}

			System.out.println("=============");

			scelta = scanner.nextInt();
			scanner.nextLine();
			if (scelta == 0) {
				System.out.println("Arrivederci");
				break;
			}

			start(multi[scelta - 1]);
			System.out.println("Vuoi modificare qualcosa del file multimediale? [Y/N]");
			String choice = scanner.nextLine();
			if (choice.equals("Y")) {
				if (multi[scelta - 1] instanceof Immagine) {
					System.out.println("Vuoi aumentare la luminosità? [Y/N]");
					choice = scanner.nextLine();
					if (choice.equals("Y")) {
						((Immagine) multi[scelta - 1]).aumentaLuminosita();
						System.out.println("Hai aumentato la luminosità di 1");
					} else {
						System.out.println("Vuoi abbasare la luminosità? [Y/N]");
						choice = scanner.nextLine();
						if (choice.equals("Y")) {
							((Immagine) multi[scelta - 1]).diminuisciLuminosita();
							System.out.println("Hai abbasare la luminosità di 1");
						}
					}
				} else if (multi[scelta - 1] instanceof Video) {
					boolean flagg = true;
					int num;
					while (flagg) {
						System.out.println("Cose vuoi modificare? (1 volume 2 luminosità)");
						num = scanner.nextInt();
						scanner.nextLine();
						switch (num) {

						case 1:
							System.out.println("Vuoi aumentare il volume? [Y/N]");
							choice = scanner.nextLine();
							if (choice.equals("Y")) {
								((Video) multi[scelta - 1]).alzaVolume();
								System.out.println("Hai aumentato il volume di 1");
							} else {
								System.out.println("Vuoi abbasare il volume? [Y/N]");
								choice = scanner.nextLine();
								if (choice.equals("Y")) {
									((Video) multi[scelta - 1]).abbassaVolume();
									System.out.println("Hai abbasare il volume di 1");
								}
							}
							flagg=false;
							break;
						case 2:
							System.out.println("Vuoi aumentare la luminosità? [Y/N]");
							choice = scanner.nextLine();
							if (choice.equals("Y")) {
								((Video) multi[scelta - 1]).aumentaLuminosita();
								System.out.println("Hai aumentato la luminosità di 1");
							} else {
								System.out.println("Vuoi abbasare la luminosità? [Y/N]");
								choice = scanner.nextLine();
								if (choice.equals("Y")) {
									((Video) multi[scelta - 1]).diminuisciLuminosita();
									System.out.println("Hai abbasare la luminosità di 1");
								}
							}
							flagg=false;
							break;
						default:
							System.out.println("Selezione errata! ");
							break;
						}
					}
				} else if (multi[scelta - 1] instanceof Audio) {
					System.out.println("Vuoi aumentare il volume? [Y/N]");
					choice = scanner.nextLine();
					if (choice.equals("Y")) {
						((Audio) multi[scelta - 1]).alzaVolume();
						System.out.println("Hai aumentato il volume di 1");
					} else {
						System.out.println("Vuoi abbasare il volume? [Y/N]");
						choice = scanner.nextLine();
						if (choice.equals("Y")) {
							((Audio) multi[scelta - 1]).abbassaVolume();
							System.out.println("Hai abbasare il volume di 1");
						}
					}
				}
			}

		}
	}

	public static void start(Multimediale m) {
		if (m instanceof Visualizzabile) {
			((Visualizzabile) m).show();
		} else if (m instanceof Riproducibile) {
			((Riproducibile) m).play();
		}

	}

}
