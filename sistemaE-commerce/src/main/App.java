package main;

import ecommerce.estoque.Estoque;
import ecommerce.estoque.Produto;
import ecommerce.interacao.Interface;
import ecommerce.telas.TelaPrincipal;

public class App {
    public static void main(String[] args) {
        // Criar uma instância da classe Estoque
        Estoque estoque = new Estoque();

        // Criar os produtos
        Produto produto1 = new Produto("Geladeira Brastemp Frost Free", 1, "Eletrodomésticos", 2850.85, "A Geladeira Brastemp Frost Free Duplex...");
        Produto produto2 = new Produto("Fogão Consul 4 bocas", 2, "Eletrodomésticos", 1400.95, "Fogão Consul 4 bocas cor Inox...");
        Produto produto3 = new Produto("Sofá 3 lugares MUY", 3, "Móveis", 1799.00, "Perfeita para relaxar em frente à TV...");
        Produto produto4 = new Produto("Cama Box Colchão + Base Attractive Casal", 4, "Móveis", 999.90, "Colchão Casal Umaflex de Mola Ensacada...");

        // Adicionar os produtos ao estoque
        estoque.adicionarProduto(produto1, 10);
        estoque.adicionarProduto(produto2, 15);
        estoque.adicionarProduto(produto3, 20);
        estoque.adicionarProduto(produto4, 8);

        // Inicializar a interface
        Interface interacao = new Interface(estoque);
        TelaPrincipal telaPrincipal = new TelaPrincipal(interacao);
        telaPrincipal.setVisible(true);
    }
}
