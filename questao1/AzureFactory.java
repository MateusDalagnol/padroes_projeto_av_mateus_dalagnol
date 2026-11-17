package questao1;

public class AzureFactory implements IProvedorFactory {
    
    public String getNome() { 
        return "Azure";
    }

    public IMaquinaVirtual criarMaquinaVirtual() { 
        return new AzureVM();
    }

    public IArmazenamento criarArmazenamento() { 
        return new AzureArmazenamento(); 
    }

    public IFila criarFila() { 
        return new AzureFila(); 
    }

    public double getCustoHoraMaquina() { 
        return 0.12; 
    }

    public double getCustoGbMes() { 
        return 0.02; 
    }

    public double getCustoFilaMes() { 
        return 0.50; 
    }
}