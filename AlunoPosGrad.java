package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class AlunoPosGrad extends Usuario{
    
    //Atributos
    int codigo;
    String nome;

    //construtor
    public AlunoPosGrad (String nome, int codigo){
        this.codigo = codigo;
        this.nome = nome;
        regraEmprestimo = new EmprestimoAlunoPos();
        regraReserva = new ReservaAlunoPos();
    }
    
    @Override
    public void display() {
        System.out.println("Nome " + this.getNome());
        System.out.println("Código " + this.getCodigo());
        System.out.println("Eu sou um aluno de pós-graduação.");
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }    
}