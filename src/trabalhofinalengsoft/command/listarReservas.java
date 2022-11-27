package trabalhofinalengsoft.command;

import trabalhofinalengsoft.Biblioteca;

/**
 *
 * @author Hugo_Chaves
 */
public class listarReservas implements Command{

    @Override
    public void execute(int codigoUsuario, int codigoLivro) {
        
        Biblioteca.getInstance().listarReservas();
    }    
}
