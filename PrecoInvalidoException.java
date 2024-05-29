public class PrecoInvalidoException  extends Exception{
    public PrecoInvalidoException() {
        super("Preço inválido para o medicamento.");
    }

    public PrecoInvalidoException(String message) {
        super(message);
    }

    public PrecoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrecoInvalidoException(Throwable cause) {
        super(cause);
    }
}
