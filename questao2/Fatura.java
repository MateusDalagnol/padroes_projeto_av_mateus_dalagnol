package questao2;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private final Lote lote;
    private final List<IServico> servicos = new ArrayList<>();

    public Fatura(Lote lote) {
        this.lote = lote;
    }

    public void adicionarServico(IServico servico) {
        servicos.add(servico);
    }

    public void imprimir() {
        double valorVenda = lote.getValorVenda();
        double total = valorVenda;

        System.out.println("Fatura do comprador");
        System.out.println("Lote: " + lote.getNome());
        System.out.println("Valor de venda: R$ " + String.format("%.2f", valorVenda));
        for (IServico s : servicos) {
            double custo = s.getCusto(valorVenda);
            System.out.println(s.getDescricao() + ": R$ " + String.format("%.2f", custo));
            total += custo;
        }
        System.out.println("Total a pagar: R$ " + String.format("%.2f", total));
    }
}