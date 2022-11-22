package engsoftware.command;

import engsoftware.dao.BibliotecaDAOImpl;

public class DevolucaoCommand extends Command {
    DevolucaoCommand(final BibliotecaDAOImpl bibliotecaDAO, final String entrada) {
        super(bibliotecaDAO, entrada);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
