/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaciDao implements DAO<Paciente, Integer> { 
    
   
    
    final String ID = "idDNI";
    final String NOMBRE = "nombre";
    final String APELLIDO = "apellido";
   
    final String INSERT = "INSERT INTO paciente(" + ID + "," + NOMBRE+ "," + APELLIDO + ") VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE paciente SET dni=?,Nombre=?, apellido=? WHERE Idpaciente=?";
    final String DELETE = "DELETE FROM paciente WHERE idDNI ?";
    final String GETALL = "SELECT idDNI, nombre, apellido FROM paciente";
    final String GETONE = "SELECT idDNI FROM paciente WHERE idDNI=?";
    
    Connection con;
    
    public PaciDao(Connection con) {
        this.con = con;
    }
    
      @Override
    public void insertar(Paciente t) throws DAOException {
       PreparedStatement stat = null;
     try{
         stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getidDNI());
         stat.setString(2, t.getnombre());
         stat.setString(3,t.getapellido());
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
            stat.setInt(0, t.getId());
            stat.setInt(1, t.getId());
            stat.setInt(2, t.getId());
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
            stat.setInt(1, t.getId());
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
            } else {
                throw new DAOException("No se encontro registro");
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

    private Paciente convertir(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   }
    	


    

