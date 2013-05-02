package interfaz;
import java.rmi.*;

public interface interfazServidor extends Remote{
    public boolean inicioSesion(String nombre, String pass) throws RemoteException;
    public void registrarCliente(interfazCliente cliente, String Nombre) throws RemoteException;
    public void desregistrarCliente(interfazCliente cliente, String Nombre) throws RemoteException;
    public void EnvioMensajes(String Mensaje,interfazCliente cliente) throws RemoteException;
    public int registrarProfesorEnBD(interfazCliente cliente,String Pass,String RUT, String Nombre1,String Nombre2,String FONO,String Apell1) throws RemoteException;
    public int registrarEstudianteEnBD(String Pass,String RUT, String Nombre1,String Nombre2,String Correo,String Apell1, String curso, String Apell2) throws RemoteException;
    public String MostrarCursos() throws RemoteException;
}
