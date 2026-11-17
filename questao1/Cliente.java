package questao1;

public class Cliente {
    private final IProvedorFactory fabrica;

    public Cliente(IProvedorFactory fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(Solicitacao s) {
        double custo = s.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * 730 + s.getGbArmazenamento() * fabrica.getCustoGbMes()
            + fabrica.getCustoFilaMes();

        if (custo > Configuracao.getInstance().getOrcamentoMaximo()) {
            Auditoria.getInstance().registrar(s.getNomeAmbiente(), fabrica.getNome(), "RECUSADO - acima do orçamento");
            return;
        }

        String resumo = "Ambiente: " + s.getNomeAmbiente()
                + "\nProvedor: " + fabrica.getNome()
                + "\nRegião: " + Configuracao.getInstance().getRegiao();

        for (int i = 0; i < s.getQuantidadeMaquinas(); i++) {
            resumo += "\nMáquina virtual: " + fabrica.criarMaquinaVirtual().getId();
        }
        resumo += "\nArmazenamento: " + fabrica.criarArmazenamento().getId();
        resumo += "\nFila: " + fabrica.criarFila().getId();
        resumo += "\nCusto mensal estimado: R$ " + String.format("%.2f", custo) + "\n";

        System.out.println(resumo);
        Auditoria.getInstance().registrar(s.getNomeAmbiente(), fabrica.getNome(), "ACEITO");
    }
}
