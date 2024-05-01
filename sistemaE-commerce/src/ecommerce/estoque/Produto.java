package ecommerce.estoque;
public class Produto {
    /*nome do produto, código do produto, categoria do produto, valor do produto, descrição do produto. */
    
    private String nome;
    private int codigo;
    private String categoria;
    private double valor;
    private String descricao;
    private int quantidadeEstoque;
    private int quantidadeCarrinho;

    

    public Produto(String nome, int codigo, String categoria, double valor, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
    }

    public void exibirProduto(){
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("\n\t\t\t\t   Produto " );
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("\nCódigo: " + getCodigo() +"\nCategoria:"+getCategoria()+"\n\nNome: " + getNome() + "\n\nPreço: " + getValor() + "\n\nDescrição: " + getDescricao());

        if(getQuantidadeEstoque() == 0){
            System.out.println("\n\nSTATUS\nOPS! O produto está fora de estoque :/");
        }else if(getQuantidadeEstoque() < 5 ){
            System.out.println("ALERTA!! ÚLTIMAS UNIDADES\n" + "Qunatidade: " + getQuantidadeEstoque());
        } 
            
        //System.out.println("----------------------------------------------------------------------------------");

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

        
    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

}
