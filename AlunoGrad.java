package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class AlunoGrad extends Usuario{    
    
    //construtor
    public AlunoGrad (String nome, int codigo){
        super(nome, codigo);
        regraEmprestimo = new EmprestimoAlunoGrad();
        regraReserva = new ReservaAlunoGrad();
    }
    
    @Override
    public void display() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Aluno de graduação.");
    }        

    @Override
    public void devolver(Usuario usuario, int codigoLivro) {
        //Lógica pendente.
    }
}
