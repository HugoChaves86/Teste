package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Hugo_Chaves
 */
public class Reserva {
    
    private final String titulo;
    private final LocalDateTime dataEmprestimo;
    private final int codigoReserva;
    private final int codigoExemplar;
    
    public Reserva (String titulo, int codigoReserva, int codExemplar){
        
        this.titulo = titulo;
        this.dataEmprestimo = LocalDateTime.now();  
        this.codigoReserva = codigoReserva;
        this.codigoExemplar = codExemplar;
    }
    
    //Getters  

    public String getTitulo() {
        return titulo;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }   

    public int getCodigoExemplar() {
        return codigoExemplar;
    }   
    
    public String getDataEmprestimo() {
		
        //Formatação de data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatado = dataEmprestimo.format(formatter);

        return formatado;
    }
}
