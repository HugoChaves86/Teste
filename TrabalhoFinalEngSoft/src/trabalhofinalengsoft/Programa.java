package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class Programa {

    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(100, 2000, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "");
        biblioteca.adicionarLivro(101, 2000, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson");
        biblioteca.adicionarLivro(200, 2014, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "");
        biblioteca.adicionarLivro(201, 2002, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "");
        biblioteca.adicionarLivro(300, 1999, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "");
        biblioteca.adicionarLivro(301, 2014, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "");
        biblioteca.adicionarLivro(400, 1994, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson");
        biblioteca.adicionarLivro(401, 2003, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "");
        
        
//        biblioteca.adicionarLivro();
//        biblioteca.exibirLivros();
//        biblioteca.removerLivro();
    
        AlunoGrad alunoGrad = new AlunoGrad("Hugo", 150);
        AlunoPosGrad alunoPos = new AlunoPosGrad("Fernanda", 200);
        Professor professor = new Professor("Cláudio", 100);
        
        biblioteca.emprestar(alunoGrad, 100);
        System.out.println();
        biblioteca.emprestar(alunoPos, 101);
        System.out.println();
        biblioteca.emprestar(professor, 200);
        System.out.println();
        

        
    }    
}
