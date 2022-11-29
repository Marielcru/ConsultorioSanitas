/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.ObraSocial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class OSocialDao implements DAO<ObraSocial, Integer>{
    
    final String ID = "IdObraSocial";
    final String NOMBRE = "ObraSocial";
   
    final String INSERT = "INSERT INTO ObraSocial(" + NOMBRE+ ") VALUES(?)";
    final String UPDATE = "UPDATE ObraSocial SET ObraSocial=? WHERE Nombre=?";
    final String DELETE = "DELETE FROM ObraSocial WHERE Nombre=?";
    final String GETALL = "SELECT IdObraSocial, ObraSocial FROM ObraSocial";
    final String GETONE = "SELECT IdObraSocial,ObraSocial FROM ObraSocial WHERE ObraSocial=?";
    
    Connection con;
    
     public OSocialDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(ObraSocial t) throws DAOException {
         PreparedStatement stat = null;
     try{
         stat =con.prepareStatement(INSERT);
         //stat.setInt(1, t.getidOSocial());
         stat.setString(2, t.getNombreOS());
         if(stat.executeUpdate()==0) {
            throw new DAOException("no se guardo la Obra Social");
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
    public void modificar(ObraSocial t) throws DAOException {
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, t.getNombreOS());
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
    public void eliminar(ObraSocial t) throws DAOException {
         PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setString(1, t.getNombreOS());
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
    public List<ObraSocial> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<ObraSocial> listaObraSocial = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                listaObraSocial.add(convertir(rs));
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
        return listaObraSocial;
    }

    @Override
    public ObraSocial obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ObraSocial o = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                o = convertir(rs);
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
        return o;
    }
    
    private ObraSocial convertir(ResultSet rs) throws SQLException{
        int idOS = rs.getInt(ID);
        String nombreOS = rs.getString(NOMBRE);
        ObraSocial obraSocial = new ObraSocial(idOS,nombreOS);
        obraSocial.setNombreOS(rs.getString(NOMBRE));
        return obraSocial;
    }
    
    public ObraSocial obtenerPorNombre(String nombre) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ObraSocial o = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setString(1, nombre);
            rs = stat.executeQuery();
            if (rs.next()) {
                o = convertir(rs);
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
        return o;
    }
  
}
