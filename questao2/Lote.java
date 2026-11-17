package questao2;

import java.util.ArrayList;
import java.util.List;

public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido = false;
    private IRegraComissao regraComissao;
    private final List<IObservador> observadores = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, IRegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void adicionarObservador(IObservador o) {
        observadores.add(o);
    }

    public void removerObservador(IObservador o) {
        observadores.remove(o);
    }

    public void setRegraComissao(IRegraComissao regraComissao) {
        this.regraComissao = regraComissao;
    }

    public void darLance(IObservador autor, double valor) {
        if (!aberto) {
            System.out.println("Lance de " + autor.getNome() + " recusado: o lote " + nome + " já foi encerrado.");
            return;
        }
        double minimo = lanceAtual * 1.05;
        if (valor < minimo) {
            System.out.println("Lance de " + autor.getNome() + " (R$ " + String.format("%.2f", valor) + ") recusado: o mínimo é R$ " + String.format("%.2f", minimo) + ".");
            return;
        }
        lanceAtual = valor;
        lances.add(new Lance(autor, valor));
        System.out.println("Lance de " + autor.getNome() + " aceito no lote " + nome + ": R$ " + String.format("%.2f", valor));
        for (IObservador o : observadores) {
            if (o != autor) {
                o.atualizar(this, valor);
            }
        }
    }

    public void encerrar() {
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) {
            System.out.println("Lote " + nome + " VENDIDO por R$ " + String.format("%.2f", lanceAtual));
        } else {
            System.out.println("Lote " + nome + " NÃO VENDIDO (reserva de R$ " + String.format("%.2f", precoReserva) + " não atingida)");
        }
    }

    public double getComissao() {
        return regraComissao.calcular(lanceAtual);
    }

    public void imprimirAcerto() {
        System.out.println("Acerto do vendedor - " + nome);
        System.out.println("Valor de venda: R$ " + String.format("%.2f", lanceAtual));
        System.out.println("Comissão: R$ " + String.format("%.2f", getComissao()));
        System.out.println("Valor líquido: R$ " + String.format("%.2f", lanceAtual - getComissao()));
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoInicial() { return precoInicial; }
    public double getValorVenda() { return lanceAtual; }
    public boolean isVendido() { return vendido; }
}