package ecommerce.interacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ecommerce.estoque.Estoque;
import ecommerce.estoque.Produto;
import ecommerce.pessoas.Adm;
import ecommerce.pessoas.Cliente;


public class Interface {
    private int opc;
    private Estoque estoque;
    private Scanner scanner;
    private List<Cliente> clientesCadastrados;
    private Cliente clienteAtual;
    private Adm adm;
    private List<Produto> carrinhoDeComprasZero;
    private boolean loginClienteFeito;

    public Interface(Estoque estoque) {
        this.opc = -1;
        this.scanner = new Scanner(System.in);
        this.estoque = estoque;
        this.clientesCadastrados = new ArrayList<>();
        this.adm = new Adm();
        this.carrinhoDeComprasZero = new ArrayList<>();
        this.loginClienteFeito = false;
    }

    public boolean loginAdm(String email, String senha) {
        if (email.equals(adm.getEmail()) && adm.verificarSenha(senha)) {
            return true;
        }
        return false;
    }

    public boolean loginCliente(String email, String senha) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getEmail().equals(email) && cliente.verificarSenha(senha)) {
                this.clienteAtual = cliente;
                this.loginClienteFeito = true;
                return true;
            }
        }
        return false;
    }

    public void adicionarCliente(Cliente cliente) {
        clientesCadastrados.add(cliente);
    }

    public List<Produto> getProdutosPorCategoria(String categoria) {
        return estoque.getProdutosPorCategoria(categoria);
    }

    public void adicionarNoCarrinho(Produto produto, int quantidade) {
        if (loginClienteFeito) {
            clienteAtual.adicionarProduto(produto, quantidade);
        } else {
            produto.setQuantidadeCarrinho(quantidade);
            carrinhoDeComprasZero.add(produto);
        }
    }

   
    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public void setClientesCadastrados(List<Cliente> clientesCadastrados) {
        this.clientesCadastrados = clientesCadastrados;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public Adm getAdm() {
        return adm;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }

    public List<Produto> getCarrinhoDeComprasZero() {
        return carrinhoDeComprasZero;
    }

    public void setCarrinhoDeComprasZero(List<Produto> carrinhoDeComprasZero) {
        this.carrinhoDeComprasZero = carrinhoDeComprasZero;
    }

    public boolean isLoginClienteFeito() {
        return loginClienteFeito;
    }

    public void setLoginClienteFeito(boolean loginClienteFeito) {
        this.loginClienteFeito = loginClienteFeito;
    }

    // Outros atributos e métodos...

    public void adicionarProdutoEstoque(Produto produto, int quantidade) {
        estoque.adicionarProduto(produto, quantidade);
    }

    public void removerProdutoEstoque(Produto produto, int quantidade) {
        estoque.removerProduto(produto, quantidade );
    }

   

    public Produto buscarProduto(String nome) {
        return estoque.buscarProduto(nome);
    }

    public void atualizarProdutoEstoque(Produto produto, String novoNome, double novoPreco, int novaQuantidade) {
        produto.setNome(novoNome);
        produto.setValor(novoPreco);
        produto.setQuantidadeEstoque(novaQuantidade);
        // Se necessário, atualizar o produto no estoque
    }

   

}
