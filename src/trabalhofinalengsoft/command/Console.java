package trabalhofinalengsoft.command;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hugo_Chaves
 */
public class Console{
    
    private Map<String, Command> comandos = inicializarComandos();
    
    public Map<String, Command> inicializarComandos(){
        comandos = new HashMap<>();
        
        //Operações
        comandos.put("emp", new RealizarEmprestimo());
        comandos.put("dev", new Devolver());
        comandos.put("res", new Reservar());
        comandos.put("obs", new RegistrarProfessorObservador());
        comandos.put("rem", new RemoverProfessorObservador());
        
        //Consultas requeridas
        comandos.put("liv", new ConsultarPorCodigo());
        comandos.put("usu", new ConsultarPorUsuario());
        comandos.put("ntf", new ConsultarPorProfessor());
        
        //Consultas adicionais
        comandos.put("exemplares", new listarExemplares());
        comandos.put("usuarios", new listarUsuarios());
        comandos.put("emprestimos", new listarEmprestimos());
        comandos.put("reservas", new listarReservas());
        
        return comandos;
    }
    
    public void executar(String comando){
        
        int codigoUsuario = 0, codigoLivro = 0;
        String[] splitString = comando.split("\\s+");
        
        switch(splitString.length){
            
            case 1 -> { 
                comando = splitString[0];
                comandos.get(comando).execute(codigoLivro, codigoLivro);
            }
            case 2 -> { 
                comando = splitString[0];
                codigoUsuario = Integer.parseInt(splitString[1]);
                comandos.get(comando).execute(codigoUsuario, codigoLivro);
            }
            case 3 -> {
                comando = splitString[0]; 
                codigoUsuario = Integer.parseInt(splitString[1]);
                codigoLivro = Integer.parseInt(splitString[2]);
                comandos.get(comando).execute(codigoUsuario, codigoLivro);
            }              
        }       
    }   
}
