public class farmicon {
    private String Farmacia;
    private String caixa;
    private String atendente;

    // Construtor de Classe
    public farmicon(String Farmacia, String caixa, String atendente){
        this.Farmacia = Farmacia;
        this.caixa = caixa;
        this.atendente = atendente;
    }
    /*Métodos Getters e Setters */
    public String getFarmacia(){
        return Farmacia;
    }
    public void setFarmacia(String Farmacia){
        this.Farmacia = Farmacia;
    }
    public String getCaixa(){
        return caixa;
    }
    public void setCaixa(String caixa){
        this.caixa = caixa;
    }
    public String getAtendente(){
        return atendente;
    }
    public void setAtendente(String atendente){
        this.atendente = atendente;
    }
}