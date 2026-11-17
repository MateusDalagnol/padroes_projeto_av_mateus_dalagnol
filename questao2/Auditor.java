package questao2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditor implements IObservador {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String getNome() {
        return "Auditor";
    }

    public void atualizar(Lote lote, double valor) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        System.out.println("  [Auditor] " + dataHora + " - lote " + lote.getNome() + " - lance de R$ " + String.format("%.2f", valor));
    }
}