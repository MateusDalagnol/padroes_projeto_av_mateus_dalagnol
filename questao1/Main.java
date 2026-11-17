package questao1;

public class Main {

    private static IProvedorFactory escolherFabrica(String provedor) {
        if (provedor.equals("Aws")) {
            return new AwsFactory();
        }
        return new AzureFactory();
    }

    public static void main(String[] args) throws InterruptedException {
        Solicitacao loja = new Solicitacao("loja-online", "Aws", 2, 100);
        Solicitacao relatorios = new Solicitacao("relatorios", "Aws", 1, 500);
        Solicitacao intranet = new Solicitacao("intranet", "Azure", 1, 50);
        Solicitacao bigData = new Solicitacao("big-data", "Azure", 10, 2000);

        Cliente c1 = new Cliente(escolherFabrica(loja.getProvedor()));
        Cliente c2 = new Cliente(escolherFabrica(relatorios.getProvedor()));
        Cliente c3 = new Cliente(escolherFabrica(intranet.getProvedor()));
        Cliente c4 = new Cliente(escolherFabrica(bigData.getProvedor()));

        Thread t1 = new Thread(() -> c1.provisionar(loja));
        Thread t2 = new Thread(() -> c2.provisionar(relatorios));
        Thread t3 = new Thread(() -> c3.provisionar(intranet));
        Thread t4 = new Thread(() -> c4.provisionar(bigData));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        Auditoria.getInstance().imprimirHistorico();
    }
}