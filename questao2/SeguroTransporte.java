package questao2;

public class SeguroTransporte implements IServico {
    public String getDescricao() {
        return "Seguro de transporte";
    }

    public double getCusto(double valorVenda) {
        return valorVenda * 0.015;
    }
}