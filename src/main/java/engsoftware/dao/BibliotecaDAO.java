package engsoftware.dao;

import engsoftware.Livro;

public interface BibliotecaDAO {
    Livro findLivro(int codigo_livro);

    Livro findLivros();
}
