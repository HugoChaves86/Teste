package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public interface RegraEmprestimo {
    
    public void pegarEmprestado(Usuario usuario, int codigoLivro);
    public void devolver(Usuario usuario, int codigoLivro);
    public void listarEmprestimos();
}
