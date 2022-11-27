package trabalhofinalengsoft;

/**
 *
 * @author Hugo_Chaves
 */
public interface Sujeito {
    
    public void registrarObservador(Observador observador);
    public void removerObservador(Observador observador);
    public void notificarObservadores();
}
