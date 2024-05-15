import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private String nome;
    private List<Remedio> listaRemedio;

    // Construtor
    public Farmacia(String nome) {
        this.nome = nome;
        this.listaRemedio = new ArrayList<>();
    }

    // Método para adicionar lista de remédios na lista
    public void adicionarRemedio(Remedio remedio) {
        listaRemedio.add(remedio);
    }

    // Método para obter o preço do Remédio
    public double obterPreçoDoRemedio(String nome) {
        for (Remedio remedio : listaRemedio) {
            if (remedio.getNome().equals(nome)) {
                return remedio.getPreço();
            }
        }
        throw new FarmaciaNãoEncontradaException("Remédio não encontrado na farmácia: " + nome);
    }

    // Métodos Adicionais para farmacia
    public void adicionarNOCarrinho(Remedio remedio) {
        // Implementação para adicionar no carrinho
    }

    public void localizacaoDaFarmacia() {
        for (Remedio remedio : listaRemedio) {
            System.out.println("Medicamento: " + remedio.getNome() + ", Localização: " + remedio.getLocalizacao());
        }
    }
}
