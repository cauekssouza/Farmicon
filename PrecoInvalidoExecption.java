// Farmacia não encontrada
public class PrecoInvalidoExecption  extends Exception{
    public PrecoInvalidoExecption(String mensagem){
        super(mensagem);
    }

    // Exceção para Farmacia que não foi encontrada
   public class FarmaciaNãoEncontradaException extends Exception{
    public FarmaciaNãoEncontradaException(String mensagem){
        super(mensagem);
    }
   }

   // Remedio não encontrado 
   public class RemedioNaoEncontradoException extends Exception {
    public RemedioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
   }
}
