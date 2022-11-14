package engsoftware.dao;

import engsoftware.Livro;

public class BibliotecaDAOImpl implements BibliotecaDAO {

    @Override
    public Livro findLivro(int codigo_livro) {
        return new Livro(2003, 401, 10, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                         "Addison-Wesley Professional", "3a edicao", "Martin Fowler", "", "", "");
    }

    @Override
    public Livro findLivros() {
        // TODO Auto-generated method stub
        return null;
    }

}
