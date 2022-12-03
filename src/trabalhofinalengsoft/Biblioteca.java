package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Biblioteca {
    
    private List<Livro> livros = inicializaLivros();
    private List<Usuario> usuarios = inicializaUsuarios();
    
    //Singleton
    private static Biblioteca instance;
    private Biblioteca (){}
    
    public static Biblioteca getInstance(){
        if (instance == null){
            instance = new Biblioteca();
        }
        return instance;
    }
     
    public List<Usuario> inicializaUsuarios(){
        usuarios = new ArrayList<>();
        
        this.usuarios.add(new AlunoGrad("Hugo Chaves", 10));
        this.usuarios.add(new AlunoGrad("João Mascarenhas", 15));
        this.usuarios.add(new AlunoPos("Elis Alcantara", 20));
        this.usuarios.add(new AlunoPos("Fernando Pessoa", 25));
        this.usuarios.add(new Professor("Cláudio Sant'Ana", 30));
        this.usuarios.add(new Professor("Rodrigo Rocha", 35));
        
        return usuarios;         
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
        
        for (Usuario usuario: usuarios){
            System.out.println("\n=== Empréstimos de " + usuario.getNome() + " ===");
            usuario.listarEmprestimos();
        }
    }
    
    public void listarReservas(){
        
        for (Usuario usuario: usuarios){
            System.out.println("\n=== Reservas de " + usuario.getNome() + " ===");
            usuario.listarReservas();
        }
    }
    
    public void adicionarLivro(int anoPublicacao, int codigo, int codExemplar, String titulo, String editora, 
        String edicao, String autor1, String autor2, String autor3, String autor4){
        
        livros.add(new Livro(anoPublicacao, codigo, codExemplar, titulo, editora, edicao, autor1, 
                autor2, autor3, autor4));        
    }
 
    public void listarLivros(){
        
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
    
    public void realizarEmprestimo(int codigoUsuario, int codigoLivro){
        
        if(usuarios.isEmpty()){
            System.out.println("\nNão há usuários cadastrados.\n");
            return;
        }
        
        int cont = 0;
        System.out.println("\n==== Realizar empréstimo ====");
        for(Usuario usuario: usuarios){
            if(codigoUsuario == usuario.getCodigo()){
                usuario.pegarEmprestado(codigoLivro);
                cont = 0;
                break;
            }
            cont++;
        }
        if (cont > 0){
            System.out.print("\nUsuário não cadastrado.\n");
        }
    }
    
    public void devolver(int codigoUsuario, int codigoLivro){

//        int auxiliar = 0;
        for(Usuario usuario: usuarios){
            if (codigoUsuario == usuario.getCodigo()){
                if(usuario.emprestimos.isEmpty()){
                    System.out.println("\n" + usuario.getNome() + " não possui empréstimos.");
                    break;
                }
                int cont = 0;
//                Livro livro = livros.get(auxiliar);
                for(Emprestimo emprestimo: usuario.emprestimos){
                    if(codigoLivro == emprestimo.getCodigo()){
                        if(emprestimo.isEmCurso()){
                            for (Livro livro: livros){
                                if(livro.getCodigoExemplar() == emprestimo.getCodigoExemplar()){
                                    System.out.println("\nDevolução efetuada em nome de " + usuario.getNome() + ".");
                                    System.out.println("Título: " + emprestimo.getTitulo() + ".");
                                    System.out.println("Código do exemplar: " + emprestimo.getCodigoExemplar() + ".");
                                    emprestimo.setDataDevolvido();
                                    emprestimo.setEmCurso(false);
                                    usuario.setDevedor(false);
                                    livro.setDisponivel(true);
                                    cont = 0;
                                    break;                                                                   
                                }                               
                            }
                        }
                        else{
                            cont++;
                        }                                               
                    }
                }
                if (cont > 0){
                    System.out.println("\nO usuário não possui empréstimos em aberto para este livro.");
                    break;
                }
            }
//            auxiliar++;
        }
    }
    
    public void reservarLivro(int codigoUsuario, int codigoLivro){
        
        for (Usuario usuario: usuarios){
            if (codigoUsuario == usuario.getCodigo()){
                usuario.reservar(codigoLivro);
            }
        }
    }
    
    public void registrarProfessorObservador(int codigoUsuario, int codigoLivro){
        
        for (Usuario usuario: usuarios){
            if (codigoUsuario == usuario.getCodigo()){
                if(usuario.getClass().getSimpleName().equalsIgnoreCase("Professor")){
                    for(Livro livro: livros){
                        if (codigoLivro == livro.getCodigo()){
                            livro.registrarObservador(usuario);
                            break;
                        }                    
                    }
                }
                else{
                    System.out.println("\nOperação não permitida.\nMotivo: " 
                        + usuario.getNome() + " não é um professor.");
                    break;
                }
            }
        }
    }
    
    public void removerProfessorObservador(int codigoUsuario, int codigoLivro){
        
        for (Usuario usuario: usuarios){
            if (codigoUsuario == usuario.getCodigo()){
                if(usuario.getClass().getSimpleName().equalsIgnoreCase("Professor")){
                    for(Livro livro: livros){
                        if(livro.getObservadores().isEmpty()){
                            System.out.println("\nNão há professores observadores cadastrados para este livro.");
                            break;
                        }
                        if (codigoLivro == livro.getCodigo()){
                            livro.removerObservador(usuario);
                            break;
                        }                    
                    }
                }
                else{
                    System.out.println("\nOperação não permitida.\nMotivo: " 
                        + usuario.getNome() + " não é um professor.");
                    break;
                }
            }
        } 
    }
    
    public void ConsultaPorCodigo(int codigoLivro){
        
        System.out.println("\n===== Dados dos exemplares desse livro =====");
        
        for(Livro livro: livros){
            if(codigoLivro == livro.getCodigo()){
                livro.dadosDoLivro();
                if(livro.isDisponivel()){
                    System.out.println("\nStatus: o livro está disponível.");                
                }
                if(livro.getNumeroReservas() > 0){
                    System.out.println("\nStatus: O livro está reservado.");
                    System.out.println("\nUsuarios que reservaram o livro:\n");
                    Verificacoes.imprimeReservantes(usuarios, livro);
                }
                Verificacoes.imprimeDadosEmprestimo(usuarios, livro);                               
            }    
        }
    }
    
    public void consultaPorUsuario(int codigoUsuario){
        
        System.out.println("\n==== Empréstimos ====");
        for(Usuario usuario: usuarios){
            if(codigoUsuario == usuario.getCodigo()){
                usuario.listarEmprestimos();
            }
        }
        System.out.println("\n==== Reservas ====");
        for(Usuario usuario: usuarios){
            if(codigoUsuario == usuario.getCodigo()){
                usuario.listarReservas();
            }
        }
    }
    
    public void consultaPorProfessor(int codigoUsuario){
        
        for(Usuario usuario: usuarios){
            if(codigoUsuario == usuario.getCodigo()){
                if(usuario.getClass().getSimpleName().equalsIgnoreCase("Professor")){
                    System.out.println("\n==== Dados do professor ====\n");
                    usuario.display();
                }
                else{
                    System.out.println("\nOperação não permitida.\nMotivo: " 
                        + usuario.getNome() + " não é um professor.");
                    break;
                }
            }
        }
    }
    
    public List<Livro> inicializaLivros(){
        
        livros = new ArrayList<>();
        
        this.adicionarLivro(2000, 100, 1, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        this.adicionarLivro(2000, 100, 2, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        this.adicionarLivro(2000, 101, 3, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        this.adicionarLivro(2000, 101, 4, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        this.adicionarLivro(2014, 200, 5, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        this.adicionarLivro(2014, 200, 6, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        this.adicionarLivro(2002, 201, 7, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        this.adicionarLivro(2002, 201, 8, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        this.adicionarLivro(1999, 300, 9, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarLivro(1999, 300, 10, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarLivro(2014, 301, 11, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        this.adicionarLivro(2014, 301, 12, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        this.adicionarLivro(1994, 400, 13, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        this.adicionarLivro(1994, 400, 14, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        this.adicionarLivro(2003, 401, 15, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarLivro(2003, 401, 16, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
        return livros;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }   
}    

