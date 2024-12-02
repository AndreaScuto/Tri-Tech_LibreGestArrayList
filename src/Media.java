public abstract class Media implements ElementiBiblioteca {
    private int id;
    private String titolo;
    private String autore;
    private int quantita;  // Quantità disponibile per ogni materiale

    public Media() {

    }

    public Media(String titolo, String autore, int quantita) {
        this.titolo = titolo;
        this.autore = autore;
        this.quantita = quantita;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }


    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public String Descrivi() {
        return "ID: " + id + ", Titolo: " + titolo + ", Autore: " + autore + ", Quantità: " + quantita;
    }

    public boolean eDisponibile() {
        return quantita > 0;
    }

    public void decrementaQuantita() {
        if (quantita > 0) {
            quantita--;
        }
    }
}
