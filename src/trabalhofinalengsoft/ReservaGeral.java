package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class ReservaGeral implements RegraReserva{

    @Override
    public void reservar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0, saida = 0;
        
        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if(codigoLivro == livro.getCodigo()){
                for(Exemplar exemplar: livro.getExemplares()){
                    if(exemplar.getTitulo().equalsIgnoreCase(livro.getTitulo())){
                        if(exemplar.isDisponivel()){
                            if(!VerificacoesEAcoes.possuiReserva(usuario, livro)){
                                if(!VerificacoesEAcoes.possuiEmprestimo(usuario, exemplar)){
                                    if(!VerificacoesEAcoes.estaNoLimiteDeReservas(usuario)){
                                        System.out.println("\nReserva efetuada com sucesso.");
                                        System.out.println("Nome: " + usuario.getNome());
                                        System.out.println("Titulo: " + exemplar.getTitulo());
                                        System.out.println("Código do exemplar: " + exemplar.getCodigo());
                                        usuario.reservas.add(new Reserva(exemplar.getTitulo(), livro.getCodigo(), 
                                            exemplar.getCodigo()));
                                        exemplar.setDisponivel(false);
                                        exemplar.setReservado(true);
                                        livro.incrementaNumeroReservas();
                                        livro.valoresAlterados(livro.getNumeroReservas());
                                        auxiliar = 0;
                                        cont = 0;
                                        saida = 1;
                                        break;
                                    }
                                    else{
                                        auxiliar = 5;
                                        cont = 0;
                                    }
                                }
                                else{
                                    auxiliar = 4;
                                    cont = 0;
                                }                    
                            }
                            else{
                                auxiliar = 3;
                                cont = 0;
                            }      
                        }
                        else{
                            auxiliar = 2;
                            cont = 0;
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
            case 1 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
            + "\nMotivo: Livro inexistente.");
            case 2 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
            + "\nMotivo: Livro indisponível.");
            case 3 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
            + "\nMotivo: " + usuario.getNome() + " já possui uma reserva para este livro.");
            case 4 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
            + "\nMotivo: " + usuario.getNome() + " já possui empréstimo em aberto para este livro.\n");
            case 5 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
            + "\nMotivo: Limite de reservas alcançado.\n");
        }
    }
}
