package Projecto;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;

public class Fatura {

    public static void gerarFatura(Cliente cliente, List<Chamada> chamadas) {
        double total = 0;
        String nomeFicheiro = "Fatura_" + cliente.getNome() + ".txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFicheiro))) {

            pw.println("----------- FACTURA -----------");
            pw.println("Empresa de Telecomunicações US");
            pw.println("Cliente: " + cliente.getNome());
            pw.println("Número: " + cliente.getNumero());
            pw.println("--------------------------------\n");

            pw.printf("%-20s %-10s %-15s %-10s%n", "Destino", "Segundos", "Região", "Valor");

            for (Chamada c : chamadas) {
                if (c.getCliente().getNome().equalsIgnoreCase(cliente.getNome())) {
                    pw.printf("%-20s %-10d %-15s %-10.2f%n",
                            c.getDestino(), c.getDuracaoSegundos(), c.getRegiao(), c.getValor());
                    total += c.getValor();
                }
            }

            pw.println("\nTOTAL: " + String.format("%.2f ECV", total));

        } catch (IOException e) {
            System.out.println("Erro ao escrever fatura: " + e.getMessage());
        }

        System.out.println("Fatura gerada: " + nomeFicheiro);
    }
}
