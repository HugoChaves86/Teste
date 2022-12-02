package trabalhofinalengsoft;

import trabalhofinalengsoft.command.Console;
import java.util.Scanner;

/**
 *
 * @author Hugo_Chaves
 */
public class Programa {

    public static void main(String[] args) {
            
        Scanner teclado = new Scanner(System.in);
        Console console = new Console();

        String comando;   
    
        do{
            
            System.out.println("\n============================");
            System.out.println("======== Biblioteca ========");
            System.out.println("============================\n");
            System.out.println("======== Operações ========");
            System.out.println("===========================\n");
            System.out.println("Digite 'emp códigoDoUsuario códigoDoLivro' para realizar empréstimo;");
            System.out.println("Digite 'dev códigoDoUsuario códigoDoLivro' para devolver um exemplar;");
            System.out.println("Digite 'res códigoDoUsuario códigoDoLivro' para reservar um exemplar;");
            System.out.println("Digite 'obs códigoDoUsuario códigoDoLivro' para registrar um professor observador;");
            System.out.println("Digite 'rem códigoDoUsuario códigoDoLivro' para remover um professor observador;");
            
            System.out.println("\n========= Consultas requeridas =========");
            System.out.println("========================================\n");
            System.out.println("Digite 'liv códigoDoLivro' para pesquisar livros por código;");
            System.out.println("Digite 'usu códigoDoUsuario' para pesquisar histórico do usuário;");
            System.out.println("Digite 'ntf códigoDoUsuario' para notificações do professor;");
            
            System.out.println("\n========= Consultas adicionais =========");
            System.out.println("========================================\n");
            System.out.println("Digite 'exemplares' para listar exemplares;");
            System.out.println("Digite 'usuarios' para listar usuários;");
            System.out.println("Digite 'emprestimos' para listar empréstimos;");
            System.out.println("Digite 'reservas' para listar reservas;");
           
            System.out.println("\nDigite 'sai' para sair;");
            
            System.out.print("\nDigite a sua opção: ");
            comando = teclado.nextLine();
            if(!comando.equalsIgnoreCase("sai")){
                console.executar(comando);
            }
            
        }while (!comando.equalsIgnoreCase("sai"));
        teclado.close();
    }
}      
        
