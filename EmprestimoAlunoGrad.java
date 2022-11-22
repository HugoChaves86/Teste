package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public final class EmprestimoAlunoGrad implements RegraEmprestimo{ 
    
    private final int duracaoEmprestimoEmDias = 3;
    private final LocalDateTime dataEmprestimo = LocalDateTime.now();
    private final List<Livro> emprestimos = new ArrayList<>();  
    
    @Override
    public void emprestar(Usuario usuario, int codigoLivro) {
        
        int auxiliar = 0, cont = 0;
        
        for(Livro livro: Biblioteca.livros){
            if (codigoLivro == livro.getCodigo()){
                if (livro.isDisponivel()){
                    if(!isEmprestado(livro)){
                        if (emprestimos.size() < 3){
                            livro.setDisponivel(false);
                            System.out.println("\nEmpréstimo efetuado com sucesso.");
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Titulo: " + livro.getTitulo());
                            System.out.println("Código: " + livro.getCodigo());
                            System.out.println("Data do empréstimo: " + getDataEmprestimo());
                            System.out.println("Data de devolução: " + getDataDevolucao());
                            emprestimos.add(livro);
                            System.out.println();
                            auxiliar = 0;
                            cont = 0;
                            break;
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
                    + "\nMotivo: Limite de empréstimos alcançado para " + usuario.getNome() + ".");
        }       
    } 
    
    public String getDataEmprestimo() {
		
        //Formatação de data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatado = dataEmprestimo.format(formatter);

        return formatado;
    }
    
    public String getDataDevolucao() {
    	
    	//Formatação de data e hora após o cálculo
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	LocalDateTime resultado = dataEmprestimo.plusDays(duracaoEmprestimoEmDias);    	
    	String formatado = resultado.format(formatter);
        
    	return formatado;
    }  
    
    public boolean isEmprestado(Livro livro){
        
        if(emprestimos.contains(livro)){
            return true;
        }
        return false;
    }    
    
    public String emprestimoEmCurso(){
        
        LocalDateTime agora = LocalDateTime.now();
    	LocalDateTime dataDevolver = dataEmprestimo.plusDays(duracaoEmprestimoEmDias);    	
  
        if(dataDevolver.isAfter(agora)){
            
            return "Sim";
        }
        else{
            
            return "Não";
        }
    }
    
//    public boolean estaDevendo(){
//        for(Livro emprestimo: emprestimos){
//            if(getDataDevolucao())
//        }
//    }
    
    @Override
    public void listarEmprestimos(){
        
        int cont = 1;
        for (Livro emprestimo: emprestimos){
            System.out.println("\nEmpréstimo 0" + cont + ": ====\n");
            System.out.println("Titulo: " + emprestimo.getTitulo());
            System.out.println("Data do empréstimo: " + getDataEmprestimo());
            System.out.println("Empréstimo em curso? " + emprestimoEmCurso());
            if (emprestimoEmCurso().equalsIgnoreCase("Sim")){
                System.out.println("Data prevista para devolução: " + getDataDevolucao());
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
        
        
