public class Cliente {
    private int idCliente;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String descriviCliente() {
        return "Cliente{idCliente=" + idCliente + ", nome='" + nome + "', email='" + email + "'}";
    }
}
