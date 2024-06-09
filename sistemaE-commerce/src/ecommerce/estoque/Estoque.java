package ecommerce.estoque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
    }

    public void removerProduto(Produto produto, int quantidade) {
        int quantidadeAtual = produtos.getOrDefault(produto, 0);
        if (quantidadeAtual >= quantidade) {
            produtos.put(produto, quantidadeAtual - quantidade);
        }
    }

    public int verificarQuantidade(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }

    public Produto buscarProduto(int idProduto) {
        for (Produto produto : produtos.keySet()) {
            if (produto.getCodigo() == idProduto) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos.keySet());
    }

    public String listarProduto() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            sb.append("ID: ").append(entry.getKey().getCodigo())
              .append(", Nome: ").append(entry.getKey().getNome())
              .append(", Quantidade: ").append(entry.getValue())
              .append(", Preço: R$").append(entry.getKey().getValor()).append("\n");
        }
        return sb.toString();
    }

    public List<Produto> getProdutosPorCategoria(String categoria) {
        List<Produto> produtosPorCategoria = new ArrayList<>();
        for (Produto produto : produtos.keySet()) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                produtosPorCategoria.add(produto);
            }
        }
        return produtosPorCategoria;
    }

    public List<Produto> getProdutosEmEstoque() {
        List<Produto> produtosEmEstoque = new ArrayList<>();
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            if (entry.getValue() > 0) {
                produtosEmEstoque.add(entry.getKey());
            }
        }
        return produtosEmEstoque;
    }
}
