public abstract class Cliente {
    private String nome;
    private String endereco;
    private int telefone;
    private double CPF;
    private String receita;
    private String boleto;
    private double pix;


    // Método Construtor
    public Cliente(String nome, String endereco, int telefone, double CPF, String receita, String boleto, double pix){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.receita = receita;
        this.boleto = boleto;
        this.pix = pix;
    }

    /* Getters e Setters */
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public  int getTelefone(){
        return telefone;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public double getCPF(){
        return CPF;
    }
    public void setCPF(double CPF){
        this.CPF = CPF;
    }
    public String getReceita(){
        return receita;
    }
    public void setReceita(String receita){
        this.receita = receita;
    }
    public String getBoleto(){
        return boleto;
    }
    public void setBoleto(String boleto){
        this.boleto = boleto;
    }
    public double getPix(){
        return pix;
    }
    public void setPix(double pix){
        this.pix = pix;
    }


    // Método abstrato para ser implementado nas subclasses
    public abstract void realizarCompra();
    public abstract void compararPreco();
}
