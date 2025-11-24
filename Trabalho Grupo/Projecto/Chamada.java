package Projecto;
public class Chamada {
    private Cliente cliente;
    private String destino;
    private int duracaoSegundos;
    private String regiao;
    private double valor;

    public Chamada(Cliente cliente, String destino, int duracaoSegundos, Tarifario tarifario) {
        this.cliente = cliente;
        this.destino = destino;
        this.duracaoSegundos = duracaoSegundos;
        this.regiao = tarifario.detectarRegiao(destino);
        this.valor = tarifario.calcularValor(destino, duracaoSegundos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDestino() {
        return destino;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return cliente.getNome() + "," + destino + "," + duracaoSegundos;
    }
}
