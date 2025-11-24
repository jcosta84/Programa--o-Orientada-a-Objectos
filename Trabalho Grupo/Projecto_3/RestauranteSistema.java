package Projecto_3;

import java.io.*;
import java.util.*;

public class RestauranteSistema {

    private List<Cliente> clientes = new ArrayList<>();
    private static final String CLIENTES_FILE = "C:\\Users\\EDEC\\Dropbox\\US\\Disciplinas\\2º Ano\\Programação Orientada a Objectos\\Trabalho Grupo\\Projecto_3\\clientes.csv";
    private static final String PEDIDOS_FILE = "C:\\Users\\EDEC\\Dropbox\\US\\Disciplinas\\2º Ano\\Programação Orientada a Objectos\\Trabalho Grupo\\Projecto_3\\pedidos.csv";

    public RestauranteSistema() {
        carregarClientes();
        carregarPedidos();
    }

    public void adicionarCliente(String nome) {
        Cliente c = new Cliente(nome);
        clientes.add(c);
        salvarCliente(c);
    }

    public Cliente procurarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    public void registrarPedido(String nomeCliente, Produto prod, int quant) {
        Cliente c = procurarCliente(nomeCliente);
        if (c != null) {
            Pedido p = new Pedido(prod, quant);
            c.adicionarPedido(p);
            salvarPedido(c, p);
        }
    }

    public List<Pedido> obterPedidosCliente(Cliente c) {
        return c.getPedidos();
    }

    // =================== Persistência CSV ===================

    private void salvarCliente(Cliente c) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CLIENTES_FILE, true))) {
            pw.println(c.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarPedido(Cliente c, Pedido p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(PEDIDOS_FILE, true))) {
            pw.println(c.getNome() + "," + p.getProduto().getNome() + "," + p.getProduto().getPreco() + "," + p.getQuantidade());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarClientes() {
        File f = new File(CLIENTES_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                clientes.add(new Cliente(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarPedidos() {
        File f = new File(PEDIDOS_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    String nomeCliente = partes[0];
                    String nomeProduto = partes[1];
                    double preco = Double.parseDouble(partes[2]);
                    int qtd = Integer.parseInt(partes[3]);

                    Cliente c = procurarCliente(nomeCliente);
                    if (c != null) {
                        c.adicionarPedido(new Pedido(new Produto(nomeProduto, preco), qtd));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}