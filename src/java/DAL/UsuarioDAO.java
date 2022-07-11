package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadia
 */
public class UsuarioDAO {
    public UsuarioDAO(){
        
    }
    
    
    public boolean findById(int id) {
        try (Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Clinca;user=NETZUKO\\MARCOS;password=");) {
            Statement miStatement=miConexion.createStatement();
            ResultSet miResultSet=miStatement.executeQuery("select usserName from Usuarios");

            while(miResultSet.next()){
                System.out.println(miResultSet.getString(""));
                JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
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
            }