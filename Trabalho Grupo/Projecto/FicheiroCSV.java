package Projecto;
import java.io.*;
import java.util.ArrayList;

public class FicheiroCSV {

    public static void escreverLinha(String arquivo, String linha) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(arquivo, true))) {
            out.println(linha);
        }
    }

    public static ArrayList<String> lerTodasLinhas(String arquivo) throws IOException {
        ArrayList<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }
}
