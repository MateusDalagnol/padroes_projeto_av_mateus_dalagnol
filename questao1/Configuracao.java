package questao1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("questao1/config.properties")) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível ler config.properties", e);
        }
        this.regiao = props.getProperty("regiao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.maximo"));
    }

    public static Configuracao getInstance() {
        return INSTANCIA;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}