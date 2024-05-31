// Classe Abstrata do Cliente
public abstract class Cliente {
    // Atributos da classe
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;
    private String receita;
    private int mtPagamento;

    // Método Cliente
    public Cliente(String nome, String endereco, String telefone, String CPF, String receita, int mtPagamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.receita = receita;
        this.mtPagamento = mtPagamento;
    }

    /*Getters e Setters */
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

    public int getmtPagamento() {
        return mtPagamento;
    }

    public void setmtPagamento(int mtPagamento) {
        this.mtPagamento = mtPagamento;
    }



    // Métodos Abstratos
    public abstract void realizarCompra();
    public abstract void compararPreco();
    public abstract void verificarPagamento();
    public abstract void deixarComentarios();
    public abstract void avaliarProduto();
    public abstract void avaliarAtendente();
    public abstract void avaliarLoja();
}