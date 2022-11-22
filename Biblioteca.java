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
    private final List<Usuario> usuarios;
    
    //construtor
    public Biblioteca (){
        
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    
    //métodos
    
    public void cadastrarUsuarios(Scanner teclado){
        
        char opc;
        String nome;
        int opcao, codigo;
        
        do{
          
            System.out.println("\n===== Cadastrar usuários =====\n");
            System.out.print("Nome......: ");
            nome = teclado.nextLine();
            System.out.print("Código ...: ");
            codigo = teclado.nextInt();
            System.out.println("\nSelecione o tipo de usuário:\n");
            System.out.println("Digite 1 para aluno de graduação;");
            System.out.println("Digite 2 para aluno de pós-graduação;");
            System.out.println("Digite 3 para Professor.\n");
            System.out.print("Digite a sua opção: ");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 1 -> this.usuarios.add(new AlunoGrad(nome, codigo));
                case 2 -> this.usuarios.add(new AlunoPos(nome, codigo));
                case 3 -> this.usuarios.add(new Professor(nome, codigo));
            }            
      
            System.out.println("\nDeseja cadastrar mais usuários na biblioteca? S p/ continuar ou N p/ sair.");
            System.out.print("Digite a sua opcao: ");
            opc = teclado.next().charAt(0);
            opc = Character.toUpperCase(opc);
            System.out.println();
            
            teclado.nextLine(); // Limpa buffer
            
        }while(opc == 'S');   
    }
    
    public void listarUsuarios(){
        
        if(usuarios.isEmpty()){
            System.out.println("\nNão há usuários cadastrados.\n");
        }
        
        for (Usuario usuario: usuarios){
            System.out.println("\n=== Usuario: ===\n");
            usuario.display();
        }
    }
    
    public void listarEmprestimos(){
        
        if(usuarios.isEmpty()){
            System.out.println("\nNão há usuários cadastrados.\n");
        }
        
        for (Usuario usuario: usuarios){
            System.out.println("\n=== Empréstimos de " + usuario.getNome() + " ===");
            usuario.listarEmprestimos();
        }
    }
    
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
    
    public void realizarEmprestimo(Scanner teclado){
        
        if(usuarios.isEmpty()){
            System.out.println("\nNão há usuários cadastrados.\n");
            return;
        }
        
        int codigo, cont = 0;
        System.out.println("\n==== Realizar empréstimo ====\n");
        System.out.print("Digite o seu código: ");
        codigo = teclado.nextInt();
        teclado.nextLine();
        for(Usuario usuario: usuarios){
            if(codigo == usuario.getCodigo()){
                System.out.print("Digite o código do livro: ");
                codigo = teclado.nextInt();
                usuario.pegarEmprestado(codigo);
                cont = 0;
                break;
            }
            cont++;
        }
        if (cont > 0){
            System.out.print("\nUsuário não cadastrado.\n");
        }
        teclado.nextLine();
    }
            
    
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

