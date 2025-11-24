import java.util.Scanner;

public class ProjectoTelecomPOO {

    private static final Scanner scanner = new Scanner(System.in);
    private static SistemaTelecomunicacoes sistema = new SistemaTelecomunicacoes();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Inserir Chamada");
            System.out.println("3. Consultar Cliente");
            System.out.println("4. Gerar Fatura");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    inserirCliente();
                    break;
                case "2":
                    inserirChamada();
                    break;
                case "3":
                    consultar();
                    break;
                case "4":
                    gerarFatura();
                    break;
                case "5":
                    System.out.println("A sair...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void inserirCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();

        sistema.adicionarCliente(nome, numero);
        System.out.println("Cliente adicionado.");
    }

    private static void inserirChamada() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int segundos = Integer.parseInt(scanner.nextLine());

        sistema.registrarChamada(nome, destino, segundos);
    }

    private static void consultar() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        Cliente cliente = sistema.procurarCliente(nome);
        if (cliente == null) {
            System.out.println("Cliente não existe.");
            return;
        }

        java.util.List<Chamada> chamadas = sistema.obterChamadasCliente(cliente);
        for (Chamada c : chamadas) {
            System.out.println("Destino: " + c.getDestino()
                    + " | Segundos: " + c.getDuracaoSegundos()
                    + " | Região: " + c.getRegiao()
                    + " | Valor: " + c.getValor());
        }
    }

    private static void gerarFatura() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        Cliente cliente = sistema.procurarCliente(nome);
        if (cliente == null) {
            System.out.println("Cliente não existe.");
            return;
        }

        java.util.List<Chamada> chamadas = sistema.obterChamadasCliente(cliente);
        Fatura.gerarFatura(cliente, chamadas);
    }
}
