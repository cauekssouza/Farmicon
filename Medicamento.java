public class Medicamento {
    private String nome;
    private double preco;
    private Farmacia farmacia;
    private String localizacao;

    public Medicamento(String nome, double preco, Farmacia farmacia, String localizacao) {
        this.nome = nome;
        this.preco = preco;
        this.farmacia = farmacia;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
