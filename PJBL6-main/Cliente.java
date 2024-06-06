// Classe Abstrata do Cliente
public abstract class Cliente {
    // Atributos da classe
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;
    private String receita;

    // Método Cliente
    public Cliente(String nome, String endereco, String telefone, String CPF, String receita, int mtPagamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.receita = receita;
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    // Métodos Abstratos
    public abstract void compararPreco();

    // Novos métodos concretos
    public void deixarComentarios() {
        System.out.println(getNome() + " está deixando comentários.");
    }

    public void avaliarProduto() {
        System.out.println(getNome() + " está avaliando o produto.");
    }

    public void avaliarAtendente() {
        System.out.println(getNome() + " está avaliando o atendente.");
    }

    public void avaliarLoja() {
        System.out.println(getNome() + " está avaliando a loja.");
    }
}
