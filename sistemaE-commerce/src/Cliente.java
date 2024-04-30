import java.util.ArrayList;
import java.util.List;


public class Cliente extends Pessoa {
    private int idCliente;
    private List<Produto> carrinhoDeCompras;
    
    
    


    public Cliente(String nome, int cpf, int telefone, String email, int idCliente) {
        super(nome, cpf, telefone, email);
        this.idCliente = idCliente;
        this.carrinhoDeCompras = new ArrayList<>();
    }



    public void cadastrar(){

    }
    
    
    public void adicionarProduto(Produto produto, int quantidade) {
        // Verificar se há quantidade suficiente em estoque
        if (quantidade <= produto.getQuantidadeEstoque()) {
            // Verificar se a quantidade excede o limite permitido por produto
            if (quantidade <= 5) {
                // Verificar se o produto já está no carrinho
                boolean produtoJaNoCarrinho = false;
                for (Produto p : carrinhoDeCompras) {
                    if (p.getCodigo() == produto.getCodigo()) {
                        produtoJaNoCarrinho = true;
                        break;
                    }
                }
                // Se o produto já estiver no carrinho, apenas atualize a quantidade
                if (produtoJaNoCarrinho) {
                    for (Produto p : carrinhoDeCompras) {
                        if (p.getCodigo() == produto.getCodigo()) {
                            p.setQuantidadeCarrinho(p.GetQuantidadeCarrinho() + quantidade);
                            break;
                        }
                    }
                } else {
                    // Caso contrário, adicione o produto ao carrinho
                    produto.setQuantidadeCarrinho(quantidade);
                    carrinhoDeCompras.add(produto);
                }
                System.out.println("Produto(s) adicionado(s) no carrinho com sucesso!");
            } else {
                System.out.println("Ops! O limite máximo de quantidade por produto é de 5 itens.");
            }
        } else {
            System.out.println("Ops! Quantidade indisponível em estoque.");
        }
    }
    
    

    public void editarQuantProduto(Produto produto, int quantidadeNova){

    }
    
    public void removerProduto(Estoque estoque, Produto produto){
        carrinhoDeCompras.remove(produto);
    }

    @Override
    public void login() {
        super.login();

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
   
     public void exibirCarrinho(){
        System.out.println("***************************************************");
        System.out.println("\n\t\tCarrinho de Compras");
        System.out.println("\n-------------------------------------------------");
        for (Produto produto  : carrinhoDeCompras) {
            System.out.println("\nNome: " + produto.getNome() + "\nPreço: " + produto.getValor() + "\t      Quantidade: " + produto.GetQuantidadeCarrinho());
            System.out.println("\n-------------------------------------------------");
        }
    }
    
}
