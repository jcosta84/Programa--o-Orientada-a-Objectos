package Projecto_2;
import java.util.Scanner;

public class RestauranteMain {

    private static Scanner scanner = new Scanner(System.in);
    private static RestauranteSistema sistema = new RestauranteSistema();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== MENU RESTAURANTE ====");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Registar Pedido");
            System.out.println("3. Consultar Cliente");
            System.out.println("4. Gerar Fatura");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": inserirCliente(); break;
                case "2": registrarPedido(); break;
                case "3": consultarCliente(); break;
                case "4": gerarFatura(); break;
                case "5": System.exit(0);
                default: System.out.println("Opção inválida");
            }
        }
    }

    private static void inserirCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        sistema.adicionarCliente(nome);
        System.out.println("Cliente adicionado!");
    }

    private static void registrarPedido() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Produto: ");
        String produto = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        sistema.registrarPedido(nome, new Produto(produto, preco), qtd);
        System.out.println("Pedido registado!");
    }

    private static void consultarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Cliente c = sistema.procurarCliente(nome);
        if (c == null) {
            System.out.println("Cliente não existe.");
            return;
        }

        for (Pedido p : c.getPedidos()) {
            System.out.println("Produto: " + p.getProduto().getNome() +
                    " | Quant: " + p.getQuantidade() +
                    " | Total: " + p.getTotal());
        }
    }

    private static void gerarFatura() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Cliente c = sistema.procurarCliente(nome);
        if (c == null) {
            System.out.println("Cliente não existe.");
            return;
        }

        FaturaRestaurante.gerar(c, sistema.obterPedidosCliente(c));
        System.out.println("Fatura gerada!");
    }
}
