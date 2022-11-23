package DAL;
import Models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PaciDao implements DAO<Paciente, Integer> { 
    
    final String ID = "DNI";
    final String IDOS = "IdObraSocial";
    final String NOMBRE = "Nombre";
    final String APELLIDO = "Apellido";
    final String FECHANAC = "FechaNac";
    final String  DIRECCION = "Direccion";
    final String TELEFONO = "Telefono";
    final String MAIL = "Mail";
   
    final String INSERT = "INSERT INTO paciente(" + ID + "," + IDOS+ ") VALUES(?,?)";
    final String UPDATE = "UPDATE paciente SET DNI=?,IdObraSocial=? WHERE DNI=?";
    final String DELETE = "DELETE FROM paciente WHERE DNI=?";
    final String GETALL = "SELECT DNI, IdObraSocial FROM paciente";
    final String GETONE = "SELECT DNI,IdObraSocial FROM paciente WHERE DNI=?";
    
    Connection con;

    public PaciDao(Connection con) {
        this.con = con;
    }
    
     public PaciDao() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
      @Override
    public void insertar(Paciente t) throws DAOException {
       PreparedStatement stat = null;
       
     try{
          stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getiddni());
         stat.setInt(2, t.getidObraSocial());
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
    public void modificar(Paciente t) throws DAOException {
    PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setInt(1, t.getidObraSocial());
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
    public void eliminar(Paciente t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, t.getiddni());
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
    public List<Paciente> obtenerTodos() throws DAOException {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<Paciente> paciente = new ArrayList<>();
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
    public Paciente obtener(Integer idDNI) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Paciente p = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, idDNI);
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
   
    private Paciente convertir(ResultSet rs) throws SQLException{
        int dni = rs.getInt(ID); 
        int idObraSocial = rs.getInt(IDOS);
        Paciente paciente = new Paciente(null,null,dni,null,null,null,0,null,idObraSocial);
        paciente.setiddni(rs.getInt(ID));
        return paciente;
    }
    
    
    
    
   }


    

