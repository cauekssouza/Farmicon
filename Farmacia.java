import java.util.ArrayList;
import java.util.List;

public class Farmacia  extends PrecoInvalidoExecption{
    private String nome;
    private String endereco;
    private List<Remedio> listaRemedio;

    // Constructor
    public Farmacia(String nome, String endereco) {
        super(endereco);
        this.listaRemedio = new ArrayList<>();
    }

    // Method to add medicine to pharmacy's inventory
    public void adicionarRemedio(Remedio remedio) {
        listaRemedio.add(remedio);
    }

    public double obterPrecoDoRemedio(String nomeRemedio) throws RemedioNaoEncontradoException {
        for (Remedio remedio : listaRemedio) {
            if (remedio.getNome().equalsIgnoreCase(nomeRemedio)) {
                return remedio.getPreço();
            }
        }
        throw new RemedioNaoEncontradoException("Remédio não encontrado na farmácia: " + nomeRemedio);
    }

    // Method to get pharmacy's name
    public String getNome() {
        return nome;
    }

    // Method to get pharmacy's address
    public String getEndereco() {
        return endereco;
    }

    
}
