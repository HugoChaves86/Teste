package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hugo_Chaves
 */
public class Emprestimo {
    
    private final String titulo;
    private final int codigo;
    private final int codigoExemplar;
    private final LocalDateTime dataEmprestimo; 
    private LocalDateTime dataDevolvido;
    private int duracaoEmprestimoEmDias;
    private boolean emCurso;
    
    public Emprestimo (String titulo, int codigo, int duracao, int codExemplar){
        
        this.titulo = titulo;
        this.dataEmprestimo = LocalDateTime.now();
        this.duracaoEmprestimoEmDias = duracao;
        this.emCurso = true;
        this.codigo = codigo;
        this.codigoExemplar = codExemplar;
        
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
    
    public LocalDateTime getDataDevolver() {
    	
    	LocalDateTime resultado = dataEmprestimo.plusDays(duracaoEmprestimoEmDias);    	
    	return resultado;
    }
    
    public String emprestimoEmCurso(){	
  
        if(this.isEmCurso()){            
            return "Sim";
        }
        else{            
            return "Não";
        }
    }
    
    //Getters

    public String getDataDevolvido() {
        
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	String formatado = dataDevolvido.format(formatter);
        
    	return formatado;
    }

    public void setDuracaoEmprestimoEmDias(int duracaoEmprestimoEmDias) {
        this.duracaoEmprestimoEmDias = duracaoEmprestimoEmDias;
    }   

    public void setDataDevolvido() {
        this.dataDevolvido = LocalDateTime.now();
    }   

    public String getTitulo() {
        return titulo;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public boolean isEmCurso() {
        return emCurso;
    }

    public void setEmCurso(boolean emCurso) {
        this.emCurso = emCurso;
    } 

    public int getCodigoExemplar() {
        return codigoExemplar;
    }   
}
