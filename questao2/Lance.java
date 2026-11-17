package questao2;

public class Lance {
    private final IObservador autor;
    private final double valor;

    public Lance(IObservador autor, double valor) {
        this.autor = autor;
        this.valor = valor;
    }

    public IObservador getAutor() { return autor; }
    public double getValor() { return valor; }
}