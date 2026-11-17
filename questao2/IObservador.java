package questao2;

public interface IObservador {
    String getNome();
    void atualizar(Lote lote, double valor);
}