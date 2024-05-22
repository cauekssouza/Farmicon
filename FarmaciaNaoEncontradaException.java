// Classe de Excepção de Não Encontrar tal produto na estebelecimento
public class FarmaciaNaoEncontradaException extends Exception {
    public FarmaciaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
