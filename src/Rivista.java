public class Rivista extends Media implements ElementiBiblioteca{

    private String formato;

    public Rivista(String formato) {
        this.formato = formato;
    }

    public Rivista(String titolo, String autore, String formato) {
        super(titolo, autore);
        this.formato = formato;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getTitolo() {
        return super.getTitolo();
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String Descrivi() {
        return  "Rivista{" +
                "formato='" + formato + '\'' +
                "} " + super.toString();
    }
}
