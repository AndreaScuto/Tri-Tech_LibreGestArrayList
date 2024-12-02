public class Libro extends Media implements ElementiBiblioteca, Vendibile {

    private String genere;
    double prezzo;

    public Libro() {
    }

    public Libro(String titolo, String autore, String genere, double prezzo, int quantita) {
        super(titolo, autore, quantita);
        this.genere = genere;
        this.prezzo = prezzo;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getTitolo() {
        return super.getTitolo();
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String Descrivi() {
        return "Libro{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", autore='" + getAutore() + '\'' +
                ", genere='" + genere + '\'' +
                ", prezzo=" + prezzo + "€" +
                '}';
    }

}
