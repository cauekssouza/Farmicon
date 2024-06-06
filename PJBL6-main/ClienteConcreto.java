public class ClienteConcreto extends Cliente {

    public ClienteConcreto(String nome, String endereco, String telefone, String CPF, String receita, int mtPagamento) {
        super(nome, endereco, telefone, CPF, receita, mtPagamento);
    }
    
    @Override
    public void compararPreco() {
        System.out.println(getNome() + " está comparando preços.");
    }

    @Override
    public void deixarComentarios() {
        System.out.println(getNome() + " está deixando comentários.");
    }

    @Override
    public void avaliarProduto() {
        System.out.println(getNome() + " está avaliando o produto.");
    }

    @Override
    public void avaliarAtendente() {
        System.out.println(getNome() + " está avaliando o atendente.");
    }

    @Override
    public void avaliarLoja() {
        System.out.println(getNome() + " está avaliando a loja.");
    }
}
