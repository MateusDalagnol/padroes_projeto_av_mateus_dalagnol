package questao2;

public class CertificadoAutenticidade implements IServico {
    public String getDescricao() {
        return "Certificado de autenticidade";
    }

    public double getCusto(double valorVenda) {
        return 300.00;
    }
}