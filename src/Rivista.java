public class Rivista extends Materiale {

    private String formato;

    public Rivista(String formato) {
        this.formato = formato;
    }

    public Rivista(String titolo, String autore, String formato) {
        super(titolo, autore);
        this.formato = formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public void stampa() {
        System.out.println("Rivista{" +
                "formato='" + formato + '\'' +
                "} " + super.toString());
    }
}
