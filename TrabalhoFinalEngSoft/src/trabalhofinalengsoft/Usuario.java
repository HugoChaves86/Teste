package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public abstract class Usuario {
    RegraEmprestimo regraEmprestimo;
    RegraReserva regraReserva;
    
    // Construtor padrão
    public Usuario(){}
    
    //Métodos personalizados
    public abstract void display();
    
    public void emprestar(Usuario usuario, int codigo){
        regraEmprestimo.emprestar(usuario, codigo);
    }
    
    public void reservar(){
        regraReserva.reservar();
    }
    
    public void devolver(){
        System.out.println("Todos os usuários devem devolver no prazo, a fim de evitar penalizações.");
        //pensar em alguma coisa aqui
    }    
}
