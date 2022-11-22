package engsoftware.command;

import engsoftware.dao.BibliotecaDAOImpl;

public class EmprestimoCommand extends Command {
    EmprestimoCommand(final BibliotecaDAOImpl bibliotecaDAO, final String entrada) {
        super(bibliotecaDAO, entrada);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
