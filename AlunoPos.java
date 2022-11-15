package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class AlunoPos extends Usuario{

    //construtor
    public AlunoPos (String nome, int codigo){
        super(nome, codigo);
        regraEmprestimo = new EmprestimoAlunoPos();
        regraReserva = new ReservaAlunoPos();
    }
    
    @Override
    public void display() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Aluno de pós-graduação.");
    }    

    @Override
    public void devolver(Usuario usuario, int codigoLivro) {
        // lógica pendente.
    }
}