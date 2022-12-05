package trabalhofinalengsoft;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo_Chaves
 */
public class VerificacoesEAcoes {
    
    public static boolean possuiReserva(Usuario usuario, Livro livro){
        for(Reserva reserva: usuario.reservas){
            for(Exemplar exemplar: livro.getExemplares()){
                if(exemplar.getCodigo() == reserva.getCodigoExemplar()){
                    return true;
                }                
            }
        }
        return false;
    }
    
    public static void removeReserva(Usuario usuario, int codigoLivro){
        List<Reserva> split = new ArrayList<>();  
        for(int i=0; i < usuario.reservas.size(); i++){
            if(codigoLivro != usuario.reservas.get(i).getCodigoReserva()){
                split.add(usuario.reservas.get(i));
            }
        }
        usuario.reservas.retainAll(split);
    }
    
    public static int definirDuracaoEmprestimo(Usuario usuario){
        
        int duracao = 0;
        
        if (usuario.getClass().getSimpleName().equalsIgnoreCase("AlunoGrad")){
            duracao = 3;
        }
        if (usuario.getClass().getSimpleName().equalsIgnoreCase("AlunoPos")){
            duracao = 4;
        }
        return duracao;
    }
    
    public static boolean estaNoLimiteDeEmprestimos(Usuario usuario){
        
        int limite = 0;
        if (usuario.getClass().getSimpleName().equalsIgnoreCase("AlunoGrad")){
            limite = 3;
        }
        if (usuario.getClass().getSimpleName().equalsIgnoreCase("AlunoPos")){
            limite = 4;
        }      
        
        int cont = 0;
        for(Emprestimo emprestimo: usuario.emprestimos){
            if (emprestimo.isEmCurso()){
                cont++;
            }
        }
        return cont == limite;
    }
    
    public static boolean possuiEmprestimo(Usuario usuario, Exemplar exemplar){
       
        for(Emprestimo emprestimo: usuario.emprestimos){
            if(emprestimo.getTitulo().equalsIgnoreCase(exemplar.getTitulo())){
                if(emprestimo.isEmCurso()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean estaDevendo(Usuario usuario){
        
        LocalDateTime agora = LocalDateTime.now();
        
        for(Emprestimo emprestimo: usuario.emprestimos){
            if (emprestimo.isEmCurso()){
                if (emprestimo.getDataDevolver().isBefore(agora)){
                    usuario.setDevedor(true);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean estaNoLimiteDeReservas(Usuario usuario){
        
        if(usuario.reservas.size() == 3){
            return true;
        }
        return false;
    }

    public static void imprimeReservantes(List<Usuario> usuarios, Livro livro, Exemplar exemplar){
        
        if(livro.getNumeroReservas() > 0){
            System.out.println("\nStatus: O livro está reservado.");
            for(Usuario usuario: usuarios){
                for(Reserva reserva: usuario.reservas){
                    if(reserva.getCodigoExemplar() == exemplar.getCodigo()){
                        System.out.println("\nO exemplar está reservado em nome de " + usuario.getNome());
                        break;
                    }
                }
            }                           
        }        
    }

    public static void imprimeDadosEmprestimo(List<Usuario> usuarios, Exemplar exemplar){

        int cont = 0;
        for(Usuario usuario: usuarios){
            for (Emprestimo emprestimo: usuario.emprestimos){
                if (exemplar.getCodigo() == emprestimo.getCodigoExemplar()){
                    if (emprestimo.isEmCurso()){
                        System.out.println("\nStatus: O livro está emprestado.");
                        System.out.println("\n==== Dados do empréstimo ====\n");
                        System.out.println("O livro está emprestado a " + usuario.getNome());
                        System.out.println("Data do empréstimo: " + emprestimo.getDataEmprestimo());
                        System.out.println("Data prevista para devolução: " + emprestimo.getDataDevolucao());
                        System.out.println("\n=============================");
                        cont++;
                        break;                                   
                    }
                }
            }
            if (cont > 0){
                break;
            }
        }
    }
}
