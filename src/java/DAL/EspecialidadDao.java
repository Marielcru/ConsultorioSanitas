/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Especialidad;
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
public class EspecialidadDao implements DAO<Especialidad, Integer>{
    final String ID = "idEspecialidad";
    final String NOMBRE = "especialidad";
    
    final String INSERT = "INSERT INTO Especialidad(" + NOMBRE+ ") VALUES(?)";
    final String UPDATE = "UPDATE Especialidad SET especialidad=? WHERE especialidad=?";
    final String DELETE = "DELETE FROM Especialidad WHERE especialidad=?";
    final String GETALL = "SELECT idEspecialidad, especialidad FROM Especialidad";
    final String GETONE = "SELECT idEspecialidad, especialidad FROM Especialidad WHERE especialidad=?";
    
    Connection con;
    
     public EspecialidadDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Especialidad t) throws DAOException {
         PreparedStatement stat = null;
     try{
         stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getidEspecialidad());
         stat.setString(2, t.getEspecialidad());
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
    public void modificar(Especialidad t) throws DAOException { 
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, t.getEspecialidad());
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
    public void eliminar(Especialidad t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setString(1, t.getEspecialidad());
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
    public List<Especialidad> obtenerTodos() throws DAOException {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<Especialidad> listaEspecialidad= new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                listaEspecialidad.add(convertir(rs));
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
        return listaEspecialidad;
    }

    @Override
    public Especialidad obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Especialidad e = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                e = convertir(rs);
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
        return e;
    }
    
    private Especialidad convertir(ResultSet rs) throws SQLException{
        int idEspecialidad = rs.getInt(ID);
        String especialidad = rs.getString(NOMBRE);
        Especialidad espe = new Especialidad(idEspecialidad,especialidad);
        espe.setEspecialidad(rs.getString(NOMBRE));
        return espe;
    }
    
}
