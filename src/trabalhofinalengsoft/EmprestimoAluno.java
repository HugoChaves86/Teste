package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoAluno implements RegraEmprestimo{  
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0, saida = 0;

        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if (codigoLivro == livro.getCodigo()){
                for(Exemplar exemplar: livro.getExemplares()){
                    if(exemplar.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                        for(Reserva reserva: usuario.reservas){
                            if (exemplar.getCodigo() == reserva.getCodigoExemplar()){
                                exemplar.setDisponivel(true);
                            }
                        }
                        if(exemplar.isDisponivel()){
                            if(!VerificacoesEAcoes.possuiEmprestimo(usuario, exemplar)){
                                if (!VerificacoesEAcoes.estaNoLimiteDeEmprestimos(usuario)){
                                    if(!VerificacoesEAcoes.estaDevendo(usuario)){
                                        if(VerificacoesEAcoes.possuiReserva(usuario, livro)){
                                            VerificacoesEAcoes.removeReserva(usuario, codigoLivro);
                                            if(livro.getNumeroReservas() > 0){
                                                livro.decrementaNumeroReservas();
                                            }                                    
                                        }
                                        exemplar.setDisponivel(false);
                                        exemplar.setReservado(false);
                                        System.out.println("\nEmpréstimo efetuado em nome de " + usuario.getNome() + ".");
                                        System.out.println("Titulo: " + exemplar.getTitulo() + ".");
                                        System.out.println("Código do exemplar: " + exemplar.getCodigo());
                                        usuario.emprestimos.add(new Emprestimo(exemplar.getTitulo(), livro.getCodigo(),
                                            VerificacoesEAcoes.definirDuracaoEmprestimo(usuario), exemplar.getCodigo()));
                                        auxiliar = 0;
                                        cont = 0;
                                        saida = 1;
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
                }
                if(saida == 1){
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
                    + "\nMotivo: Já existe um empréstimo em curso de um exemplar deste livro para "
                    + usuario.getNome() + ".");
            case 4 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Limite de empréstimos em aberto alcançado.");
            case 5 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: " + usuario.getNome() + " está devendo na biblioteca.");
        }
    }     
} 