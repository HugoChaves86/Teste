package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Livro implements Sujeito{
    
    //atributos
    private int codigo;
    private final int anoPublicacao;
    private int numeroReservas;
    private final String titulo;
    private final String editora;
    private final String edicao;
    private final List<String> autores;
    private final List<Observador> observadores;
    private List<Exemplar> exemplares = inicializaExemplar();
    
    public Livro (int anoPublicacao, int codigo, String titulo, String editora,
        String edicao, String autor1, String autor2, String autor3, String autor4){
        
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.autores = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);
        this.autores.add(autor4);
        this.numeroReservas = 0; 
    }
    
    public void detalhesDoLivro(){
        
        System.out.println("Título: " + this.titulo);
        System.out.println("Ano de publicação: " + this.anoPublicacao);
        System.out.println("Código do livro: " + this.codigo);
        System.out.println("Editora: " + this.editora);
        System.out.println("Edição: " + this.edicao);
        System.out.println("Autores: " + this.autores);
        System.out.println("Número de reservas: " + this.numeroReservas);
    
    }
    
    public void dadosDoLivro(){
        System.out.println("\nTítulo: " + this.titulo);
        System.out.println("Número de reservas: " + this.numeroReservas);
        System.out.println("Código do livro: " + this.codigo);
    }
    
    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("\nProfessor observador adicionado com sucesso.");
    }

    @Override
    public void removerObservador(Observador observador) {
        int i = observadores.indexOf(observador);
        if (i >= 0){
            observadores.remove(i);
            System.out.println("\nProfessor observador removido com sucesso.");
        }
    }

    @Override
    public void notificarObservadores() {
        for(int i = 0; i < observadores.size(); i++){
            Observador observador = observadores.get(i);
            observador.atualiza();
        }
    }
    
    public void valoresAlterados(int numeroReservasSimultaneas){

        this.numeroReservas = numeroReservasSimultaneas;
        if (numeroReservas > 2){
            notificarObservadores();
        }        
    }
    
    public void adicionarExemplar(int anoPublicacao, int codigo, String titulo, String editora, 
        String edicao, String autor1, String autor2, String autor3, String autor4){
        
        exemplares.add(new Exemplar(anoPublicacao, codigo, titulo, editora, edicao, autor1, 
                autor2, autor3, autor4));        
    }
    
    public List<Exemplar> inicializaExemplar(){
        
        exemplares = new ArrayList<>();
        
        this.adicionarExemplar(2000, 1, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        this.adicionarExemplar(2000, 2, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        this.adicionarExemplar(2000, 3, "Engenharia de Software", "Addison Wesley", "6a edicao", 
                "Ian Sommervile", "", "", "");
        
        this.adicionarExemplar(2000, 4, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        this.adicionarExemplar(2000, 5, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        this.adicionarExemplar(2000, 6, "UML – Guia do Usuário", "Campus", "7a edicao", 
                "Grady Booch", "James Rumbaugh", "Ivar Jacobson", "");
        
        this.adicionarExemplar(2014, 7, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        this.adicionarExemplar(2014, 8, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        this.adicionarExemplar(2014, 9, "Code Complete", "Microsoft Press", "2a edicao", 
                "Steve McConnell", "", "", "");
        
        this.adicionarExemplar(2002, 10, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        this.adicionarExemplar(2002, 11, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        this.adicionarExemplar(2002, 12, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "1a edicao", "Robert Martin", "", "", "");
        
        this.adicionarExemplar(1999, 13, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarExemplar(1999, 14, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarExemplar(1999, 15, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "1a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarExemplar(2014, 16, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        this.adicionarExemplar(2014, 17, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        this.adicionarExemplar(2014, 18, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "3a edicao", "Norman Fenton", "James Bieman", "", "");
        
        this.adicionarExemplar(1994, 19, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        this.adicionarExemplar(1994, 20, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        this.adicionarExemplar(1994, 21, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "1a edicao", "Erich Gamma", "Richard Helm", "Ralph Johnson",
                "John Vlissides");
        
        this.adicionarExemplar(2003, 22, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarExemplar(2003, 23, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
        this.adicionarExemplar(2003, 24, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
        
        return exemplares;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigoLivro){
        this.codigo = codigoLivro;
    }   

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public List<String> getAutores() {
        return autores;
    }     

    public int getNumeroReservas() {
        return numeroReservas;
    }      
    
    public void incrementaNumeroReservas(){
        this.numeroReservas++;
    }
    
    public void decrementaNumeroReservas(){
        this.numeroReservas--;
    }
    
    public List<Observador> getObservadores(){
        return observadores;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }  
}
