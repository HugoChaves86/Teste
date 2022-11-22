package engsoftware.command;

import engsoftware.dao.BibliotecaDAOImpl;

public class ReservaCommand extends Command {
    ReservaCommand(final BibliotecaDAOImpl bibliotecaDAO, final String entrada) {
        super(bibliotecaDAO, entrada);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
