package ecommerce.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
    public static boolean validarNome(String nome) {
        
        return nome.length() > 10 && nome.matches("[a-zA-ZÀ-ú ]+");
    }

    public static boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarTelefone(String telefone) {
        return telefone.matches("\\d{11}");
    }

    public static boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
}
