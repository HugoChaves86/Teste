package trabalhofinalengsoft.command;

import trabalhofinalengsoft.Biblioteca;

/**
 *
 * @author Hugo_Chaves
 */
public class ConsultarPorProfessor implements Command{

    @Override
    public void execute(int codigo1, int codigo2) {
        
        Biblioteca.getInstance().consultaPorProfessor(codigo1);
    }
    
}
