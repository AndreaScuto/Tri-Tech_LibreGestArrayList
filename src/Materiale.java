public abstract class Materiale {

    private String titolo, autore;

    public Materiale() {

    }

    public Materiale(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public abstract void stampa();

    @Override
    public String toString() {
        return "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}
