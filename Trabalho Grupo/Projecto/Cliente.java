package Projecto;
public class Cliente {
    private String nome;
    private String numero;

    public Cliente(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | Número: " + numero;
    }
}
