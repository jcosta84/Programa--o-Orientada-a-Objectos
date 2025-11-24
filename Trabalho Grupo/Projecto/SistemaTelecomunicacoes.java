package Projecto;
import java.io.File;
import java.util.ArrayList;

public class SistemaTelecomunicacoes {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Chamada> chamadas = new ArrayList<>();
    private Tarifario tarifario = new Tarifario();
    private static final String PASTA_DADOS = "C:\\Users\\EDEC\\Dropbox\\US\\Disciplinas\\2º Ano\\Programação Orientada a Objectos\\Trabalho Grupo\\Projecto\\dados"; // pasta para CSV

    public SistemaTelecomunicacoes() {
        // cria pasta "dados" se não existir
        File pasta = new File(PASTA_DADOS);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public void adicionarCliente(String nome, String numero) {
        clientes.add(new Cliente(nome, numero));
    }

    public Cliente procurarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    public void registrarChamada(String nomeCliente, String destino, int segundos) {
        Cliente cliente = procurarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Chamada chamada = new Chamada(cliente, destino, segundos, tarifario);
        chamadas.add(chamada);

        // caminho completo do CSV
        String arquivoCSV = PASTA_DADOS + File.separator + "Clientes.csv";

        try {
            FicheiroCSV.escreverLinha(arquivoCSV, chamada.toString());
        } catch (Exception e) {
            System.out.println("Erro ao gravar: " + e.getMessage());
        }
    }

    public ArrayList<Chamada> obterChamadasCliente(Cliente cliente) {
        ArrayList<Chamada> lista = new ArrayList<>();
        for (Chamada c : chamadas) {
            if (c.getCliente().getNome().equalsIgnoreCase(cliente.getNome())) {
                lista.add(c);
            }
        }
        return lista;
    }
}