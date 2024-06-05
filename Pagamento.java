public class Pagamento {
    private String tipo;
    private double valor;

    public Pagamento(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void processarPagamento() {
        // Implementação do processamento de pagamento
        System.out.println("Processando pagamento de " + valor + " via " + tipo);
    }
}