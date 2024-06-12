public class Medicamento {
    private String nome;
    private double preco;
    private String localizacao;
    private Farmacia farmacia;

    public Medicamento(String nome, double preco, Farmacia farmacia, String localizacao) {
        this.nome = nome;
        this.preco = preco;
        this.localizacao = localizacao;
        this.farmacia = farmacia;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco + " - " + localizacao;
    }
}
