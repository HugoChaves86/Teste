package engsoftware.command;

public class CommandDTO {
    private String comando;
    private String idUsuario;
    private String idLivro;

    public CommandDTO(final String comando, final String idUsuario, final String idLivro) {
        this.comando = comando;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

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
