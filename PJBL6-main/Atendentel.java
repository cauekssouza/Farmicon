public class Atendentel implements Atendente  {
    private final String nome;
    private final String cargo;

    public Atendentel(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public void atenderCliente(Cliente cliente) {
        System.out.println("Atendendo o cliente: " + cliente.getNome());
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCargo() {
        return cargo;
    }

    @Override
    public void realizarPagamento(Cliente cliente, Pagamento pagamento) {
        System.out.println("Realizando pagamento de " + pagamento.getValor() + " para o cliente: " + cliente.getNome());
        pagamento.processarPagamento();
    }
}
