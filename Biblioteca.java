package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hugo_Chaves
 */
public class Biblioteca {
    
    public static List<Livro> livros;
    
    //construtor
    public Biblioteca (){
        
        livros = new ArrayList<>();
    }
    
    //métodos
    
    public void adicionarLivro(int anoPublicacao, int codigo, int codExemplar, String titulo, String editora, 
        String edicao, String autor1, String autor2, String autor3, String autor4){
        
        livros.add(new Livro(anoPublicacao, codigo, codExemplar, titulo, editora, edicao, autor1, 
                autor2, autor3, autor4));        
    }
 
    public void exibirLivros(){
        
        int soma = 0;
        
        if (livros.isEmpty()){
            
            System.out.println("=========================");
            System.out.println("======== Livros: ========");
            System.out.println("=========================");
            System.out.println("\nA biblioteca está vazia.\n");
        }        
            
        System.out.println("=========================");
        System.out.println("======== Livros: ========");
        System.out.println("=========================\n");
        
        for (Livro livro: livros){
            livro.detalhesDoLivro();
            System.out.println();
            soma++;
        }
        
        System.out.println("Total de livros: " + soma);
    }   

//    public void adicionarLivro(){
//        
//        System.out.println("\n===== Cadastrar Livros =====\n");
//        String opc;
//        Scanner in = new Scanner(System.in);
//        Scanner str = new Scanner(System.in);
//        
//        do{
//        
//            String titulo, editora, edicao, autor1, autor2, autor3;
//            int anoPublicacao, codigo;
//          
//            System.out.print("Titulo do livro: ");
//            titulo = str.nextLine();
//            System.out.print("Codigo do livro: ");
//            codigo = in.nextInt();
//            System.out.print("Ano da publicação do livro: ");
//            anoPublicacao = in.nextInt();
//            System.out.print("Editora do livro: ");
//            editora = str.nextLine();
//            System.out.print("Edição do livro: ");
//            edicao = str.nextLine();
//            System.out.print("Autor 01 do livro: ");
//            autor1 = str.nextLine();
//            System.out.print("Autor 02 do livro: ");
//            autor2 = str.nextLine();
//            System.out.print("Autor 03 do livro: ");
//            autor3 = str.nextLine();
//        
//            this.livros.add(new Livro(codigo, anoPublicacao, titulo, editora, edicao, autor1, autor2, autor3));
//      
//            System.out.println("\nDeseja adicionar mais livros à biblioteca? S p/ sim e N para nao.");
//            System.out.print("Digite a sua opcao: ");
//            opc = str.nextLine();
//            System.out.println();
//            
//        }while("s".equalsIgnoreCase(opc));
//    }
    
//    public void removerLivro(){
//        
//        System.out.println("\n===== Remover Livro =====\n");
//        
//        Scanner in = new Scanner(System.in);
//        Scanner str = new Scanner(System.in);
//        String opc;
//            
//        do{
//            System.out.print("Insira o codigo do livro: ");
//            int codigo = in.nextInt();
//            
//            for (Livro livro: livros){
//            
//                if(livro.getCodigo() == codigo){
//                    livros.remove(livro);
//                    break;
//                }    
//            }
//            System.out.println("\nLivro de código " + codigo + " removido com sucesso.\n");
//            System.out.println("\nDeseja remover mais livros da biblioteca? S p/ sim e N para nao.");
//            System.out.print("Digite a sua opcao: ");
//            opc = str.nextLine();
//            
//        }while("s".equalsIgnoreCase(opc));               
//    }
        
}    

