import java.util.ArrayList;
import java.util.List;


public class Estoque {
    private List<Produto> produtosEmEstoque;

    public Estoque() {
        this.produtosEmEstoque = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade){
        produto.setQuantidadeEstoque(quantidade);
        produtosEmEstoque.add(produto);
    }

    public void removerProduto(Produto produto){
        produtosEmEstoque.remove(produto);
    }

   
    public void listarProduto(){
        System.out.println("***************************************************");
        System.out.println("\n\t\tProdutos em Estoque");
        System.out.println("\n-------------------------------------------------");
        for (Produto produto : produtosEmEstoque) {
            System.out.println("\nNome: " + produto.getNome() + "\nPreço: " + produto.getValor() + "\nQuantidade em estoque: " + produto.getQuantidadeEstoque());
            System.out.println("\n-------------------------------------------------");
        }
    }


    
}
