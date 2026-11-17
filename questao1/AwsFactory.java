package questao1;

public class AwsFactory implements IProvedorFactory {

    public String getNome() { 
        return "Aws"; 
    }

    public IMaquinaVirtual criarMaquinaVirtual() { 
        return new AwsVM(); 
    }

    public IArmazenamento criarArmazenamento() { 
        return new AwsArmazenamento(); 
    }

    public IFila criarFila() { 
        return new AwsFila(); 
    }

    public double getCustoHoraMaquina() { 
        return 0.10; 
    }

    public double getCustoGbMes() { 
        return 0.023; 
    }

    public double getCustoFilaMes() { 
        return 0.40; 
    }
}