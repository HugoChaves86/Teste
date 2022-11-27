package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoAluno implements RegraEmprestimo{  
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0;

        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if (codigoLivro == livro.getCodigo()){
                if (livro.isDisponivel() || Verificacoes.possuiReserva(usuario, codigoLivro)){
                    if(!Verificacoes.possuiEmprestimo(usuario, livro)){
                        if (!Verificacoes.estaNoLimiteDeEmprestimos(usuario)){
                            if(!Verificacoes.estaDevendo(usuario)){
                                if(Verificacoes.possuiReserva(usuario, codigoLivro)){
                                    Verificacoes.removeReserva(usuario, codigoLivro);
                                }
                                livro.setDisponivel(false);
                                System.out.println("\nEmpréstimo efetuado em nome de " + usuario.getNome() + ".");
                                System.out.println("Titulo: " + livro.getTitulo() + ".");
                                System.out.println("Código do exemplar: " + livro.getCodigoExemplar());
                                usuario.emprestimos.add(new Emprestimo(livro.getTitulo(), livro.getCodigo(),
                                    Verificacoes.definirDuracaoEmprestimo(usuario), livro.getCodigoExemplar()));
                                auxiliar = 0;
                                cont = 0;
                                break;
                            }
                            else{
                                cont = 0;
                                auxiliar = 5;
                            }
                        }
                        else{
                            cont = 0;
                            auxiliar = 4;
                        }
                    }
                    else{
                        cont = 0;
                        auxiliar = 3;
                    }
                }
                else{
                    cont = 0;
                    auxiliar = 2;                        
                }               
            }
            else{
                cont++;
            }
        }
        if (cont > 0){
            if (auxiliar > 0){
                cont = 0;
            }
            else{
                auxiliar = 1;
            }
        }
        
        switch(auxiliar){
        
            case 1 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Livro inexistente.");
            case 2 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Livro indisponível.");
            case 3 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Já existe um empréstimo em curso de um exemplar deste livro para "
                    + usuario.getNome() + ".");
            case 4 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Limite de empréstimos em aberto alcançado.");
            case 5 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: " + usuario.getNome() + " está devendo na biblioteca.");
        }
    }     
} 