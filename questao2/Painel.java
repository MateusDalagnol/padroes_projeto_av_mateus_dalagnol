package questao2;

public class Painel implements IObservador {
    private double maiorLance = 0;
    private int totalLances = 0;

    public String getNome() {
        return "Painel do leiloeiro";
    }

    public void atualizar(Lote lote, double valor) {
        totalLances++;
        if (valor > maiorLance) {
            maiorLance = valor;
        }
        System.out.println("Maior lance: R$ " + String.format("%.2f", maiorLance) + " | Total de lances: " + totalLances);
    }
}