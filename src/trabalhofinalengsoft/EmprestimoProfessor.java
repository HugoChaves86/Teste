package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoProfessor implements RegraEmprestimo{  
    
    private final int duracaoEmprestimoEmDias = 7;
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0, saida = 0;

        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if (codigoLivro == livro.getCodigo()){
                for(Exemplar exemplar: livro.getExemplares()){
                    if(exemplar.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                        if(!VerificacoesEAcoes.estaDevendo(usuario)){
                            if(exemplar.isReservado()){
                                exemplar.setDisponivel(true);
                            }
                            if (exemplar.isDisponivel()){
                                if(VerificacoesEAcoes.possuiReserva(usuario, livro)){
                                    VerificacoesEAcoes.removeReserva(usuario, codigoLivro);
                                    if(livro.getNumeroReservas() > 0){
                                        livro.decrementaNumeroReservas();
                                        exemplar.setReservado(false);
                                    }                                    
                                }
                                exemplar.setDisponivel(false);
                                System.out.println("\nEmpréstimo efetuado em nome de " + usuario.getNome() + ".");
                                System.out.println("Titulo: " + exemplar.getTitulo() + ".");
                                System.out.println("Código do exemplar: " + exemplar.getCodigo());
                                usuario.emprestimos.add(new Emprestimo(exemplar.getTitulo(), livro.getCodigo(),
                                    this.duracaoEmprestimoEmDias, exemplar.getCodigo()));
                                auxiliar = 0;
                                cont = 0;
                                saida = 1;
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
                }
                if (saida == 1){
                    break;
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
        
