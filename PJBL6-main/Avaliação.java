public class Avaliação {
    private String usuario;
    private Farmacia farmacia;
    private String comentario;
    private int nota;

    public Avaliação(String usuario, Farmacia farmacia, String comentario, int nota) {
        this.usuario = usuario;
        this.farmacia = farmacia;
        this.comentario = comentario;
        this.nota = nota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
