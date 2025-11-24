package Projecto;
public class Tarifario {

    public String detectarRegiao(String destino) {
        if (destino.startsWith("+") || destino.startsWith("00")) return "Internacional";
        if (destino.startsWith("2") || destino.startsWith("3") || destino.startsWith("5") || destino.startsWith("9"))
            return "Nacional";
        return "Desconhecida";
    }

    public double calcularValor(String destino, int tempoSegundos) {
        double preco;

        if (destino.startsWith("+") || destino.startsWith("00")) {
            preco = 1.05;
        } else if (destino.startsWith("2") || destino.startsWith("3")) {
            preco = 0.24;
        } else if (destino.startsWith("8") || destino.startsWith("9")) {
            preco = 0.43;
        } else {
            return 0;
        }

        return tempoSegundos * preco;
    }
}
