package trabalhofinalengsoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public abstract class Usuario {
    RegraEmprestimo regraEmprestimo;
    RegraReserva regraReserva;
    private final String nome;
    private final int codigo;
    private boolean devedor;
    protected List<Usuario> usuarios;
    
    // Construtor padrão
    public Usuario(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo; 
        this.devedor = false;
        this.usuarios = new ArrayList<>();
    }
    
    //Métodos personalizados
    public abstract void display();
    
    public void listarEmprestimos(){
        regraEmprestimo.listarEmprestimos();
    }
    
    public void pegarEmprestado(Usuario usuario, int codigoLivro){
        regraEmprestimo.pegarEmprestado(usuario, codigoLivro);
    }
    
    public void reservar(){
        regraReserva.reservar();
    }
    
    public void devolver(Usuario usuario, int codigoLivro){
        regraEmprestimo.devolver(usuario, codigoLivro);
    }    

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }       

    public boolean isDevedor() {
        return devedor;
    }

    public void setDevedor(boolean devedor) {
        this.devedor = devedor;
    }   
}
