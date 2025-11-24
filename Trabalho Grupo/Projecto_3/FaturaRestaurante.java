package Projecto_3;

import java.io.PrintWriter;
import java.util.List;
import java.io.File;

public class FaturaRestaurante {

    private static final String PASTA_FATURAS = "C:\\\\Users\\\\EDEC\\\\Dropbox\\\\US\\\\Disciplinas\\\\2º Ano\\\\Programação Orientada a Objectos\\\\Trabalho Grupo\\\\Projecto_3\\\\faturas"; // pasta onde salvar

    public static void gerar(Cliente cliente, List<Pedido> pedidos) {
        try {
            // cria a pasta se não existir
            File pasta = new File(PASTA_FATURAS);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            // caminho completo do arquivo
            String caminhoFatura = PASTA_FATURAS + File.separator + "Fatura_" + cliente.getNome() + ".txt";

            try (PrintWriter pw = new PrintWriter(caminhoFatura)) {

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
            }

            System.out.println("Fatura gerada em: " + caminhoFatura);

        } catch (Exception e) {
            System.out.println("Erro ao gerar fatura: " + e.getMessage());
        }
    }
}