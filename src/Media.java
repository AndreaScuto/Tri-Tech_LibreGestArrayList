public abstract class Media implements ElementiBiblioteca{

    private String titolo, autore;

    public Media() {

    }

    public Media(String titolo, String autore) {
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

    @Override
    public String toString() {
        return "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}
