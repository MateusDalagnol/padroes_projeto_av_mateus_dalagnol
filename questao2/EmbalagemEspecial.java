package questao2;

public class EmbalagemEspecial implements IServico {
    public String getDescricao() {
        return "Embalagem especial";
    }

    public double getCusto(double valorVenda) {
        return 180.00;
    }
}