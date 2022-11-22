package engsoftware.command;

import engsoftware.dao.BibliotecaDAOImpl;

public class CommandBus {
    private String comando;
    private String idUsuario;
    private String idLivro;
    private BibliotecaDAOImpl bibliotecaDAO;

    public CommandBus(BibliotecaDAOImpl bibliotecaDAO, String entrada) {
        String[] entradaSplit = entrada.split("\\s+");
        this.bibliotecaDAO = bibliotecaDAO;
        this.comando = entradaSplit[0];
        this.idUsuario = entradaSplit[1];
        this.idLivro = entradaSplit[2];
    }

    private void execute() {
        if (comando == "emp") {
            new EmprestimoCommand(bibliotecaDAO, comando, idUsuario, idLivro);
        }

        if (comando == "dev") {
            new DevolucaoCommand(bibliotecaDAO, comando, idUsuario, idLivro);
        }

        if (comando == "res") {
            new ReservaCommand(bibliotecaDAO, comando, idUsuario, idLivro);
        }
    }
}
