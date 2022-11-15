package engsoftware.dao;

import java.util.List;

import engsoftware.Livro;

public interface BibliotecaDAO {
    List<Livro> findLivros();

    Livro findLivroByCodigo(int codigo_livro);

    List<Livro> findLivrosByCodigoExemplar(int codigo_exemplar);
}
