import java.util.Scanner;

public class Interface {
    public int opc;
    

    Scanner scanner;

    public Interface() {
        this.opc = -1;
        this.scanner = new Scanner(System.in);
    }

    public String titulo(){
        return "***********************************" + "\n\t    E-commerce" + "\n***********************************";
    }

    public void telaPrincipal(){

        System.out.println(titulo());
        System.out.println("\n\t   TIPO DA CONTA\n\nDigite a opção desejada");
        System.out.println("\n1 - Cliente\n2 - Administrador");
        setOpc(scanner.nextInt());
        switch (getOpc()) {
            case 1:
                System.out.println("Olá, cliente");
                break;
        
            default:
                break;
        }


    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }





}
