package questao1;

public interface IProvedorFactory {
    String getNome();

    IMaquinaVirtual criarMaquinaVirtual();
    IArmazenamento criarArmazenamento();
    IFila criarFila();

    double getCustoHoraMaquina();
    double getCustoGbMes();
    double getCustoFilaMes();
}