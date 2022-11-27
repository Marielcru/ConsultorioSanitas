/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class TurnoDao implements DAO<Turno, Integer> {
    final String ID = "Dni";
    final String ESPECIALIDAD = "Especialidad";
    final String MEDICO = "Medico";
    final String FECHA  = "Fecha";
    final String HORA  = "Hora";
    
    final String INSERT = "INSERT INTO turno(" + ID + "," + ESPECIALIDAD+ "," + MEDICO+ "," + FECHA+ "," + HORA+ ") VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE turno SET DNI=?,Especialidad=?,Medico=?,Fecha=?,Hora=? WHERE DNI=?";
    final String DELETE = "DELETE FROM turno WHERE DNI=?";
    final String GETALL = "SELECT Dni, Especialidad,Medico,Fecha,Hora FROM turno";
    final String GETONE = "SELECT Dni, Especialidad,Medico,Fecha,Hora FROM turno WHERE Dni=?";
    
    Connection con;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String fecha = sdf.format(new Date());

    public TurnoDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Turno t) throws DAOException {
        PreparedStatement stat = null;
       
     try{
          stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getDni());
         stat.setString(2, t.getEspecialidad());
         stat.setString(3, t.getMedico());
         stat.setString(4, fecha);
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
    public void modificar(Turno t) throws DAOException {
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setInt(1, t.getDni());
            stat.setString(2, t.getEspecialidad());
            stat.setString(3, t.getMedico());
            stat.setString(4, fecha);
           // stat.setString(5, t.getEspecialidad());
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
    public void eliminar(Turno t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, t.getIdTurno());
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
    public List<Turno> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Turno> turno = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                turno.add(convertir(rs));
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
        return turno;
    }

    @Override
    public Turno obtener(Integer id) throws DAOException {
       PreparedStatement stat = null;
        ResultSet rs = null;
        Turno t = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                t = convertir(rs);
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
        return t;
    }
    
    private Turno convertir(ResultSet rs) throws SQLException{
        int dni = rs.getInt(ID); 
        String especialidad = rs.getString(ESPECIALIDAD);
        String medico = rs.getString(MEDICO);
        Date fecha = rs.getDate(FECHA);
        String hora = rs.getString(HORA);
        Turno turno = new Turno(dni,especialidad,medico,fecha,hora);
        turno.setDni(rs.getInt(ID));
        return turno;
    }
    
}
