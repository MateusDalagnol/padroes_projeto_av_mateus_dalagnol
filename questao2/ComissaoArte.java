package questao2;

public class ComissaoArte implements IRegraComissao {
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}