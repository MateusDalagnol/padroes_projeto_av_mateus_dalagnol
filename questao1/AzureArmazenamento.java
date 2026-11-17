package questao1;

public class AzureArmazenamento implements IArmazenamento {
    private static int contador = 0;
    private final String id;

    public AzureArmazenamento() {
        this.id = "blob://" + proximoNumero();
    }

    private static synchronized int proximoNumero() {
        contador++;
        return contador;
    }

    public String getId() {
        return id;
    }
}