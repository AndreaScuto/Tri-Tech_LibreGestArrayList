public class Dvd extends Materiale {

    private String durata;

    public Dvd(String durata) {
        this.durata = durata;
    }

    public Dvd(String titolo, String autore, String durata) {
        super(titolo, autore);
        this.durata = durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getDurata() {
        return durata;
    }

    @Override
    public void stampa() {
        System.out.println("Dvd{" +
                "durata='" + durata + '\'' +
                "} " + super.toString());
    }
}
