package Projecto;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;

public class Fatura {

    private static final String PASTA_FATURAS = "C:\\Users\\EDEC\\Dropbox\\US\\Disciplinas\\2º Ano\\Programação Orientada a Objectos\\Trabalho Grupo\\Projecto\\faturas";

    public static void gerarFatura(Cliente cliente, List<Chamada> chamadas) {
        double total = 0;

        // cria pasta "faturas" se não existir
        File pasta = new File(PASTA_FATURAS);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // caminho completo do arquivo
        String nomeFicheiro = PASTA_FATURAS + File.separator + "Fatura_" + cliente.getNome() + ".txt";

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

        System.out.println("Fatura gerada em: " + nomeFicheiro);
    }
}