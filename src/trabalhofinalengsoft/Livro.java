package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class Livro implements Sujeito{
    
    //atributos
    private final int codigo;
    private final int codigoExemplar;
    private final int anoPublicacao;
    private int numeroReservas;
    private final String titulo;
    private final String editora;
    private final String edicao;
    private boolean disponivel;
    private boolean reservado;
    private final List<String> autores;
    private final List<Observador> observadores;
    
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
        this.observadores = new ArrayList<>();
        this.autores.add(autor1);
        this.autores.add(autor2);
        this.autores.add(autor3);
        this.autores.add(autor4);
        this.disponivel = true;
        this.reservado = false;
        this.numeroReservas = 0;
        
    }
    
    public void detalhesDoLivro(){
        
        System.out.println("Título: " + this.titulo);
        System.out.println("Ano de publicação: " + this.anoPublicacao);
        System.out.println("Código do livro: " + this.codigo);
        System.out.println("Código do exemplar: " + this.codigoExemplar);
        System.out.println("Editora: " + this.editora);
        System.out.println("Edição: " + this.edicao);
        System.out.println("Autores: " + this.autores);
        System.out.println("Está disponível? " + this.isDisponivel());
        System.out.println("Está reservado? " + this.isReservado());
        System.out.println("Número de reservas: " + this.numeroReservas);
    
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

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
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

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }   

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
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
}
