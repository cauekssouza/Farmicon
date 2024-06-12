public class AtendenteImpl implements Atendente {

    private final String nome;
    private final String cargo;

    public AtendenteImpl(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public void atenderCliente(Cliente cliente) {
        System.out.println("Atendendo o cliente " + cliente.getNome());

        // Lógica específica para o atendimento
        if (cliente instanceof ClienteConcreto clienteConcreto) {
            realizarAtendimentoEspecifico(clienteConcreto);
        } else {
            System.out.println("Atendimento genérico para cliente.");
        }
    }

    private void realizarAtendimentoEspecifico(ClienteConcreto cliente) {
        // Exemplo de atendimento específico para um tipo de cliente
        System.out.println("Cliente especial: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Número de telefone: " + cliente.getTelefone());
        System.out.println("CPF: " + cliente.getCPF());
        System.out.println("Receita: " + cliente.getReceita());
        System.out.println("Prioridade: " + cliente.getPrioridade());

        // Aqui você pode adicionar mais lógica específica conforme necessário
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
        System.out.println("Realizando pagamento de R$" + pagamento.getValor() + " via " + pagamento.getTipo() + " para o cliente " + cliente.getNome());
        // Lógica para realizar o pagamento
        double valorPagamento = pagamento.getValor();
        String tipoPagamento = pagamento.getTipo();

        System.out.println("Pagamento de R$" + valorPagamento + " via " + tipoPagamento + " realizado com sucesso.");
    }
}
