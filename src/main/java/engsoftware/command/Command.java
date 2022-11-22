package engsoftware.command;
import engsoftware.dao.BibliotecaDAOImpl;

public abstract class Command {
    public BibliotecaDAOImpl bibliotecaDAO;
    public String comando;
    public String idUsuario;
    public String idLivro;

    public Command(final BibliotecaDAOImpl bibliotecaDAO, final String comando, final String idUsuario, final String idLivro) {
        this.bibliotecaDAO = bibliotecaDAO;
        this.comando = comando;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    public abstract boolean execute();

    public String getComando() {
        return comando;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdLivro() {
        return idLivro;
    }

}
