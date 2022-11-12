package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hugo_Chaves
 */
public class EmprestimoAlunoGrad implements RegraEmprestimo{ 
    
    private final int duracaoEmprestimoEmDias = 3;
    private final LocalDateTime dataEmprestimo = LocalDateTime.now();
    
    @Override
    public void emprestar(Usuario usuario, int codigo) {
        
        int cont = 0;
        
        for(Livro livro: Biblioteca.livros){
            if (codigo == livro.getCodigo()){
                livro.setEmprestado(true);
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
}
