public class Libro extends Materiale {

    private String genere;

    public Libro(String genere) {
        this.genere = genere;
    }

    public Libro(String titolo, String autore, String genere) {
        super(titolo, autore);
        this.genere = genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public void stampa() {
        System.out.println("Libro{" +
                "genere='" + genere + '\'' +
                "} " + super.toString());
    }

}
