public class RemedioNaoEncontradoException extends Exception {

    public RemedioNaoEncontradoException() {
        super("Remédio não encontrado.");
    }

    public RemedioNaoEncontradoException(String message) {
        super(message);
    }

    public RemedioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemedioNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
