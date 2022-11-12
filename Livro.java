package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Livro {
    
    //atributos
    private int codigo;
    private int anoPublicacao;
    private String titulo;
    private String editora;
    private String edicao;
    private List<String> autores;
    private boolean emprestado;
    
    //contrutor
    public Livro (int codigo, int anoPublicacao, String titulo, String editora,
        String edicao, String autor1, String autor2, String autor3){
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.autores = new ArrayList<>();
        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);
        this.emprestado = false;
    }
    
    public void detalhesDoLivro(){
        
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Ano de publicação: " + this.getAnoPublicacao());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Editora: " + this.getEditora());
        System.out.println("Edição: " + this.getEdicao());
        System.out.println("Autores: " + this.getAutores());
        System.out.println("Está emprestado? " + this.isEmprestado());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }   
}
