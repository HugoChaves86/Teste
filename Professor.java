package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class Professor extends Usuario{

    //construtor
    public Professor (String nome, int codigo){
        super(nome, codigo);
        regraEmprestimo = new EmprestimoProfessor();
        regraReserva = new ReservaProfessor();
    }
    
    @Override
    public void display() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Professor da UFBA.");
    }   
}
