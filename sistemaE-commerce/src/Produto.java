public class Produto {
    /*nome do produto, código do produto, categoria do produto, valor do produto, descrição do produto. */
    
    private String nome;
    private int codigo;
    private String categoria;
    private double valor;
    private String descricao;

    
    public Produto(String nome, int codigo, String categoria, double valor, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
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


    

}
