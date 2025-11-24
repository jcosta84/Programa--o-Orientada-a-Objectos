package Projecto_2;
import java.util.ArrayList;
import java.util.List;

public class RestauranteSistema {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(String nome) {
        clientes.add(new Cliente(nome));
    }

    public Cliente procurarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public void registrarPedido(String nomeCliente, Produto prod, int quant) {
        Cliente c = procurarCliente(nomeCliente);
        if (c != null) {
            c.adicionarPedido(new Pedido(prod, quant));
        }
    }

    public List<Pedido> obterPedidosCliente(Cliente c) {
        return c.getPedidos();
    }
}