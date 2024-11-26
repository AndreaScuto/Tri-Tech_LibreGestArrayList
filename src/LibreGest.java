import java.util.Scanner;

public class LibreGest {
    public static void main(String[] args) {
        String titolo, autore, temp;
        int scelta, tipologia;
        Libreria libreria = new Libreria();
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("Benvenuto nel menù di LibreGest:");

        do {
            System.out.println();
            System.out.println("1. Aggiungi materiale.");
            System.out.println("2. Rimuovi tutti i materiali.");
            System.out.println("3. Cerca materiale per titolo.");
            System.out.println("4. Visualizza a schermo tutti i materiali.");
            System.out.println("5. Visualizza statistiche su collezione.");
            System.out.println("Premi 0 per uscire dal programma...");
            switch (scelta = Integer.parseInt(userInput.nextLine())) {
                case 1 -> {
                    System.out.println("");
                    System.out.print("Inserisci titolo del materiale: ");
                    titolo = userInput.nextLine();
                    System.out.print("Inserisci autore del materiale: ");
                    autore = userInput.nextLine();
                    System.out.println("Inserisci tipologia del materiale: (1 per libro, 2 per rivista, 3 per dvd)");
                    tipologia = Integer.parseInt(userInput.nextLine());

                    switch (tipologia) {
                        case 1 -> {
                            System.out.print("Inserisci genere libro: ");
                            temp = userInput.nextLine();
                            Libro l = new Libro(titolo, autore, temp);
                            libreria.aggiungiMateriale(l);
                        }
                        case 2 -> {
                            System.out.print("Inserisci formato rivista: ");
                            temp = userInput.nextLine();
                            Rivista r = new Rivista(titolo, autore, temp);
                            libreria.aggiungiMateriale(r);
                        }
                        case 3 -> {
                            System.out.print("Inserisci durata dvd: ");
                            temp = userInput.nextLine();
                            Dvd d = new Dvd(titolo, autore, temp);
                            libreria.aggiungiMateriale(d);
                        }
                    }
                }
                case 2 -> libreria.rimuoviMateriali();
                case 3 -> {
                    System.out.print("Inserisci titolo per ricerca: ");
                    titolo = userInput.nextLine();
                    if (!libreria.cercaTitolo(titolo)) {
                        System.out.println("Titolo non trovato...");
                    }
                }
                case 4 -> libreria.stampaCollezione();
                case 5 -> libreria.statistiche();
                case 0 -> {} //Esci dal programma.
                default -> System.out.println("Inserisci valore valido!");
            }
        } while (scelta != 0);
        userInput.close();
    }
}
