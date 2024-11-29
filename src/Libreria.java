import java.util.ArrayList;

public class Libreria {

    private ArrayList<Media> collezione;

    public Libreria(ArrayList<Media> collezione) {
        this.collezione = collezione;
    }

    public Libreria() {
        this.collezione = new ArrayList<>();
    }

    public void aggiungiMateriale(Media m) {
        collezione.add(m);
        System.out.println("Aggiunto materiale.");
    }

    public void rimuoviMateriali() {
        collezione.clear();
        System.out.println("Collezione eliminata.");
    }

    public boolean cercaTitolo(String titolo) {
        boolean flag = false;
        for (Media m : collezione) {
            if (m.getTitolo().equalsIgnoreCase(titolo)) {
                flag = true;
                m.Descrivi();
            }
        }
        return flag;
    }

    public void stampaCollezione() {
        for (Media m : collezione) {
            System.out.println(m.Descrivi());
        }
    }

    public void statistiche() {
        int r = 0, l = 0, d = 0;
        for (Media m : collezione) {
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
        System.out.println("Tutti gli elementi: "+r+d+l);
    }
}