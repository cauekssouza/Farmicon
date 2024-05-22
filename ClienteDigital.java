public class ClienteDigital extends Cliente {
    public ClienteDigital(String nome, String endereco, int telefone, double CPF,String receita, String boleto, double pix){
        super(nome, endereco, telefone, CPF, receita, boleto, pix);
    }
    @Override
    public void realizarCompra() {
        // Implementação específica para Cliente Digital
        System.out.println("Compra realizada em loja online.");
    }

    @Override
    public void compararPreco() {
        // Implementação específica para Cliente Digital
        System.out.println("Comparando preços de produtos online.");
    }

    @Override
    public void verificarPagamento() {
        // Implementação específica para Cliente Digital
        System.out.println("Verificando pagamento online.");
    }

    @Override
    public void deixarComentários() {
        // Implementação específica para Cliente Digital
        System.out.println("Deixando comentário no site.");
    }

    @Override
    public void avaliarProduto() {
        // Implementação específica para Cliente Digital
        System.out.println("Avaliando produto comprado online.");
    }

    @Override
    public void avaliarAtendente() {
        // Implementação específica para Cliente Digital
        System.out.println("Avaliando atendente do suporte online.");
    }

    @Override
    public void avaliarLoja() {
        // Implementação específica para Cliente Digital
        System.out.println("Avaliando a loja online.");
    }
    
}
