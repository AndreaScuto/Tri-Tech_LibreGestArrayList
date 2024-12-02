public class GestoreClienti {
    private Cliente[] clienti;
    private int countClienti;
    private final int maxClienti = 100;

    public GestoreClienti() {
        this.clienti = new Cliente[maxClienti];
        this.countClienti = 0;
    }

    public void aggiungiCliente(Cliente cliente) {
        if (countClienti < maxClienti) {
            cliente.setIdCliente(countClienti);
            clienti[countClienti++] = cliente;
            System.out.println("Cliente aggiunto con successo!");
        } else {
            System.out.println("Errore: Numero massimo di clienti raggiunto.");
        }
    }

    public Cliente cercaClientePerId(int idCliente) {
        for (int i = 0; i < countClienti; i++) {
            if (clienti[i].getIdCliente() == idCliente) {
                return clienti[i];
            }
        }
        return null;
    }

    public int contaClienti() {
        return countClienti;
    }

    public void visualizzaClienti() {
        if (countClienti == 0) {
            System.out.println("Nessun cliente registrato.");
        } else {
            System.out.println("Elenco dei clienti:");
            for (int i = 0; i < countClienti; i++) {
                System.out.println(clienti[i].descriviCliente());
            }
        }
    }
}
