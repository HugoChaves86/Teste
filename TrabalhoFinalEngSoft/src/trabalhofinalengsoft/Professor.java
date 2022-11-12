package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class Professor extends Usuario{
    
    //Atributos
    private final int codigo;
    private final String nome;

    //construtor
    public Professor (String nome, int codigo){
        this.codigo = codigo;
        this.nome = nome;
        regraEmprestimo = new EmprestimoProfessor();
        regraReserva = new ReservaProfessor();
    }
    
    @Override
    public void display() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Professor da UFBA.");
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }   
}
