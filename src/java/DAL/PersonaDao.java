package DAL;


import Models.Persona;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Nadia
 */
public class PersonaDao implements DAO<Persona, Integer>  {
    final String ID = "dni";
    final String NOMBRE = "nombre";
    final String APELLIDO = "apellido";
    final String FECHANAC = "fechaNac";
    final String  DIRECCION = "direccion";
    final String TELEFONO = "telefono";
    final String MAIL = "email";
    final String ROL = "idrol";
    
   
    final String INSERT = "INSERT INTO persona(" + NOMBRE+ "," + APELLIDO+ "," + ID + "," + DIRECCION+ "," + TELEFONO+ "," + MAIL+ "," + ROL+ "," + FECHANAC+ ") VALUES(?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE persona SET DNI=?,Nombre=?,Apellido=?,FechaNac=?,Direccion=?,Telefono=?,Mail=? WHERE DNI=?";
    final String DELETE = "DELETE FROM persona WHERE DNI=?";
    final String GETALL = "SELECT DNI, Nombre,Apellido,FechaNac,Direccion,Telefono,Mail FROM persona";
    final String GETONE = "SELECT DNI,Nombre,Apellido,FechaNac,Direccion,Telefono,Mail FROM persona WHERE DNI=?";
    
    Connection con;
    
    public PersonaDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Persona t) throws DAOException {
         PreparedStatement stat = null;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String fecha = sdf.format(new Date());
     try{
         stat =con.prepareStatement(INSERT);
         stat.setString(1, t.getNombre());
         stat.setString(2, t.getApellido());
         stat.setInt(3, t.getDni());
         stat.setString(4, t.getDireccion());
         stat.setString(5, t.getTelefono());
         stat.setString(6, t.getMail());
         stat.setInt(7,  t.getRol()); 
         stat.setString(8,  fecha); 
         if(stat.executeUpdate()==0) {
            throw new DAOException("no se guardo el paciente");
     }
     }catch(SQLException ex){
         throw new DAOException ("Error en SQL", ex);
       }finally{
         if(stat !=null){
             try{
                 stat.close();
             } catch (SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             
             }
         }
     }
    }

    @Override
    public void modificar(Persona t) throws DAOException {
    PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setInt(1, t.getDni());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("No se guardo");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Persona t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, t.getDni());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("No se guardo");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public List<Persona> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Persona> paciente = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                paciente.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return paciente;
        }

    @Override
    public Persona obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Persona p = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                p = convertir(rs);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            if (stat != null) {
                try { 
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return p;
    }
    
    private Persona convertir(ResultSet rs) throws SQLException{
        int dni = rs.getInt(ID); 
        String nombre = rs.getString(NOMBRE);
        String apellido = rs.getString(APELLIDO);
        String direccion = rs.getString(DIRECCION);
        String telefono = rs.getString(TELEFONO);
        String mail = rs.getString(MAIL);
        int rol = rs.getInt(ROL); 
        Date fechaNac = rs.getDate(FECHANAC);
        Persona persona = new Persona(nombre,apellido,dni,direccion,telefono,mail,rol,fechaNac);
        persona.setDni(rs.getInt(ID));
        return persona;
    }
    
}
