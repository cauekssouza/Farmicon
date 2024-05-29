public class ClienteFisica extends Cliente {
    // Não Possui atributos 

    public ClienteFisica(String nome, String endereco, int telefone, String CPF, String receita, String boleto, double pix){
        super(nome, endereco, telefone, CPF, receita, boleto, pix);
    }

    // Métodos
    @Override
    public void realizarCompra() {
        // Implementação específica para realizar uma compra como Pessoa Física
        System.out.println("Realizando compra como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void compararPreco() {
        // Implementação específica para comparar preços como Pessoa Física
        System.out.println("Comparando preços como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void verificarPagamento() {
        // Implementação específica para verificar pagamento como Pessoa Física
        System.out.println("Verificando pagamento como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void deixarComentarios() {
        // Implementação específica para deixar comentários como Pessoa Física
        System.out.println("Deixando comentários como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void avaliarProduto() {
        // Implementação específica para avaliar produto como Pessoa Física
        System.out.println("Avaliando produto como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void avaliarAtendente() {
        // Implementação específica para avaliar atendente como Pessoa Física
        System.out.println("Avaliando atendente como Pessoa Física.");
        // Implementação adicional se necessário
    }

    @Override
    public void avaliarLoja() {
        // Implementação específica para avaliar loja como Pessoa Física
        System.out.println("Avaliando loja como Pessoa Física.");
        // Implementação adicional se necessário
    }
}
