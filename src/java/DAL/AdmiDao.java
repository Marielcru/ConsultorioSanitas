package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadia
 */
public class AdmiDao {
    public AdmiDao(){
        
    }
//public Connection conectar(){
//            /*metodo*/
//            Connection cn=null; 
//            
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn=DriverManager.getConnection(connectionUrl);
//            System.out.println("Conectado.");
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }    
//    
    public boolean findById(int id) {
        try (Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Clinica;user=NETZUKO\\MARCOS;password=");) {
            Statement miStatement=miConexion.createStatement();
            ResultSet miResultSet=miStatement.executeQuery("select idUsuario from Usuarios contraseña");

            while(miResultSet.next()){
                System.out.println(miResultSet.getString(""));
                JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
//            e.printStackTrace();
        }
        // conexion
        
        
        // consulta
        
        // transformacion
        
        return true;
    }
    public boolean validarUsuario(String user,String pass){
        return true;
    }
    /*
    
    public List<Usuario> findAll() {}
    
    public void add()
    
    public void update(Usuario usu)        

            public void delete(int id)
                    
    public Usuario validarUsuario(string user, string pass) {
        return true;
    } 
*/

    private static class conexion {

        public conexion() {
        }
       
        public Connection conectar(String connectionUrl) throws SQLException{
            /*metodo*/
            Connection cn=null; 
            
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(connectionUrl);
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    
            }
    }
}