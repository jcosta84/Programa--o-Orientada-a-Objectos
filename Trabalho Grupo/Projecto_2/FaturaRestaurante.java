package Projecto_2;
import java.io.PrintWriter;
import java.util.List;

public class FaturaRestaurante {

    public static void gerar(Cliente cliente, List<Pedido> pedidos) {
        try (PrintWriter pw = new PrintWriter("Fatura_" + cliente.getNome() + ".txt")) {

            pw.println("===== RESTAURANTE CENTRAL =====");
            pw.println("CLIENTE: " + cliente.getNome());
            pw.println("-------------------------------------");
            pw.printf("%-20s %-10s %-10s%n", "Produto", "Qtd", "Total");

            double total = 0;

            for (Pedido p : pedidos) {
                double valor = p.getTotal();
                pw.printf("%-20s %-10d %-10.2f%n",
                        p.getProduto().getNome(),
                        p.getQuantidade(),
                        valor);
                total += valor;
            }

            pw.println("-------------------------------------");
            pw.printf("TOTAL A PAGAR: %.2f ECV%n", total);

        } catch (Exception e) {
            System.out.println("Erro ao gerar fatura.");
        }
    }
}
