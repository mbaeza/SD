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
    public int ModificarAsignatura(String id,String nombre,String asignaturaAModificar) throws RemoteException;
    public void EliminarAsignaturas(String NombreAsig) throws RemoteException;
    public String MostrarAsignaturas() throws RemoteException;
    public int AgregarAsignatura(String id,String nombre) throws RemoteException;
    public  String MostrarAsignaturasSecundaria() throws RemoteException;
    public int AgregarCursos(String cantidad,String nombre) throws RemoteException;
    public String MostrarCursosSecundario() throws RemoteException;
    public int EliminarCursos(String NombreCurso) throws RemoteException;
    public void ModificarCursos(String cantidadCurso,String NombreCursoActual) throws RemoteException;
    public String MostrarCursosTerciarios() throws RemoteException;
    public  int AgregarComentario(String comentario,String Alumno,String profesor,String Asunto) throws RemoteException;
    public  String MostrarProfesor() throws RemoteException;
}
