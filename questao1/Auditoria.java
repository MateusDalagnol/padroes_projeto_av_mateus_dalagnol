package questao1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final List<String> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static Auditoria getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        registros.add(dataHora + " | " + ambiente + " | " + provedor + " | " + resultado);
    }

    public synchronized void imprimirHistorico() {
        System.out.println("Histórico de auditoria");
        for (String r : registros) {
            System.out.println(r);
        }
        System.out.println("Total de registros: " + registros.size());
    }
}