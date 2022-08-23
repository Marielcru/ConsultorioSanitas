package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConexion {
    //conecciones
    private static SQLConexion instance = null;
    private Connection conexion = null;
    
    //usuario y clav es
    private String user = "sa";
    private String password = "1234";
    private String database = "Clinica";
    private String instanceDB = "//localhost\\SQLEXPRESS";
    
    private String STRING_CONNECTION = "jdbc:sqlserver:" + instanceDB + ";databaseName=" + database + ";user=" + user + ";password=" + password + ";TrustServerCertificate=True;";

    private SQLConexion(){
        try {
            //una sola cadena de conexion, en un solo paramentro se concatena el 
            //usuario y el password
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(STRING_CONNECTION); //string de coneccion a bd
            if (conexion != null) {
                System.out.println("Conexion1:Conexion a Clinica satisfactoria");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion, verifique su usuario y contraseña o el nombre de la base a la que intenta conectarse");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de conexion, No se encontró la clase");
        }
    }

    public static SQLConexion getInstance() {
        if (instance == null) instance = new SQLConexion();
        return instance;
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public void closeConnection(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión");
        }
    }
}
