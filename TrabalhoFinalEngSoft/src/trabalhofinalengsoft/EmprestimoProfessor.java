package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoProfessor implements RegraEmprestimo{

    @Override
    public void emprestar(int codigo) {
        System.out.println("Empréstimo efetuado para o professor.");
    }
    
}
