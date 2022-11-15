package trabalhofinalengsoft;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Hugo_Chaves
 */
public class Programa {

    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(2000, 100, 1,"Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        biblioteca.adicionarLivro(2000, 101, 2, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        biblioteca.adicionarLivro(2014, 200, 3, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        biblioteca.adicionarLivro(2002, 201, 4, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        biblioteca.adicionarLivro(1999, 300, 5, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        biblioteca.adicionarLivro(2014, 301, 6, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        biblioteca.adicionarLivro(1994, 400, 7, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        biblioteca.adicionarLivro(1994, 400, 8, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        biblioteca.adicionarLivro(2003, 401, 9, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
       
        biblioteca.adicionarLivro(2003, 401, 10, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
             
        Scanner teclado = new Scanner(System.in);
        
        int opc = 0;
    
        do{
            
            System.out.println("======= Biblioteca =======");
            System.out.println("==========================\n");
            System.out.println("Digite 1 para se cadastrar;");
            System.out.println("Digite 2 para realizar empréstimo;");
            System.out.println("Digite 3 para exibir exemplares;");
            System.out.println("Digite 4 para listar usuários;");
            System.out.println("Digite 5 para sair;");
           
            boolean passou = true;
            while(passou){
                try{
                    System.out.print("\nDigite a opcao desejada: ");
                    opc = teclado.nextInt();
                    passou = false;
                }catch(InputMismatchException ime) {
                    System.err.print("Você deve informar um número. Digite uma tecla para tentar novamente.\n");
                    teclado.next(); // Consumo de 1 caractere para o loop rodar.
                }
            }
            teclado.nextLine(); // Limpa buffer

            switch(opc){
                
                case 1 -> biblioteca.cadastrarUsuarios(teclado);  
                case 2 -> biblioteca.realizarEmprestimo(teclado);
                case 3 -> biblioteca.exibirLivros();
                case 4 -> biblioteca.listarUsuarios();                
                
            }
            
        }while (opc < 5);
    }
}      
        
