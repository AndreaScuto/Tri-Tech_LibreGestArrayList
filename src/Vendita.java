import java.util.Date;

public class Vendita {

    private int idVendita;
    private Date data;
    private Cliente cliente;
    private double totale;
    private ElementiBiblioteca[] elementiBibliotecaVenduti;
    private final int maxElementiVenduti = 5;

    public Vendita() {
        this.elementiBibliotecaVenduti = new ElementiBiblioteca[maxElementiVenduti];
    }

    public Vendita(int idVendita, Date data, Cliente cliente, double totale, ElementiBiblioteca[] elementiBibliotecaVenduti) {
        this.idVendita = idVendita;
        this.data = data;
        this.cliente = cliente;
        this.totale = totale;
        this.elementiBibliotecaVenduti = elementiBibliotecaVenduti;
    }

    public int getIdVendita() {
        return idVendita;
    }

    public void setId(int idVendita) {
        this.idVendita = idVendita;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public ElementiBiblioteca[] getMaterialiVenduti() {
        return elementiBibliotecaVenduti;
    }

    public void setMaterialiVenduti(ElementiBiblioteca[] elementiBibliotecaVenduti) {
        this.elementiBibliotecaVenduti = elementiBibliotecaVenduti;
    }

    public void descriviVendita() {
        System.out.println("****************************");
        System.out.println("Vendita ID: " + idVendita);
        System.out.println("Cliente: " + cliente.descriviCliente());
        System.out.println("Data Vendita: " + data);
        System.out.println("Totale: " + totale + "€");
        System.out.println("Elementi Venduti:");


        for (ElementiBiblioteca e : elementiBibliotecaVenduti) {
            if (e != null) {
                System.out.println("  - " + e.Descrivi());
            }
        }
        System.out.println("****************************");
    }

}
