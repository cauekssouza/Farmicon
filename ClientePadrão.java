public class ClientePadrão extends Cliente {
    public ClientePadrão(String nome, String endereco, int telefone, double CPF,String receita, String boleto, double pix) {
        super(nome, endereco, telefone, CPF, receita, boleto, pix);
    }

    @Override
    public void realizarCompra() {
        // Implementação específica para Cliente Físico
        System.out.println("Compra realizada em loja física.");
    }

    @Override
    public void compararPreco() {
        // Implementação específica para Cliente Físico
        System.out.println("Comparando preços de produtos em loja física.");
    }

    @Override
    public void verificarPagamento() {
        // Implementação específica para Cliente Físico
        System.out.println("Verificando pagamento em loja física.");
    }

    @Override
    public void deixarComentários() {
        // Implementação específica para Cliente Físico
        System.out.println("Deixando comentário na loja física.");
    }

    @Override
    public void avaliarProduto() {
        // Implementação específica para Cliente Físico
        System.out.println("Avaliando produto comprado na loja física.");
    }

    @Override
    public void avaliarAtendente() {
        // Implementação específica para Cliente Físico
        System.out.println("Avaliando atendente da loja física.");
    }

    @Override
    public void avaliarLoja() {
        // Implementação específica para Cliente Físico
        System.out.println("Avaliando a loja física.");
    }
}
