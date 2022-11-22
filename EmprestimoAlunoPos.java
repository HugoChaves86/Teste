package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public final class EmprestimoAlunoPos implements RegraEmprestimo{ 
    
    private final int duracaoEmprestimoEmDias = 4;
    private final LocalDateTime dataEmprestimo = LocalDateTime.now();
    private String dataEmprestado;
    private String titulo;
    private final List<EmprestimoAlunoPos> emprestimos = new ArrayList<>();
    
    //construtor
    public EmprestimoAlunoPos(){}   
    
    public EmprestimoAlunoPos(String titulo, String dataEmprestado){
        
        this.titulo = titulo;
        this.dataEmprestado = dataEmprestado;
    }
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0;
        
        for(Livro livro: Biblioteca.livros){
            if (codigoLivro == livro.getCodigo()){
                if (livro.isDisponivel()){
                    livro.setDisponivel(false);
                    System.out.println("\nEmpréstimo efetuado com sucesso.");
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Titulo: " + livro.getTitulo());
                    System.out.println("Data do empréstimo: " + this.getDataEmprestimo());
                    System.out.println("Data de devolução: " + this.getDataDevolver());
                    this.emprestimos.add(new EmprestimoAlunoPos(livro.getTitulo(), this.getDataEmprestimo()));
                    System.out.println();
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
        for (EmprestimoAlunoPos emprestimo: emprestimos){
            System.out.println("\nEmpréstimo 0" + cont + ": ====\n");
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

    @Override
    public void devolver(Usuario usuario, int codigoLivro) {
        //pendente
    }
}
        
        
