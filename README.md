LibreGest è un'applicazione Java progettata per gestire una collezione di materiali (libri, riviste, DVD) utilizzando una struttura dati ArrayList. L'applicazione offre funzionalità per aggiungere, rimuovere, cercare e visualizzare materiali, oltre a fornire statistiche sulla collezione.

Funzionalità
Aggiunta di materiali: Consente di aggiungere libri, riviste e DVD specificando i dettagli come titolo, autore e attributi specifici (genere, formato, durata).

Rimozione di materiali: Permette di eliminare tutti i materiali dalla collezione.

Ricerca per titolo: Trova un materiale specifico in base al titolo.

Visualizzazione della collezione: Stampa a schermo tutti i materiali presenti nella libreria.

Statistiche della collezione: Mostra il numero totale di libri, riviste e DVD presenti.

Struttura del Progetto: 
Il progetto è composto dalle seguenti classi principali:

Media: Classe astratta base che rappresenta un generico materiale con attributi comuni come titolo e autore.

Sottoclassi di Media:

Libro: Include l'attributo specifico genere.
Rivista: Include l'attributo specifico formato.
Dvd: Include l'attributo specifico durata.
Libreria: Gestisce la collezione di materiali usando una ArrayList<Media> e offre metodi per le operazioni principali.

LibreGest: Contiene il metodo main() e gestisce l'interazione con l'utente tramite un menù.

Requisiti
JDK: Versione 8 o superiore.
Compilatore Java (come javac).
Un ambiente di sviluppo Java (consigliato IntelliJ IDEA o Eclipse).
