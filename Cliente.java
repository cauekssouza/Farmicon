abstract class Cliente {
    private String nome;
    private int cpf;

    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    // Método Abstrato
    public abstract void imprimirDados();    
}
