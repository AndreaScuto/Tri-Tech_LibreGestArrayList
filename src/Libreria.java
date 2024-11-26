import java.util.ArrayList;

public class Libreria {

    private ArrayList<Materiale> collezione;

    public Libreria(ArrayList<Materiale> collezione) {
        this.collezione = collezione;
    }

    public Libreria() {
        this.collezione = new ArrayList<>();
    }

    public void aggiungiMateriale(Materiale m) {
        collezione.add(m);
        System.out.println("Aggiunto materiale.");
    }

    public void rimuoviMateriali() {
        collezione.clear();
        System.out.println("Collezione eliminata.");
    }

    public boolean cercaTitolo(String titolo) {
        boolean flag = false;
        for (Materiale m : collezione) {
            if (m.getTitolo().equalsIgnoreCase(titolo)) {
                flag = true;
                m.stampa();
            }
        }
        return flag;
    }

    public void stampaCollezione() {
        for (Materiale m : collezione) {
            m.stampa();
        }
    }

    public void statistiche() {
        int r = 0, l = 0, d = 0;
        for (Materiale m : collezione) {
            if (m instanceof Rivista) {
                r++;
            }
            if (m instanceof Libro) {
                l++;
            }
            if (m instanceof Dvd) {
                d++;
            }
        }
        System.out.println("Statistiche collezione:");
        System.out.println("Numero di riviste: " + r);
        System.out.println("Numero di libri: " + l);
        System.out.println("Numero di DVD: " + d);
    }

}