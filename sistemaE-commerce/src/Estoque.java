import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtosEmEstoque;

    public Estoque() {
        produtosEmEstoque = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        String nomeProduto = produto.getNome();
        int quantidadeAtual = produtosEmEstoque.getOrDefault(nomeProduto, 0);
        produtosEmEstoque.put(nomeProduto, quantidadeAtual + quantidade);
    }

    public void removerProduto(Produto produto, int quantidade) {
        String nomeProduto = produto.getNome();
        int quantidadeAtual = produtosEmEstoque.getOrDefault(nomeProduto, 0);
        if (quantidade <= quantidadeAtual) {
            produtosEmEstoque.put(nomeProduto, quantidadeAtual - quantidade);
        } else {
            System.out.println("Quantidade insuficiente em estoque para remover.");
        }
    }


    
}
