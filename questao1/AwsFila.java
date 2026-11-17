package questao1;

public class AwsFila implements IFila {
    private static int contador = 0;
    private final String id;

    public AwsFila() {
        this.id = "sqs-" + proximoNumero();
    }

    private static synchronized int proximoNumero() {
        contador++;
        return contador;
    }

    public String getId() {
        return id;
    }
}