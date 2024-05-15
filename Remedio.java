public class Remedio {
    private String nome;
    private double preço;
    private String localizacao;

    // Construtor do Remedio
    public Remedio(String nome, double preço, String localizacao) throws PrecoInvalidoExecption {
        if (preço <= 0) {
            throw new PrecoInvalidoExecption("Preço Inválido para o remédio " + nome);
        }
        this.nome = nome;
        this.preço = preço;
        this.localizacao = localizacao;
    }

    /* GETTERS E SETTERS */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    // Métodos
    public void compararPreço(Remedio remedio) {
        // Implementação para comparar preços, se necessário
    }
}
