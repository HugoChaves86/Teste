package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoAlunoPos implements RegraEmprestimo{
    
    private final int duracaoEmprestimoEmDias = 4;
    private final LocalDateTime dataEmprestimo = LocalDateTime.now();

    @Override
    public void pegarEmprestado(Usuario usuario, int codigoLivro) {
        
        int cont = 0;
        
        for(Livro livro: Biblioteca.livros){
            if (codigoLivro == livro.getCodigo()){
                livro.setDisponivel(true);
                usuario.display();
                System.out.println("Empréstimo efetuado com sucesso.");
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Data do empréstimo: " + this.getDataEmprestimo());
                System.out.println("Data de devolução: " + this.getDataDevolver());
                cont++;
                break;
            }
        }
        if (cont == 0){
            System.out.println("Empréstimo não efetuado. \nMotivo: Livro inexistente.");
        }        
    } 
    
    public String getDataEmprestimo() {
		
        //Formatação de data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatado = dataEmprestimo.format(formatter);

        return formatado;
    }
    
    public String getDataDevolver() {
    	
    	//Formatação de data e hora após o cálculo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	LocalDateTime resultado = dataEmprestimo.plusDays(duracaoEmprestimoEmDias);    	
    	String formatado = resultado.format(formatter);
        
    	return formatado;
    }    

    @Override
    public void listarEmprestimos() {
        System.out.println("Falta implementação.");
    }

    @Override
    public void devolver(Usuario usuario, int codigoLivro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
