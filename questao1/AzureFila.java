package questao1;

public class AzureFila implements IFila {
    private static int contador = 0;
    private final String id;

    public AzureFila() {
        this.id = "sb-" + proximoNumero();
    }

    private static synchronized int proximoNumero() {
        contador++;
        return contador;
    }

    public String getId() {
        return id;
    }
}