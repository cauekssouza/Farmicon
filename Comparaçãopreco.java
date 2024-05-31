import java.util.List;

public class Comparaçãopreco {
    public static Pagamento compararPagamentos(List<Pagamento> pagamentos) {
        if (pagamentos == null || pagamentos.isEmpty()) {
            return null;
        }

        Pagamento pagamentoMaisBarato = pagamentos.get(0);
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getValor() < pagamentoMaisBarato.getValor()) {
                pagamentoMaisBarato = pagamento;
            }
        }
        return pagamentoMaisBarato;
    }
}