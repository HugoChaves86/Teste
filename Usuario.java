package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public abstract class Usuario {
    RegraEmprestimo regraEmprestimo;
    RegraReserva regraReserva;
    private String nome;
    private int codigo;
    
    
    // Construtor padrão
    public Usuario(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
