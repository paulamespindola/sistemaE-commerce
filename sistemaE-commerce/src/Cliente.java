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
    
    
    public void adicionarProduto(Produto produto, int quantidade){
        if(quantidade <= 5){
            for(int i = 0; i < quantidade; i++){ // Correção aqui
                carrinhoDeCompras.add(produto);
            }
            System.out.println("Produto(s) adicionado(s) no carrinho com sucesso!");
        } else {
            System.out.println("Ops! O limite máximo de quantidade é de 5 itens.");
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
        System.out.println("\n\t\tProdutos em Estoque");
        System.out.println("\n-------------------------------------------------");
        for (Produto produto  : carrinhoDeCompras) {
            System.out.println("\nNome: " + produto.getNome() + "\nPreço: " + produto.getValor());
            System.out.println("\n-------------------------------------------------");
        }
    }
    
}
