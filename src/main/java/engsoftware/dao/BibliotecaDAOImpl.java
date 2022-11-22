package engsoftware.dao;

import java.util.List;
import java.util.stream.Collectors;

import engsoftware.Biblioteca;
import engsoftware.Livro;

public class BibliotecaDAOImpl implements BibliotecaDAO {
    @Override
    public List<Livro> findLivros() {
        return Biblioteca.livros;
    }
    @Override
    public Livro findLivroByCodigo(int codigo_livro) {
        return Biblioteca.livros
                .stream()
                .filter(livro -> codigo_livro == livro.getCodigo())
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Livro> findLivrosByCodigoExemplar(final int codigo_exemplar) {
        return Biblioteca.livros
                .stream()
                .filter(livro -> codigo_exemplar == livro.getCodigoExemplar())
                .collect(Collectors.toList());
    }
}
