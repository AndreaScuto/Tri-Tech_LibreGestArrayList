import java.util.Date;

public class GestoreVendite {
    private Vendita[] vendite;
    private final int maxVendite = 100;
    private int idVendita;

    public GestoreVendite() {
        vendite = new Vendita[maxVendite];
    }

    public int getIdVendita() {
        return idVendita;
    }

    public void setIdVendita(int idVendita) {
        this.idVendita = idVendita;
    }

    public void aggiungiVendita(Vendita v) {
        if (idVendita < maxVendite) {
            v.setId(idVendita);
            vendite[idVendita++] = v;
            System.out.println("Vendita aggiunta con successo.");
        } else {
            System.out.println("Errore: Vendite max raggiunte! (100)");
        }
    }

    public Vendita[] venditePerPeriodo(Date inizio, Date fine) {
        Vendita[] venditeNelPeriodo = new Vendita[maxVendite];
        int count = 0;

        for (int i = 0; i < idVendita; i++) {
            if (vendite[i].getData().after(inizio) && vendite[i].getData().before(fine)) {
                venditeNelPeriodo[count++] = vendite[i];
            }
        }
        Vendita[] result = new Vendita[count];
        System.arraycopy(venditeNelPeriodo, 0, result, 0, count);
        return result;
    }

    public double totaleVenditePerTipo(Class tipoElemento) {
        double totale = 0;

        for (int i = 0; i < idVendita; i++) {
            for (ElementiBiblioteca elemento : vendite[i].getMaterialiVenduti()) {
                if (tipoElemento.isInstance(elemento) && elemento instanceof Vendibile) {
                    totale += ((Vendibile) elemento).getPrezzo();
                }
            }
        }
        return totale;
    }

    public double totaleVenditePerCliente(int idCliente) {
        double totale = 0;

        for (int i = 0; i < idVendita; i++) {
            if (vendite[i].getCliente().getIdCliente() == idCliente) {
                totale += vendite[i].getTotale();
            }
        }
        return totale;
    }
}
