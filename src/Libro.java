public class Libro extends Media implements ElementiBiblioteca {

    private String genere;

    public Libro(String genere) {
        this.genere = genere;
    }

    public Libro(String titolo, String autore, String genere) {
        super(titolo, autore);
        this.genere = genere;
    }

    @Override
    public int getId() {
        return 0;
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
                "genere='" + genere + '\'' +
                "} " + super.toString();
    }
}
