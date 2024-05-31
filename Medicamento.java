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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
