package ecommerce.pessoas;

public class Adm extends Pessoa{


    public Adm() {
        super("Administrador", "11111111111", "81999999999",
         "adm@ecommerce.com", "adm@123");

    }

    public boolean verificarSenha(String senha) {
        return this.getSenha().equals(senha);
    }

    
}
