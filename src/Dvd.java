public class Dvd extends Media implements ElementiBiblioteca{

    private String durata;

    public Dvd(String durata) {
        this.durata = durata;
    }

    public Dvd(String titolo, String autore, String durata) {
        super(titolo, autore);
        this.durata = durata;
    }

    @Override
    public int getId() {
        return 0;
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
                "durata='" + durata + '\'' +
                "} " + super.toString();
    }
}
