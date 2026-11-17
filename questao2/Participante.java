package questao2;

public class Participante implements IObservador {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void atualizar(Lote lote, double valor) {
        System.out.println(nome + " Novo lance no lote " + lote.getNome() + ": R$ " + String.format("%.2f", valor));
    }
}