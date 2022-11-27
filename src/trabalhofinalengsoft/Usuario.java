package trabalhofinalengsoft;

import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public abstract class Usuario implements Observador{
    RegraEmprestimo regraEmprestimo;
    RegraReserva regraReserva;
    private final String nome;
    private final int codigo;
    private boolean devedor;
    List<Emprestimo> emprestimos;
    List<Reserva> reservas;
    
    // Construtor padrão
    public Usuario(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo; 
        this.devedor = false;      
    }
    
    //Métodos personalizados
    public abstract void display();
    public abstract void listarEmprestimos();
    public abstract void listarReservas();
    
    public void pegarEmprestado(int codigoLivro){
        regraEmprestimo.emprestar(this, codigoLivro);
    }
    
    public void reservar(int codigoLivro){
        regraReserva.reservar(this, codigoLivro);
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
