package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Exemplar {
    
    //atributos
    private final int codigo;
    private final int anoPublicacao;
    private final String titulo;
    private final String editora;
    private final String edicao;
    private boolean disponivel;
    private boolean reservado;
    private final List<String> autores;
    
    //contrutor
    
    public Exemplar (int anoPublicacao, int codigo, String titulo, String editora,
        String edicao, String autor1, String autor2, String autor3, String autor4){
        
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.autores = new ArrayList<>();
        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);
        this.autores.add(autor4);
        this.disponivel = true;
        this.reservado = false;        
    }
    
    public void detalhesDoExemplar(){
        
        System.out.println("Título: " + this.titulo);
        System.out.println("Ano de publicação: " + this.anoPublicacao);
        System.out.println("Código do exemplar: " + this.codigo);
        System.out.println("Editora: " + this.editora);
        System.out.println("Edição: " + this.edicao);
        System.out.println("Autores: " + this.autores);
        System.out.println("Está disponível? " + this.isDisponivel());
        System.out.println("Está reservado? " + this.isReservado());
    }
    
    public void dadosDoExemplar(){
        System.out.println("\nTitulo: " + this.titulo);
        System.out.println("Código do exemplar: " + this.codigo);
    }
   
    //Getters e Setters

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getCodigo() {
        return codigo;
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
}
