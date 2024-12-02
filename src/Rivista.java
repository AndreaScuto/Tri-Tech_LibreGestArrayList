public class Rivista extends Media implements ElementiBiblioteca, Vendibile {

    private String formato;
    double prezzo;

    public Rivista() {
    }

    public Rivista(String titolo, String autore, String formato, double prezzo, int quantita) {
        super(titolo, autore, quantita);
        this.formato = formato;
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

    @Override
    public String getAutore() {
        return super.getAutore();
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String Descrivi() {
        return "Rivista{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", autore='" + getAutore() + '\'' +
                ", formato='" + formato + '\'' +
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
