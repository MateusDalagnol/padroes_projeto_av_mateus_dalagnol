package questao1;

public class AwsArmazenamento implements IArmazenamento {
    private static int contador = 0;
    private final String id;

    public AwsArmazenamento() {
        this.id = "s3://" + proximoNumero();
    }

    private static synchronized int proximoNumero() {
        contador++;
        return contador;
    }

    public String getId() {
        return id;
    }
}
