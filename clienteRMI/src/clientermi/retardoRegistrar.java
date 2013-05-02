package clientermi;

import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.*;

/**
 *
 * @author Administrador
 */
public class retardoRegistrar implements Runnable{
    private Registrar miVista;
    
    public retardoRegistrar(Registrar vista){
        miVista = vista;
    }   


    public void run() {
        try {
            Thread.sleep(4000);
            //this.miVista.ocultarLabel();
        } catch (InterruptedException ex) {
            Logger.getLogger(retardoRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
