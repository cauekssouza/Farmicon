public interface Atendente {
    void atenderCliente(Cliente cliente);

    String getNome();

    String getCargo();

    void realizarPagamento(Cliente cliente, Pagamento pagamento);
}
