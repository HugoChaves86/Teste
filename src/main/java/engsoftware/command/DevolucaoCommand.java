package engsoftware.command;

import engsoftware.dao.BibliotecaDAOImpl;

public class DevolucaoCommand extends Command {

    public DevolucaoCommand(final BibliotecaDAOImpl bibliotecaDAO, final String comando, final String idUsuario, final String idLivro) {
        super(bibliotecaDAO, comando, idUsuario, idLivro);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
