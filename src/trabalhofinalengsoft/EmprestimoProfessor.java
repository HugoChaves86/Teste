package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoProfessor implements RegraEmprestimo{  
    
    private final int duracaoEmprestimoEmDias = 7;
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0;

        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if (codigoLivro == livro.getCodigo()){
                if(!Verificacoes.estaDevendo(usuario)){
                    if(!Verificacoes.possuiReserva(usuario, codigoLivro)){
                        if(livro.isReservado()){
                            livro.setDisponivel(true);
                        }                    
                    }
                    if (livro.isDisponivel()){
                        
                        Verificacoes.removeReserva(usuario, codigoLivro);
                        livro.setDisponivel(false);
                        System.out.println("\nEmpréstimo efetuado em nome de " + usuario.getNome() + ".");
                        System.out.println("Titulo: " + livro.getTitulo() + ".");
                        System.out.println("Código do exemplar: " + livro.getCodigoExemplar());
                        usuario.emprestimos.add(new Emprestimo(livro.getTitulo(), livro.getCodigo(),
                            this.duracaoEmprestimoEmDias, livro.getCodigoExemplar()));
                        auxiliar = 0;
                        cont = 0;
                        break;
                    }
                    else{
                        cont = 0;
                        auxiliar = 2;
                    }
                }
                else{
                    cont = 0;
                    auxiliar = 3;                        
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
                    + "\nMotivo: " + usuario.getNome() + " está devendo na biblioteca.");
        }                
    }        
}   
        
