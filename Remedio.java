// Classe Remedio e seus Atributos
public class Remedio {
    private String nome;
    private double preco;
    private String localizacao;

    // Construtor do Remedio
    public Remedio(String nome, double preco, String localizacao) throws PrecoInvalidoExecption {
        if (preco <= 0) {
            throw new PrecoInvalidoExecption("Preço Inválido para o remédio " + nome);
        }
        this.nome = nome;
        this.preco = preco;
        this.localizacao = localizacao;
    }

    // Getter para nome
    public String getNome() {
        return nome;
    }

    // Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para preco
    public double getPreco() {
        return preco;
    }

    // Setter para preco
    public void setPreco(double preco) throws PrecoInvalidoExecption {
        if (preco <= 0) {
            throw new PrecoInvalidoExecption("Preço Inválido para o remédio " + nome);
        }
        this.preco = preco;
    }

    // Getter para localizacao
    public String getLocalizacao() {
        return localizacao;
    }

    // Setter para localizacao
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    // Método para comparar preços
    public void compararPreco(Remedio outroRemedio) {
        if (this.preco < outroRemedio.preco) {
            System.out.println(this.nome + " é mais barato que " + outroRemedio.nome);
        } else if (this.preco > outroRemedio.preco) {
            System.out.println(this.nome + " é mais caro que " + outroRemedio.nome);
        } else {
            System.out.println(this.nome + " tem o mesmo preço que " + outroRemedio.nome);
        }
    }
}
