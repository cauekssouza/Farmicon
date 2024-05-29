public class FarmaciaNaoEncontradaException extends Exception {

    public FarmaciaNaoEncontradaException() {
        super("Farmácia não encontrada.");
    }

    public FarmaciaNaoEncontradaException(String message) {
        super(message);
    }

    public FarmaciaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FarmaciaNaoEncontradaException(Throwable cause) {
        super(cause);
    }
}
