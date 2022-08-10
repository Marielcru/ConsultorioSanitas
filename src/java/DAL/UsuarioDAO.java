package DAL;

import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario, Integer> {
    
    final String ID = "IdUsuario";
    final String USERNAME = "Ussername";
    final String PASSWORD = "Password";
    final String ROL = "Rol";

    final String INSERT = "INSERT INTO Usuario("+ID+","+ROL+","+USERNAME+","+PASSWORD+") VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE Usuario SET Rol=?,Name=?,Contraseña=? WHERE IdUsuario=?";
    final String DELETE = "DELETE FROM Usuario WHERE IdUsuario= ?";
    final String GETALL = "SELECT IdUsuario,Rol,ussername,password FROM Usuarios";
    final String GETONE = "SELECT IdUsuario,Rol,Name,Contraseña FROM Usuario WHERE IdUsuario=?";

    Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Usuario t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(INSERT);
            stat.setInt(1, t.getId());
            stat.setString(2, t.getRol());
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
        String rol = rs.getString(ROL);
        String name = rs.getString(USERNAME);
        String contrasenia = rs.getString(PASSWORD);
        Usuario usuario = new Usuario(rol, name, contrasenia);
        usuario.setId(rs.getInt(ID));
        return usuario;
    }

    @Override
    public void modificar(Usuario t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(UPDATE);
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

    public Usuario validarUsuario(String user, String pass) {
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuario u = null;
        try {
            stat = con.prepareStatement("SELECT IdUsuario, Ussername, Password, Rol FROM Usuario WHERE UsserName = '" + user + "' AND password = '" + pass + "'");
            rs = stat.executeQuery();
            if (rs.next()) {
                u = convertir(rs);
            } else {
                // no se valido el usuario
            }
        } catch (SQLException ex) {
            // Hubo un error
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    //
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    //
                }
            }
        
    
