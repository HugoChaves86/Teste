package engsoftware.command;
import engsoftware.dao.BibliotecaDAOImpl;

public abstract class Command {
    public BibliotecaDAOImpl bibliotecaDAO;
    public String entrada;

    Command(BibliotecaDAOImpl bibliotecaDAO, String entrada) {
        this.bibliotecaDAO = bibliotecaDAO;
        this.entrada = entrada;
    }

    public CommandDTO splitPropriedades() {
        String[] propriedades = this.entrada.split("\\s+");

        return new CommandDTO(propriedades[0], propriedades[1], propriedades[2]);
    }

    public abstract boolean execute();

}
