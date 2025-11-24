package Projecto_3;

public class Pedido {
    private Produto produto;
    private int quantidade;

    public Pedido(Produto produto, int quantidade) {   // <- precisa estar assim
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public double getTotal() {
        return quantidade * produto.getPreco();
    }
}