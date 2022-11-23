/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author Marcos
 */
public class MediDao implements DAO<Medico, Integer>{
    
     final String ID = "dni";
    final String IDESPECIALIDAD = "idEspecialidad";
    final String MATRICULA = "matricula";
    final String NOMBRE = "nombre";
    final String APELLIDO = "apellido";
    final String FECHANAC = "fechaNac";
    final String  DIRECCION = "direccion";
    final String TELEFONO = "telefono";
    final String MAIL = "mail";
   
    final String INSERT = "INSERT INTO medico(" + ID + "," + IDESPECIALIDAD + "," + MATRICULA + ") VALUES(?,?,?)";
    final String UPDATE = "UPDATE medico SET idEspecialidad=?,matricula=? WHERE dni=?";
    final String DELETE = "DELETE FROM medico WHERE dni=?";
    final String GETALL = "SELECT dni, idEspecialidad, matricula FROM medico";
    final String GETONE = "SELECT dni, idEspecialidad, matricula FROM medico WHERE dni=?";
    
    Connection con;
    
    public MediDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Medico t) throws DAOException {
        PreparedStatement stat = null;
       
     try{
         stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getiddni());
         stat.setInt(2, t.getidEspecialidad());
         stat.setInt(3, t.getMatricula());
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
    public void modificar(Medico t) throws DAOException {
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setInt(1, t.getidEspecialidad());
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
    public void eliminar(Medico t) throws DAOException {
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
    public List<Medico> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Medico> medico = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                medico.add(convertir(rs));
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
        return medico;
    }
    
    @Override
    public Medico obtener(Integer idDNI) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Medico m = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, idDNI);
            rs = stat.executeQuery();
            if (rs.next()) {
                m = convertir(rs);
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
        return m;
    }

    private Medico convertir(ResultSet rs) throws SQLException{
        int dni = rs.getInt(ID); 
        int idEspecialidad = rs.getInt(IDESPECIALIDAD);
        int matricula = rs.getInt(MATRICULA);
        Medico medico = new Medico(null,null,dni,null,null,null,0,null,idEspecialidad,matricula);
        medico.setiddni(rs.getInt(ID));
        return medico;
    }
        
   
}
