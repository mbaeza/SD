package implementaciones;
import interfaz.*;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class interfazServidorImpl extends UnicastRemoteObject implements interfazServidor{

    private ArrayList clientes = new ArrayList();
    private ArrayList NombresClientes = new ArrayList();
    private ArrayList RutClientes = new ArrayList();
    public String Historial = new String();

    public interfazServidorImpl() throws RemoteException{
        super();
    }
    //Este método implementa el servicio de iniciar sesión que se definio en la interfaz
    public boolean inicioSesion(String nombre, String pass) throws RemoteException {
        Connection conexion;
            boolean indicador =false;
            if(!(RutClientes.contains(nombre))){
                try {
                    conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                    Statement st = conexion.createStatement();
                    ResultSet rs =  st.executeQuery ("select * from usuario");

                    while (rs.next() ){
                       if(rs.getString("RUT_USUARIO").equals(nombre) && rs.getString("CONTRASENA").equals(pass)){
                          indicador = true;
                          RutClientes.add(nombre);
                          break;
                       }else{
                          indicador = false;
                       }                        
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                    indicador = false;
                }
            }else{
                indicador=false;
            }

        return indicador;
    }
    //Este método registra clientes que se conectan
    public synchronized void registrarCliente(interfazCliente cliente, String Nombre) throws RemoteException{
        Connection conexion;
        if (!(clientes.contains(cliente))) {
            clientes.add(cliente);
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                ResultSet rs2 =  st.executeQuery ("select * from profesor");

                while (rs2.next() ){
                   if(rs2.getString("RUT_USUARIO").equals(Nombre)){
                       NombresClientes.add(rs2.getString("NOMBRE1_PROFESOR"));
                   }                       
                }
                
                ResultSet rs3 =  st.executeQuery ("select * from administrador");
                
                while (rs3.next() ){
                   if(rs3.getString("RUT_USUARIO").equals(Nombre)){
                       NombresClientes.add("(ADMINISTRADOR)");
                       
                   }                       
                }
                ResultSet rs4 =  st.executeQuery ("select * from estudiante");
                while (rs4.next() ){
                   if(rs4.getString("RUT_USUARIO").equals(Nombre)){
                       NombresClientes.add(rs4.getString("NOMBRE1_ESTUDIANTE"));                    
                   }                       
                }

            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                
            }

            
            //clientesNombre.addElement(Nombre);
           /* for (int i=0;i<clientes.size();i++){
                interfazCliente nextClient = (interfazCliente)clientes.get(i);
                if (!cliente.toString().equals(nextClient.toString())){
                    //Mando la notificacion de que se conecto otro usuario
                    nextClient.notificar("Se CONECTO "+Nombre);
                }
            }*/
        }
    }
        public synchronized int registrarProfesorEnBD(interfazCliente cliente, String Pass,String RUT, String Nombre1,String Nombre2,String FONO,String Apell1) throws RemoteException{
        Connection conexion;
        int resultado = 1;
        clientes.add(cliente);
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                ResultSet rs =  st.executeQuery ("select * from usuario");
                int a = 0;
                int suma = 0;
                int ID = 0;
              
                while (rs.next() ){
                   if(rs.getString("RUT_USUARIO").equals(RUT)){                    
                       a =1;
                   }                    
                }
                if(a!=1){
                    ResultSet buscar =  st.executeQuery ("select * from profesor ");
                    while (buscar.next() ){
                        if(suma == 0){    
                            if(buscar.getString("ID_PROFESOR")!= null)
                                ID = Integer.parseInt(buscar.getString("ID_PROFESOR"));
                            else
                                ID=0;
                        }else if(Integer.parseInt(buscar.getString("ID_PROFESOR"))> ID){
                            ID = Integer.parseInt(buscar.getString("ID_PROFESOR"));
                        }
                        suma++;
                     }
                    ID = ID+1;
                    st.executeUpdate("INSERT INTO usuario (`RUT_USUARIO`, `CONTRASENA`) VALUES ('"+Integer.parseInt(RUT)+"', '"+Pass+"');");
                    st.executeUpdate("INSERT INTO profesor (`RUT_USUARIO`, `ID_PROFESOR`, `CONTRASENA`, `NOMBRE1_PROFESOR`, `TELEFONO_PROFESOR`, `NOMBRE2_PROFESOR`, `APELLIDO1_PROFESOR`) VALUES ('"+Integer.parseInt(RUT)+"', '"+ID+"', '"+Pass+"', '"+Nombre1+"', '"+Integer.parseInt(FONO)+"', '"+Nombre2+"', '"+Apell1+"');");
                    resultado = 1;
                }else{
                    resultado = 0;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
               
            }
           clientes.remove(cliente);
           return resultado;
    }
       
    
    public synchronized int registrarEstudianteEnBD(String Pass,String RUT, String Nombre1,String Nombre2,String Correo,String Apell1,String curso, String Apell2) throws RemoteException{
        int resultado = 1;
        Connection conexion;
            try {
                int codigo_curso = 0;
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                ResultSet rs2 =  st.executeQuery ("select * from curso");
                while (rs2.next() ){
                   if(rs2.getString("Nombre_Curso").equals(curso)){                    
                       codigo_curso = Integer.parseInt(rs2.getString("ID_CURSO"));
                       break;
                   }                    
                }
                ResultSet rs =  st.executeQuery ("select * from usuario");
                int a = 0;
                int suma = 0;
                int ID = 0;
                while (rs.next() ){
                   if(rs.getString("RUT_USUARIO").equals(RUT)){                    
                       a = 1;
                       break;
                   }                    
                }
                if(a!=1){
                    ResultSet buscar =  st.executeQuery ("select * from estudiante ");
                    while (buscar.next() ){
                        if(suma == 0){    
                            if(buscar.getString("ID_ALUMNO")!= null)
                                ID = Integer.parseInt(buscar.getString("ID_ALUMNO"));
                            else
                                ID=0;
                        }else if(Integer.parseInt(buscar.getString("ID_ALUMNO"))> ID){
                            ID = Integer.parseInt(buscar.getString("ID_ALUMNO"));
                        }
                        suma++;
                     }
                    ID = ID+1;
                    st.executeUpdate("INSERT INTO usuario (`RUT_USUARIO`, `CONTRASENA`) VALUES ('"+RUT+"', '"+Pass+"');");
                    st.executeUpdate("INSERT INTO estudiante (`RUT_USUARIO`, `ID_ALUMNO`,`ID_CURSO`,`CONTRASENA`, `NOMBRE1_ESTUDIANTE`,`NOMBRE2_ESTUDIANTE`, `APELLIDO_PATERNO`,`APELLIDO_MATERNO`,`Correo`) VALUES ('"+RUT+"', '"+ID+"','"+codigo_curso+"', '"+Pass+"', '"+Nombre1+"', '"+Nombre2+"', '"+Apell1+"','"+Apell2+"','"+Correo+"');");
                    resultado = 1;
                }else{
                    resultado = 0;
                }

            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            return resultado;
    }
    //Este método elimina clientes y notifica la desconexion de alguno.
    public synchronized void desregistrarCliente(interfazCliente cliente, String Nombre) throws RemoteException{
        if (clientes.remove(cliente) && NombresClientes.remove(Nombre)) {
            //clientesNombre.removeElement(Nombre);
          /*  for (int i=0;i<clientes.size();i++){
                interfazCliente nextClient = (interfazCliente)clientes.get(i);
                //Mando la notificacion de que se conecto otro usuario
                nextClient.notificar("Se DESCONECTO "+Nombre);
            }*/
        }
        else{
            System.out.print("Cliente no estaba registrado");
        }
    }
    
     public synchronized void EnvioMensajes(String Mensaje,interfazCliente cliente) throws RemoteException{
            
         int auxiliar = 0;
         System.out.println(auxiliar);
            //clientesNombre.removeElement(Nombre);
            for (int i=0;i<clientes.size();i++){
                System.out.println(clientes.get(i)+"\n");
                System.out.println(cliente+"\n");
                if((clientes.contains(cliente))){
                    
                    auxiliar = i;
                }
            }
            System.out.println(auxiliar);
            for (int i=0;i<clientes.size();i++){
                interfazCliente nextClient = (interfazCliente)clientes.get(i);
                //Mando la notificacion de que se conecto otro usuario
                nextClient.notificar(NombresClientes.get(auxiliar)+": "+Mensaje+"\n");
            }
        
    }
public synchronized String MostrarCursos() throws RemoteException{
        Connection conexion;
        String Nombredeloscursos= "";
            try {
                //Se crea la conexion 
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                //se hace una consulta
                ResultSet rs2 =  st.executeQuery ("select Nombre_Curso from curso");
                
                //Se toman todos los nombres con respeto a la consulta
                while (rs2.next() ){    
                    if(!(rs2.getString("Nombre_Curso").equals(null)))
                        Nombredeloscursos = Nombredeloscursos+";"+rs2.getString("Nombre_Curso");                                           
                       
                }
                if(Nombredeloscursos.equals(""))
                     Nombredeloscursos = "No hay cursos;";
                
            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            return Nombredeloscursos;
        }

public synchronized int AgregarAsignatura(String id,String nombre) throws RemoteException{
        int resultado = 1;
        Connection conexion;
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                
                //verificar que no exista este curso en la BD
                ResultSet rs =  st.executeQuery ("select * from asignatura");
                int a = 0;
               
                while (rs.next() ){
                   if(rs.getString("ID_ASIGNATURA").equals(id) || rs.getString("NOMBRE_ASIGNATURA").equals(nombre)){                    
                       a = 1;
                       break;
                   }                    
                }
                if(a!=1){                       
                    st.executeUpdate("INSERT INTO asignatura (`ID_ASIGNATURA`,`NOMBRE_ASIGNATURA`) VALUES ('"+Integer.parseInt(id)+"', '"+nombre+"');");
                    resultado = 1;
                }else{
                    resultado = 0;
                }

            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            return resultado;
    }
public synchronized String MostrarAsignaturas() throws RemoteException{
        Connection conexion;
        String Nombredelasasignaturas= "";
            try {
                //Se crea la conexion 
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                //se hace una consulta
                ResultSet rs2 =  st.executeQuery ("select NOMBRE_ASIGNATURA from asignatura");
                
                //Se toman todos los nombres con respeto a la consulta
                while (rs2.next() ){    
                    if(!(rs2.getString("NOMBRE_ASIGNATURA").equals(null)))
                        Nombredelasasignaturas = Nombredelasasignaturas+";"+rs2.getString("NOMBRE_ASIGNATURA");                                           
                       
                }
                if(Nombredelasasignaturas.equals(""))
                     Nombredelasasignaturas = "No hay cursos;";
                
            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            return Nombredelasasignaturas;
        }
public synchronized void EliminarAsignaturas(String NombreAsig) throws RemoteException{
        Connection conexion;  
            try {
                //Se crea la conexion 
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                //se hace una consulta
           
                st.executeUpdate("DELETE FROM `colegio`.`asignatura` WHERE `NOMBRE_ASIGNATURA`='"+NombreAsig+"';");
            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);  
            }           
        }
public synchronized void ModificarAsignatura(String id,String nombre,String asignaturaAModificar) throws RemoteException{
        int ID = 0;
        Connection conexion;
            try {
                
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio", "root", "(markus123)");
                Statement st = conexion.createStatement();
                ResultSet rs2 =  st.executeQuery ("select * from asignatura");
                while (rs2.next() ){
                   if(rs2.getString("NOMBRE_ASIGNATURA").equals(asignaturaAModificar)){                    
                       ID = Integer.parseInt(rs2.getString("ID_CURSO"));
                       break;
                   }                    
                }
                st.executeUpdate("UPDATE `colegio`.`asignatura` SET `ID_ASIGNATURA`='"+ID+"' `NOMBRE_ASIGNATURA`='"+asignaturaAModificar+"' WHERE `ID_CURSO`='"+id+"', `NOMBRE_ASIGNATURA`='"+nombre+"');");
            } catch (SQLException ex) {
                Logger.getLogger(interfazServidorImpl.class.getName()).log(Level.SEVERE, null, ex);               
            }  
}
    }
    

