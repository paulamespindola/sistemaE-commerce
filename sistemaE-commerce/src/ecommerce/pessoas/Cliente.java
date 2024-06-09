package ecommerce.pessoas;

import java.util.ArrayList;
import java.util.List;

import ecommerce.estoque.Produto;


public class Cliente extends Pessoa {
    private int idCliente;
    private String endereco;

    public String getEndereco() {
        return endereco;
    }



    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    private List<Produto> carrinhoDeCompras;
    
    

   public Cliente(String nome, String cpf, String telefone, String email, String senha, String endereco) {
        super(nome, cpf, telefone, email, senha);
        this.endereco = endereco;
        this.carrinhoDeCompras = new ArrayList<>();
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
                            p.setQuantidadeCarrinho(p.getQuantidadeCarrinho() + quantidade);
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
    
    

    public void editarQuantidadeProduto(Produto produto, int novaQuantidade) {
        // Verificar se o produto está no carrinho
        boolean produtoNoCarrinho = false;
        for (Produto p : carrinhoDeCompras) {
            if (p.getCodigo() == produto.getCodigo()) {
                produtoNoCarrinho = true;
                // Atualizar a quantidade do produto no carrinho
                p.setQuantidadeCarrinho(novaQuantidade);
                System.out.println("Quantidade do produto " + produto.getNome() + " atualizada para " + novaQuantidade);
                break;
            }
        }
        if (!produtoNoCarrinho) {
            System.out.println("O produto não está no carrinho.");
        }
    }
    
    
    public void removerProdutoDoCarrinho(Produto produto) {
        // Verificar se o produto está no carrinho
        boolean produtoNoCarrinho = false;
        for (Produto p : carrinhoDeCompras) {
            if (p.getCodigo() == produto.getCodigo()) {
                produtoNoCarrinho = true;
                carrinhoDeCompras.remove(p);
                System.out.println("Produto " + produto.getNome() + " removido do carrinho.");
                break;
            }
        }
        if (!produtoNoCarrinho) {
            System.out.println("O produto não está no carrinho.");
        }
    }
    
    public void exibirCarrinho(){
        System.out.println("\n***************************************************");
        System.out.println("\t\tCarrinho de Compras");
        System.out.println("---------------------------------------------------");
        for (Produto produto  : carrinhoDeCompras) {
            System.out.println("\nNome: " + produto.getNome() + "\nPreço: " + produto.getValor() + "\t      Quantidade: " + produto.getQuantidadeCarrinho());
            System.out.println("\n-------------------------------------------------");
        }
    }

    @Override
    public void login() {
        super.login();

    }

    public boolean verificarSenha(String senha) {
        return this.getSenha().equals(senha);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }
    public void setCarrinhoDeCompras(List<Produto> carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

 
   
     
    
}
