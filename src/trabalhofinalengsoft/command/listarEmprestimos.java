package trabalhofinalengsoft.command;

import trabalhofinalengsoft.Biblioteca;

/**
 *
 * @author Hugo_Chaves
 */
public class listarEmprestimos implements Command{

    @Override
    public void execute(int codigoUsuario, int codigoLivro) {
        
        Biblioteca.getInstance().listarEmprestimos();
    }    
}
