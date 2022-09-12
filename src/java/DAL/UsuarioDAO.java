package DAL;

import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario, Integer> {//<dato generico, key tipo de datos>

    final String ID = "IdUsuario";
    final String USERNAME = "Ussername";
    final String PASSWORD = "Password";
    final String ROL = "idrol";

    final String INSERT = "INSERT INTO Usuario(" + ID + "," + ROL + "," + USERNAME + "," + PASSWORD + ") VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE Usuario SET Rol=?,Name=?,Contraseña=? WHERE IdUsuario=?";
    final String DELETE = "DELETE FROM Usuario WHERE IdUsuario= ?";
    final String GETALL = "SELECT IdUsuario,Rol,ussername,password FROM Usuarios";
    final String GETONE = "SELECT IdUsuario,Rol,Name,Contraseña FROM Usuario WHERE IdUsuario=?";
    
    
    final String VALIDAR = "SELECT IdUsuario, Ussername, Password, idrol FROM Usuarios WHERE UsserName = '?' AND password ='?'";

    Connection con;
    
    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public UsuarioDAO() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(Usuario t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(INSERT);
            stat.setInt(1, t.getId());
            stat.setInt(2, t.getidrol());
            stat.setString(3, t.getName());
            stat.setString(4, t.getContrasenia());
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

    private Usuario convertir(ResultSet rs) throws SQLException {
        int idrol = rs.getInt(ROL); //averigua el tipo de rol
        String usserName = rs.getString(USERNAME);
        String password = rs.getString(PASSWORD);
        Usuario usuario = new Usuario(idrol, usserName, password);
        usuario.setId(rs.getInt(ID));
        return usuario;
    }

    @Override
    public void modificar(Usuario t) throws DAOException {
        PreparedStatement stat = null;
        //deberia modificar el usuario, rol y contraseña de la base de datos
        try {
            stat = con.prepareStatement(UPDATE);
            stat.setInt(0, t.getId());
            stat.setInt(1, t.getId());
            stat.setInt(2, t.getId());
            stat.setInt(3, t.getId());//utiliza el statemen para sobreescribir los signos de pregunta ??
            if (stat.executeUpdate() == 0) {//devuelve la cantidad de regristros actualizados
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
    public void eliminar(Usuario t) throws DAOException {
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
    public List<Usuario> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                usuarios.add(convertir(rs));
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
        return usuarios;
    }

    @Override
    public Usuario obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuario u = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                u = convertir(rs);
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
        return u;
    }

    public Usuario validarUsuario(String user, String pass) throws DAOException {

        Usuario usser = null;
        String query = "SELECT IdUsuario, Ussername, Password, idrol FROM Usuarios WHERE UsserName = '" + user + "' AND password ='" + pass + "'";
        try (Statement stmt = con.createStatement()) {
          ResultSet rs = stmt.executeQuery(query);
          int id = 0;
          String username = "";
          String password = "";
          int idrol=0;
          while (rs.next()) {
            id = rs.getInt("IdUsuario");
            username = rs.getString("ussername");
            password = rs.getString("Password");
            idrol = rs.getInt("idrol");

          }
          if (id != 0) usser = new Usuario(idrol, username, password);
        } catch (SQLException e) {
        }
        return usser;
    }
}   
