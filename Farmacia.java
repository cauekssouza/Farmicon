import java.util.ArrayList;
import java.util.List;

// Classe Farmacia e seus Atributos
public class Farmacia {
    private String nome;
    private String endereco;
    private List<Remedio> listaRemedio;

    // Constructor
    public Farmacia(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaRemedio = new ArrayList<>();
    }

    // Método para adicionar remédio ao inventário da farmácia
    public void adicionarRemedio(Remedio remedio) {
        listaRemedio.add(remedio);
    }

    // Método para obter o preço de um remédio específico na farmácia
    public double obterPrecoDoRemedio(String nomeRemedio) throws RemedioNaoEncontradoException {
        for (Remedio remedio : listaRemedio) {
            if (remedio.getNome().equalsIgnoreCase(nomeRemedio)) {
                return remedio.getPreco();
            }
        }
        throw new RemedioNaoEncontradoException("Remédio não encontrado na farmácia: " + nomeRemedio);
    }

    // Método para comparar preços de um remédio específico com outro remédio
    public void compararPrecoComOutroRemedio(String nomeRemedio, Remedio outroRemedio) throws RemedioNaoEncontradoException {
        double precoDoRemedio = obterPrecoDoRemedio(nomeRemedio);
        double precoDoOutroRemedio = outroRemedio.getPreco();

        if (precoDoRemedio < precoDoOutroRemedio) {
            System.out.println(nomeRemedio + " é mais barato que " + outroRemedio.getNome());
        } else if (precoDoRemedio > precoDoOutroRemedio) {
            System.out.println(nomeRemedio + " é mais caro que " + outroRemedio.getNome());
        } else {
            System.out.println(nomeRemedio + " tem o mesmo preço que " + outroRemedio.getNome());
        }
    }

    // Getters para nome e endereço da farmácia
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
