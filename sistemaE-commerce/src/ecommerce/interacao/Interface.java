package ecommerce.interacao;

import java.util.Scanner;
// interface da primeira página

//import ecommerce.pessoas.Pessoa;
public class Interface {
   // private Pessoa pessoa;
    public int opc;
    private Scanner scanner;

    public Interface() {
        this.opc = -1;
        this.scanner = new Scanner(System.in);
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
                    System.out.println("Tela para cadastro em criação");
                    continuar = false;
                    break;
                case 3:
                    limparTerminal();
                    System.out.println("Tela para comprar em criação");
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

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

}
