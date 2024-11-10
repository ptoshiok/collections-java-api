package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itensCarrinho;

    public CarrinhoDeCompras() {
        this.itensCarrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itensCarrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensARemover = new ArrayList<>();
        for (Item i: itensCarrinho) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itensARemover.add(i);
            }
        }

        itensCarrinho.removeAll(itensARemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itensCarrinho.isEmpty()) {
            for (Item item : itensCarrinho) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        System.out.println(itensCarrinho);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.adicionarItem("Banana", 0.50, 10);
        carrinhoDeCompras.adicionarItem("Maca", 0.25, 5);
        carrinhoDeCompras.adicionarItem("Macarrao", 6.50, 1);

        carrinhoDeCompras.exibirItens();
        System.out.println(carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Maca");
        carrinhoDeCompras.exibirItens();
        System.out.println(carrinhoDeCompras.calcularValorTotal());
    }
}
