import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Bibliomarket {
    public static void main(String[] args) {
        String titolo, autore, temp, email, nome, inizioStr, fineStr;
        int scelta = 0, tipologia, id, quantita, opzioneReport;
        double prezzo, totale;
        GestoreLibreria libreria = new GestoreLibreria();
        GestoreVendite gestoreVendite = new GestoreVendite();
        GestoreClienti gestoreClienti = new GestoreClienti();
        Scanner userInput = new Scanner(System.in);

        System.out.println("***************************************");
        System.out.println("*      Benvenuto in Bibliomarket      *");
        System.out.println("***************************************");

        do {
            System.out.println("\n---------------------------------------");
            System.out.println("|          Menu Principale            |");
            System.out.println("---------------------------------------");
            System.out.println("| 1. Aggiungi materiale               |");
            System.out.println("| 2. Rimuovi materiale per ID         |");
            System.out.println("| 3. Cerca materiale per titolo       |");
            System.out.println("| 4. Visualizza tutti i Materiali     |");
            System.out.println("| 5. Visualizza statistiche materiali |");
            System.out.println("| 6. Gestisci Vendite                 |");
            System.out.println("| 7. Aggiungi Cliente                 |");
            System.out.println("| 8. Visualizza Report Vendite        |");
            System.out.println("| 9. Visualizza tutti i Clienti       |");
            System.out.println("|10. Verifica disponibilità materiale |");
            System.out.println("| 0. Esci dal programma               |");
            System.out.println("---------------------------------------");
            System.out.print("Scegli un'opzione: ");

            try {
                scelta = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserisci un numero valido!");
                continue;
            }

            switch (scelta) {
                case 1 -> {
                    System.out.println("\n--- Aggiungi Materiale ---");
                    System.out.print("Inserisci il titolo: ");
                    titolo = userInput.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    autore = userInput.nextLine();
                    System.out.print("Inserisci il prezzo: ");
                    prezzo = userInput.nextDouble();
                    userInput.nextLine();
                    System.out.print("Inserisci la quantità: ");
                    quantita = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Tipologia del materiale:");
                    System.out.println("1. Libro");
                    System.out.println("2. Rivista");
                    System.out.println("3. DVD");
                    System.out.print("Scegli una tipologia: ");

                    try {
                        tipologia = Integer.parseInt(userInput.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserisci un numero valido!");
                        continue;
                    }

                    switch (tipologia) {
                        case 1 -> {
                            System.out.print("Inserisci il genere del libro: ");
                            temp = userInput.nextLine();
                            Libro l = new Libro(titolo, autore, temp, prezzo, quantita);
                            libreria.aggiungiMateriale(l);
                            System.out.println("Libro aggiunto con successo!");
                        }
                        case 2 -> {
                            System.out.print("Inserisci il formato della rivista: ");
                            temp = userInput.nextLine();
                            Rivista r = new Rivista(titolo, autore, temp, prezzo, quantita);
                            libreria.aggiungiMateriale(r);
                            System.out.println("Rivista aggiunta con successo!");
                        }
                        case 3 -> {
                            System.out.print("Inserisci la durata del DVD: ");
                            temp = userInput.nextLine();
                            Dvd d = new Dvd(titolo, autore, temp, prezzo, quantita);
                            libreria.aggiungiMateriale(d);
                            System.out.println("DVD aggiunto con successo!");
                        }
                        default -> System.out.println("Errore: Tipologia non valida.");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Rimuovi Materiale per ID ---");
                    System.out.print("Inserisci l'ID del materiale da rimuovere: ");
                    id = Integer.parseInt(userInput.nextLine());
                    libreria.rimuoviMaterialePerId(id);
                }
                case 3 -> {
                    System.out.println("\n--- Cerca Materiale per Titolo ---");
                    System.out.print("Inserisci il titolo: ");
                    titolo = userInput.nextLine();

                    ElementiBiblioteca[] risultati = libreria.cercaPerTitolo(titolo);

                    if (risultati.length == 0) {
                        System.out.println("Nessun materiale trovato con questo titolo.");
                    } else {
                        System.out.println("Materiali trovati:");
                        for (ElementiBiblioteca elemento : risultati) {
                            System.out.println(elemento.Descrivi());
                        }
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Visualizza tutti i Materiali ---");
                    libreria.stampaCollezione();
                }
                case 5 -> {
                    System.out.println("\n--- Visualizza Statistiche ---");
                    System.out.println("Totale ElementiBiblioteca: " + libreria.contaTotale());
                    System.out.println("Numero di libri: " + libreria.contaPerTipo(Libro.class));
                    System.out.println("Numero di riviste: " + libreria.contaPerTipo(Rivista.class));
                    System.out.println("Numero di DVD: " + libreria.contaPerTipo(Dvd.class));
                }
                case 6 -> {
                    if (gestoreClienti.contaClienti() == 0) {
                        System.out.println("Nessun cliente registrato. Aggiungi un cliente prima di procedere con le vendite.");
                    } else {
                        System.out.println("\n--- Gestisci Vendite ---");
                        System.out.print("Inserisci ID Cliente: ");
                        int idCliente = Integer.parseInt(userInput.nextLine());

                        Cliente cliente = gestoreClienti.cercaClientePerId(idCliente);
                        if (cliente == null) {
                            System.out.println("Cliente con ID " + idCliente + " non trovato.");
                        } else {
                            System.out.println("Cliente trovato: " + cliente.descriviCliente());
                            System.out.println("Inserisci gli ID degli Elementi da vendere, separati da virgola: ");
                            String[] idMateriali = userInput.nextLine().split(",");
                            ElementiBiblioteca[] materialiVenduti = new ElementiBiblioteca[idMateriali.length];

                            for (int i = 0; i < idMateriali.length; i++) {
                                int idMateriale = Integer.parseInt(idMateriali[i].trim());
                                materialiVenduti[i] = libreria.cercaPerId(idMateriale);
                                if (materialiVenduti[i] == null) {
                                    System.out.println("Materiale con ID " + idMateriale + " non trovato.");
                                } else {
                                    libreria.decrementaStock(idMateriale);
                                }
                            }

                            Date dataVendita = new Date();
                            totale = 0;
                            for (ElementiBiblioteca elemento : materialiVenduti) {
                                if (elemento instanceof Vendibile) {
                                    totale += ((Vendibile) elemento).getPrezzo();  // Somma il prezzo dei materiali venduti
                                }
                            }

                            if (totale > 0) {
                                Vendita vendita = new Vendita(gestoreVendite.getIdVendita(), dataVendita, cliente, totale, materialiVenduti);
                                gestoreVendite.aggiungiVendita(vendita);  // Aggiungi la vendita
                                System.out.println("Vendita registrata con successo!");
                            } else {
                                System.out.println("Vendita non effettuata: nessun materiale valido selezionato.");
                            }
                        }
                    }
                }


                case 7 -> {
                    System.out.println("\n--- Aggiungi Cliente ---");
                    System.out.print("Inserisci il nome: ");
                    nome = userInput.nextLine();
                    System.out.print("Inserisci l'email: ");
                    email = userInput.nextLine();
                    Cliente nuovoCliente = new Cliente(nome, email);
                    gestoreClienti.aggiungiCliente(nuovoCliente);
                }

                case 8 -> {
                    System.out.println("\n--- Visualizza Report Vendite ---");
                    System.out.println("1. Vendite per periodo");
                    System.out.println("2. Vendite per tipo (totale per tipo di materiale)");
                    System.out.println("3. Vendite totali per cliente");
                    System.out.print("Scegli un'opzione: ");
                    opzioneReport = Integer.parseInt(userInput.nextLine());

                    switch (opzioneReport) {
                        case 1 -> {
                            System.out.print("Inserisci la data di inizio (yyyy-MM-dd): ");
                            inizioStr = userInput.nextLine();
                            System.out.print("Inserisci la data di fine (yyyy-MM-dd): ");
                            fineStr = userInput.nextLine();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                            try {
                                Date inizio = format.parse(inizioStr);
                                Date fine = format.parse(fineStr);
                                Vendita[] venditeNelPeriodo = gestoreVendite.venditePerPeriodo(inizio, fine);

                                if (venditeNelPeriodo.length == 0) {
                                    System.out.println("Nessuna vendita effettuata in questo periodo.");
                                } else {
                                    System.out.println("Vendite nel periodo:");
                                    for (Vendita vendita : venditeNelPeriodo) {
                                        vendita.descriviVendita();
                                    }
                                }
                            } catch (ParseException e) {
                                System.out.println("Errore: Formato data non valido.");
                            }
                        }
                        case 2 -> {
                            System.out.println("Vendite per tipo di materiale:");
                            totale = gestoreVendite.totaleVenditePerTipo(Libro.class);
                            System.out.println("Totale vendite per i libri: " + totale + "€");
                            totale = gestoreVendite.totaleVenditePerTipo(Rivista.class);
                            System.out.println("Totale vendite per le riviste: " + totale + "€");
                            totale = gestoreVendite.totaleVenditePerTipo(Dvd.class);
                            System.out.println("Totale vendite per i dvd: " + totale + "€");

                        }

                        case 3 -> {
                            System.out.print("Inserisci l'ID del cliente: ");
                            id = Integer.parseInt(userInput.nextLine());
                            totale = gestoreVendite.totaleVenditePerCliente(id);
                            System.out.println("Totale vendite per il cliente con ID " + id + ": " + totale + "€");
                        }
                        default -> System.out.println("Opzione non valida.");
                    }
                }

                case 9 -> {
                    System.out.println("\n--- Visualizza tutti i Clienti ---");
                    gestoreClienti.visualizzaClienti();
                }
                case 10 -> {
                    System.out.println("\n--- Verifica disponibilità materiale ---");
                    System.out.print("Inserisci ID Materiale per verificare disponibilità: ");
                    id = Integer.parseInt(userInput.nextLine());
                    libreria.verificaDisponibilita(id);
                }
                case 0 -> System.out.println("\nGrazie per aver usato Bibliomarket. Arrivederci!");
                default -> System.out.println("Errore: Inserisci un'opzione valida!");
            }
        } while (scelta != 0);
        userInput.close();
    }
}
