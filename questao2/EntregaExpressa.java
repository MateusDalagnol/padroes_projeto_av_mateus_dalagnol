package questao2;

public class EntregaExpressa implements IServico {
    public String getDescricao() {
        return "Entrega expressa";
    }

    public double getCusto(double valorVenda) {
        return 450.00;
    }
}