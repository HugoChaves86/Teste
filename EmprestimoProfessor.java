package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public final class EmprestimoProfessor implements RegraEmprestimo{ 
    
    private final int duracaoEmprestimoEmDias = 7;
    private final LocalDateTime dataEmprestimo = LocalDateTime.now();
    private String dataEmprestado;
    private String titulo;
    private final List<EmprestimoProfessor> emprestimos = new ArrayList<>();
    
    //construtor
    public EmprestimoProfessor(){}   
    
    public EmprestimoProfessor(String titulo, String dataEmprestado){
        
        this.titulo = titulo;
        this.dataEmprestado = dataEmprestado;
    }
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = -1;
        
        for(Livro livro: Biblioteca.livros){
            if (codigoLivro == livro.getCodigo() && livro.isDisponivel()){
                livro.setDisponivel(false);
                System.out.println("\nEmpréstimo efetuado com sucesso.");
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Data do empréstimo: " + this.getDataEmprestimo());
                System.out.println("Data de devolução: " + this.getDataDevolver());
                this.emprestimos.add(new EmprestimoProfessor(livro.getTitulo(), this.getDataEmprestimo()));
                System.out.println();
                auxiliar = -1;
                break;
            }
            if (codigoLivro != livro.getCodigo()){
                auxiliar = 0;
                continue;
            }
            if (!livro.isDisponivel()){
                auxiliar = 1;
            }
        }
        switch(auxiliar){
            
            case 0 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Livro inexistente.");
            case 1 -> System.out.println("\nEmpréstimo não efetuado para " + usuario.getNome() + "."
                    + "\nMotivo: Livro indisponível.");
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
    
    public String emprestimoEmCurso(){
        
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime dataDevolver = dataEmprestimo.plusDays(duracaoEmprestimoEmDias);
        
        if (dataDevolver.isAfter(agora)){
            return "Sim";
        }
        else{
            return "Não. Empréstimo finalizado.";
        }        
    }
    
    @Override
    public void listarEmprestimos(){
        
        int cont = 1;
        for (EmprestimoProfessor emprestimo: emprestimos){
            System.out.println("Empréstimo 0" + cont + ": ====\n");
            System.out.println("Titulo: " + emprestimo.titulo);
            System.out.println("Data do empréstimo: " + emprestimo.dataEmprestado);
            System.out.println("Empréstimo em curso? " + emprestimo.emprestimoEmCurso());
            if (emprestimo.emprestimoEmCurso().equalsIgnoreCase("Sim")){
                System.out.println("Data prevista para devolução: " + emprestimo.getDataDevolver());
            }else{
                System.out.println("Devolvido em: ..... (APLICAR AQUI A DATA DE DEVOLUÇÂO EFETIVA)");                
            }
            cont++;
        }
    }    
}
        
        
