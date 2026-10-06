    import java.util.Scanner;

public class App {
            // Método para avaliar a força da senha
        public static String avaliarSenhas(String senha) {
            // Verificar se a senha tem pelo menos 8 caracteres
            if (senha.length() < 8) {
            return "DICA: A senha deve ter no mínimo 8 caracteres.";
        }
        // Verificar se a senha contém pelo menos um número
        boolean temNumero = false;
           // Loop para verificar cada caractere da senha 
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) { 
                temNumero = true;
                break;
            }
        }

        // Exibir mensagem de dica se a senha não contiver números
        if (!temNumero) {
            return "DICA: A senha deve conter pelo menos um número.";
        }

         // Amarzenar senhas óbvias
        String[] senhasObvias = {"12345678", "senha123", "admin123"};
            // Verificar se a senha é uma das senhas obvias
        for (String senhaObvia : senhasObvias) {
            if (senha.equals(senhaObvia)) {
                return "ALERTA: Esta senha é muito comum e óbvia.";
            }
        }
             
        boolean temLetraMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temLetraMaiuscula = true;
                break;
            }
        }

        // Exibir mensagem de dica se a senha não contiver letras maiúsculas
        if (!temLetraMaiuscula) {
            return "DICA: A senha deve conter pelo menos uma letra maiúscula.";
        }

        // Retorno "OK" se a senha atender a todos os critérios
        return "SUCESSO: Sua senha passou nos critérios básicos";

    }
        // Método principal para testar a função de avaliação de senhas
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
        // Loop para solicitar a senha até que seja válida
        while (true) {
            // Solicitar ao usuário que digite a senha
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
                // Avaliar a senha e exibir o resultado
            String resultado = avaliarSenhas(senha);
            System.out.println(resultado);
                // Se a senha for válida, sair do loop
            if (resultado.equals("SUCESSO: Sua senha passou nos critérios básicos")) {
                break;
            }
        }
    
        // Fechar o scanner para liberar recursos
        scanner.close();
    }
}
