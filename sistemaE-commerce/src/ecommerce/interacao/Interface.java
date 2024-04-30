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
                    telaCliente();
                    break;
                case 2: 
                    // Implementar tela de administrador
                    break;
                case 0:
                    continuar = false; 
                    break;
                default:
                    opcaoInvalida();
                    break;
                    
            }
        } while (continuar); 
    }
    

    public void telaCliente(){
        
        System.out.println(titulo());
        System.out.println("Digite uma opção:");
        System.out.println("1 - Login\n2 - Cadastro\n3 - Comprar\n4 - Exibir Carrinho\n0 - Voltar");
    }
    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
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

}
