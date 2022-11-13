package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Livro {
    
    //atributos
    private final int codigo;
    private final int codigoExemplar;
    private int anoPublicacao;
    private String titulo;
    private String editora;
    private String edicao;
    private List<String> autores;
    private boolean emprestado;
    private boolean disponivel;
    
    //contrutor
    public Livro (int anoPublicacao, int codigo, int codExemplar, String titulo, String editora,
        String edicao, String autor1, String autor2, String autor3, String autor4){
        this.codigo = codigo;
        this.codigoExemplar = codExemplar;
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.autores = new ArrayList<>();
        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);
        this.autores.add(autor4);
        this.emprestado = false;
        this.disponivel = true;
    }
    
    public void detalhesDoLivro(){
        
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Ano de publicação: " + this.getAnoPublicacao());
        System.out.println("Código do livro: " + this.getCodigo());
        System.out.println("Código do exemplar: " + this.getCodigoExemplar());
        System.out.println("Editora: " + this.getEditora());
        System.out.println("Edição: " + this.getEdicao());
        System.out.println("Autores: " + this.getAutores());
        System.out.println("Está emprestado? " + this.isEmprestado());
        System.out.println("Está disponível? " + this.isDisponivel());
    }

    public int getCodigo() {
        return codigo;
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

    public int getCodigoExemplar() {
        return codigoExemplar;
    }   

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }   
}
