public class Dvd extends Media implements ElementiBiblioteca, Vendibile {

    private String durata;
    double prezzo;

    public Dvd() {
    }

    public Dvd(String titolo, String autore, String durata, double prezzo, int quantita) {
        super(titolo, autore, quantita);
        this.durata = durata;
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

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getDurata() {
        return durata;
    }

    @Override
    public String Descrivi() {
        return "Dvd{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", autore='" + getAutore() + '\'' +
                ", durata='" + durata + '\'' +
                ", prezzo=" + prezzo + "€" +
                '}';
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
