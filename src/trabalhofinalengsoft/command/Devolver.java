package trabalhofinalengsoft.command;

import trabalhofinalengsoft.Biblioteca;

/**
 *
 * @author Hugo_Chaves
 */
public class Devolver implements Command{

    @Override
    public void execute(int codigoUsuario, int codigoLivro) {
       
        Biblioteca.getInstance().devolver(codigoUsuario, codigoLivro);
    }   
}
