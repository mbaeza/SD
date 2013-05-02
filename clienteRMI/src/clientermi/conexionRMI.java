package clientermi;

import implementaciones.interfazClienteImpl;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfaz.*;

public class conexionRMI {

    private static Registry registry;
    private static interfazServidor servidor;
    private static interfazCliente cliente;

    public boolean iniciarRegistry() throws RemoteException {
        try {
            //Se inicia RMIREGISTRY para el registro de objetos
            java.security.AllPermission a = new java.security.AllPermission();
            System.setProperty("java.security.policy", "rmi.policy");
            //startRegistry(direccion del registry,puerto de comunicación);
            startRegistry("127.0.0.1", 1099);
            //Vamos al Registry y miramos el Objeto "Implementacion" para poder usarlo.
            servidor = (interfazServidor) registry.lookup("Implementacion");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void startRegistry(String host, int Puerto) throws RemoteException {
        try {
            registry = LocateRegistry.getRegistry(host, Puerto);
            registry.list();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    //Con esto no es necesario hacer un lookup al objeto remoto cada vez que deseemos usarlo
    //basta con llamar a la instancia de la interfaz que fue llamada la primera vez.

    public interfazServidor getServidor() {
        return servidor;
    }

    public void registrarCliente(String Nombre) throws RemoteException {
        cliente = new interfazClienteImpl();
        servidor.registrarCliente(cliente, Nombre);
    }

    public void desregistrarCliente(String Nombre) throws RemoteException {
        servidor.desregistrarCliente(cliente, Nombre);
    }

    public void EnvioMensajes(String Mensaje) throws RemoteException {
        servidor.EnvioMensajes(Mensaje, cliente);
    }
    public int RegistrarEstudiante(String Pass,String RUT, String Nombre1,String Nombre2,String Correo,String Apell1,String curso, String Apell2) throws RemoteException {
       int resultado = servidor.registrarEstudianteEnBD( Pass, RUT,  Nombre1, Nombre2, Correo, Apell1, curso,  Apell2);
       return resultado;
    }
    public int RegistrarProfesor(String Pass,String RUT, String Nombre1,String Nombre2,String FONO,String Apell1) throws RemoteException {
        cliente = new interfazClienteImpl();
        int resultado = servidor.registrarProfesorEnBD(cliente,Pass, RUT,  Nombre1, Nombre2, FONO, Apell1);
        return resultado;
    }
     public int AgregarAsignatura(String id,String nombre) throws RemoteException {  
        int resultado = servidor.AgregarAsignatura( id, nombre);
        return resultado;
    }
     public void EliminarAsignaturas(String NombreAsig) throws RemoteException {
        servidor.EliminarAsignaturas( NombreAsig);
    }
    public int ModificarAsignaturas(String id,String nombre,String asignaturaAModificar)  throws RemoteException {
        int resultado = servidor.ModificarAsignatura( id, nombre, asignaturaAModificar) ;
        return resultado;
    }
    public int AgregarCurso(String cantidad,String nombre) throws RemoteException {  
        int resultado = servidor.AgregarCursos( cantidad, nombre);
        return resultado;
    }
    public int EliminarCursos(String NombreCurso) throws RemoteException {
        int resultado = servidor.EliminarCursos( NombreCurso);
         return resultado;
    }
    public void ModificarCursos(String cantidadCurso,String NombreCursoActual)  throws RemoteException {
        servidor.ModificarCursos( cantidadCurso, NombreCursoActual) ;
    }
    public void AgregarComentario(String comentario,String Alumno,String profesor,String Asunto) throws RemoteException {  
        servidor. AgregarComentario( comentario, Alumno, profesor, Asunto);
     
    }
}
    
       /* public synchronized int AgregarComentario(String comentario,String Alumno,String profesor,String Asunto) throws RemoteException
*/