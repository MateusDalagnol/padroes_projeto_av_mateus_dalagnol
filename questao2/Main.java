package questao2;

public class Main {
    public static void main(String[] args) {
        Lote escultura = new Lote("Escultura de bronze", "Arte", 2000.00, 3000.00, new ComissaoArte());
        Lote apartamento = new Lote("Apartamento no centro", "Imóveis", 200000.00, 350000.00, new ComissaoImoveis());

        Participante jurandir = new Participante("Jurandir");
        Participante fabricio = new Participante("Fabrício");
        Participante marlene = new Participante("Marlene");
        Painel painel = new Painel();
        Auditor auditor = new Auditor();

        escultura.adicionarObservador(jurandir);
        escultura.adicionarObservador(fabricio);
        escultura.adicionarObservador(marlene);
        escultura.adicionarObservador(painel);
        escultura.adicionarObservador(auditor);

        apartamento.adicionarObservador(fabricio);
        apartamento.adicionarObservador(marlene);
        apartamento.adicionarObservador(painel);
        apartamento.adicionarObservador(auditor);

        System.out.println("Lances");
        escultura.darLance(jurandir, 2200.00);
        escultura.darLance(fabricio, 2250.00);
        escultura.darLance(fabricio, 2400.00);

        System.out.println("\nMarlene deixou de acompanhar a escultura.");
        escultura.removerObservador(marlene);
        escultura.darLance(jurandir, 3000.00);

        System.out.println("\n Lances no apartamento");
        apartamento.darLance(marlene, 215000.00);
        apartamento.darLance(fabricio, 230000.00);

        escultura.setRegraComissao(new ComissaoEletronicos());

        System.out.println("\n Encerramento ");
        escultura.encerrar();
        apartamento.encerrar();
        apartamento.darLance(marlene, 400000.00);

        System.out.println();
        Fatura fatura = new Fatura(escultura);
        fatura.adicionarServico(new SeguroTransporte());
        fatura.adicionarServico(new CertificadoAutenticidade());
        fatura.adicionarServico(new EntregaExpressa());
        fatura.adicionarServico(new EntregaExpressa());
        fatura.imprimir();

        System.out.println();
        escultura.imprimirAcerto();
    }
}