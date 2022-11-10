package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class Programa {

    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(2000, 100, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "");
        biblioteca.adicionarLivro(2000, 101, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson");
        biblioteca.adicionarLivro(2014, 200, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "");
        biblioteca.adicionarLivro(2002, 201, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "");
        biblioteca.adicionarLivro(1999, 300, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "");
        biblioteca.adicionarLivro(2014, 301, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "");
        biblioteca.adicionarLivro(1994, 400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson");
        biblioteca.adicionarLivro(2003, 401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "");
        
        
//        biblioteca.adicionarLivro();
        biblioteca.exibirLivros();
//        biblioteca.removerLivro();
    
        AlunoGrad alunoGrad = new AlunoGrad("Hugo", 10);
        AlunoPosGrad alunoPos = new AlunoPosGrad("Fernanda", 11);
        Professor professor = new Professor("Cláudio", 13);
        
        alunoGrad.display();
        alunoGrad.reservar();
        
        System.out.println();
        
        alunoPos.display();
        alunoPos.reservar();
        
        System.out.println();
        
        professor.display();
        professor.reservar();
        
        System.out.println("\n===================================\n");
        
        
        alunoGrad.display();
        alunoGrad.emprestar();
        
        System.out.println();
        
        alunoPos.display();
        alunoPos.emprestar();
        
        System.out.println();
        
        professor.display();
        professor.emprestar();
        
    }    
}
