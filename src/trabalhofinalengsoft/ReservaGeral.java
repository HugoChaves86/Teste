package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public class ReservaGeral implements RegraReserva{

    @Override
    public void reservar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0;
        
        for(Livro livro: Biblioteca.getInstance().getLivros()){
            if (codigoLivro == livro.getCodigo()){
                if (!Verificacoes.estaNoLimiteDeReservas(usuario)){
                    System.out.println("\nReserva efetuada com sucesso.");
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Titulo: " + livro.getTitulo());
                    System.out.println("Código do exemplar: " + livro.getCodigoExemplar());
                    usuario.reservas.add(new Reserva(livro.getTitulo(), livro.getCodigo(), 
                        livro.getCodigoExemplar()));
                    livro.setDisponivel(false);
                    livro.setReservado(true);
                    livro.incrementaNumeroReservas();
                    livro.valoresAlterados(livro.getNumeroReservas());
                    auxiliar = 0;
                    cont = 0;
                    break;
                }
                else{
                    auxiliar = 2;
                    cont = 0;
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
            + "\nMotivo: Limite de reservas alcançado.\n");
//            case 3 -> System.out.println("\nNão foi possível reservar o livro para " + usuario.getNome() + "."
//            + "\nMotivo: " + usuario.getNome() + " já possui uma reserva para este livro.");
        }
    }
}
