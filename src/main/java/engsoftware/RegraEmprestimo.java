package engsoftware;

/**
 *
 * @author Hugo_Chaves
 */
public interface RegraEmprestimo {

    public void emprestar(Usuario usuario, int codigoLivro);
    public void devolver(Usuario usuario, int codigoLivro);
    public void listarEmprestimos();
}
