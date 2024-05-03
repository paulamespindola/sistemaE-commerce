package ecommerce.interacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// interface da primeira página

import ecommerce.estoque.Estoque;
import ecommerce.estoque.Produto;
import ecommerce.pessoas.Cliente;
import ecommerce.validador.Validacao;

//import ecommerce.pessoas.Pessoa;
public class Interface {
   // private Pessoa pessoa;
    public int opc;
    private Estoque estoque;
    private Scanner scanner;
    private List<Cliente> clientesCadastrados;

    public Interface(Estoque estoque) {
        this.opc = -1;
        this.scanner = new Scanner(System.in);
        this.estoque = estoque;
        this.clientesCadastrados = new ArrayList<>();
    }

    public String titulo(){
        return "***********************************" + "\n\t    E-commerce" + "\n***********************************";
    }

    public void telaPrincipal(){
        boolean continuar = true; // Variável de controle do loop
        
        do {
            limparTerminal();
            System.out.println(titulo());
            System.out.println("\n\t   TIPO DA CONTA\n\nDigite a opção desejada");
            System.out.println("\n1 - Cliente\n2 - Administrador");
            setOpc(scanner.nextInt());
            
            switch (getOpc()) {
                case 1:
                    limparTerminal();
                    telaPrincipalCliente();
                    break;
                case 2: 
                    limparTerminal();
                    telaPrincipalAdm();
                    break;
                case 0:
                    continuar = false; 
                    break;
                default:
                    opcaoInvalida();
                    break;
                    
            }
        } while (continuar == false); 
    }
    

    public void telaPrincipalCliente() {
        boolean continuar = true;
        while (continuar) {
            limparTerminal();
            System.out.println(titulo());
            System.out.println("Seja bem-vindo(a) cliente!");
            System.out.println("\nDigite uma opção:");
            System.out.println("1 - Login\n2 - Cadastro\n3 - Comprar\n4 - Exibir Carrinho\n0 - Voltar");
    
            opc = scanner.nextInt();
    
            switch (opc) {
                case 1:
                    limparTerminal();
                    System.out.println("Tela para login em criação");
                    // Método login
                    continuar = false;
                    break;
                case 2:
                    limparTerminal();
                    System.out.println(titulo());
                    cadastroCliente();
                    continuar = false;
                    break;
                case 3:
                    limparTerminal();
                    telaComprar();
                    continuar = false;
                    break;
                case 4:
                    limparTerminal();
                    System.out.println("Tela para mostrar carrinho em criação");
                    continuar = false;
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    opcaoInvalida();
                    break;
            }
        }
    }
    
    public void telaComprar() {
        while (true) {
            System.out.println(titulo());
            System.out.println("Digite o número da respectiva categoria:");
            System.out.println("1 - Eletrodomésticos");
            System.out.println("2 - Móveis");
            System.out.println("0 - Voltar");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    limparTerminal();
                    exibirProdutos("Eletrodomésticos");
                    break;
                case 2:
                    exibirProdutos("Móveis");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public void exibirProdutos(String categoria) {
        List<Produto> produtos = estoque.getProdutosPorCategoria(categoria);
        System.out.println(titulo());
        System.out.println("Produtos da categoria " + categoria);
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println();
            System.out.println((i + 1) + " - " + produtos.get(i).getNome());
        }

        System.out.println("\nDigite o número do produto que deseja visualizar:");
        int opcao = scanner.nextInt();
        if (opcao >= 1 && opcao <= produtos.size()) {
            Produto produtoSelecionado = produtos.get(opcao - 1);
            produtoSelecionado.exibirProduto();
            System.out.println("\nAdicionar ao carrinho de compras(1-sim/0-não)?");
            opcao = scanner.nextInt();
            //implementar lógica para adicionar ao carrinho
        } else {
            System.out.println("Opção inválida.");
        }
    }


    

    public void telaPrincipalAdm(){
    
        boolean continuar = true;
        do {
            limparTerminal();
            System.out.println(titulo());
            System.out.println("Seja bem-vindo(a) administrador!");
            System.out.println("\nDigite uma opção:");
            System.out.println("1 - Login\n0 - Voltar");
    
            opc = scanner.nextInt(); 
    
            switch (opc) {
                case 1:
                    limparTerminal();
                    System.out.println(titulo());
                    System.out.println("Tela para login em criação");
                    continuar = false;
                    // Método login
                    break;
                case 0:
                    telaPrincipal();
                    continuar = false;
                    break;
                default:
                    opcaoInvalida();
                    break;
            }
        } while (continuar);

    }


    public void telaPrincipalClienteComprar(){
        System.out.println(titulo());
        System.out.println("\nDigite uma das opções:");
        System.out.println("1 - Eletrodomésticos\n2 - Móveis");

        boolean continuar = true;
        opc = scanner.nextInt();
        do {
            switch (opc) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        } while (continuar);
    }

    public void adicionarCliente(Cliente cliente){
        clientesCadastrados.add(cliente);
    }


    public void cadastroCliente(){

        Cliente cliente = new Cliente();
        scanner.nextLine();
        System.out.println("\n\tCadastro de Cliente");
        System.out.println("Digite os dados abaixo.");
        
        do {
            System.out.println("Nome: ");
            String nome = "";
            do {
                nome = scanner.nextLine();
                // Validar o nome
                if (!Validacao.validarNome(nome)) {
                    System.out.println("Nome inválido. O nome deve conter mais de 10 caracteres e apenas letras.");
                }
            } while (!Validacao.validarNome(nome)); 
     
            cliente.setNome(nome);
     
            System.out.println("Email: ");
            String email = "";
            do {
                email = scanner.nextLine();
                // Validar o email
                if (!Validacao.validarEmail(email)) {
                    System.out.println("Email inválido. O email deve seguir o formato correto.");
                }
            } while (!Validacao.validarEmail(email));
            cliente.setEmail(email);
     
            System.out.println("Telefone: ");
            String telefone = "";
            do {
                telefone = scanner.nextLine();
                // Validar o telefone
                if (!Validacao.validarTelefone(telefone)) {
                    System.out.println("Telefone inválido. O telefone deve conter 11 dígitos.");
                }
            } while (!Validacao.validarTelefone(telefone));
            cliente.setTelefone(telefone);
     
            System.out.println("CPF: ");
            String cpf = "";
            do {
                cpf = scanner.nextLine();
                // Validar o CPF
                if (!Validacao.validarCPF(cpf)) {
                    System.out.println("CPF inválido. O CPF deve conter 11 dígitos numéricos.");
                }
            } while (!Validacao.validarCPF(cpf));
            cliente.setCpf(cpf);

            //implememtar lógica da senha
     
            cliente.setIdCliente(clientesCadastrados.size() + 1);
            System.out.println("\nConfirmar cadastro(1-sim/0 não)?");
            setOpc(scanner.nextInt());
            switch (opc) {
                case 1:
                    adicionarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!!");
                    break;        
                case 0: 
                    saindo();
                    telaPrincipalCliente();
                    break; 
                default:
                    System.out.println("Caractere incorreto.");
                    break;
            }
        } while (opc != 0);
     }
     


    private void limparTerminal() {
        try {
            // Verificar o sistema operacional
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Tratar exceção, se necessário
            e.printStackTrace();
        }
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        try {
            Thread.sleep(1000); // Aguardar 2 segundos
        } catch (InterruptedException e) {
            // Lidar com exceção, se necessário
            e.printStackTrace();
        }
    }

    public void saindo(){
        System.out.println("Saindo...");
        try {
            Thread.sleep(1000); // Aguardar 2 segundos
        } catch (InterruptedException e) {
            // Lidar com exceção, se necessário
            e.printStackTrace();
        }
    }
    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

}
