package DAL;

import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuariosDAO implements DAO<Usuarios, Integer>{
    
    final String INSERT ="INSERT INTO Usuarios(idUsuario,rol,usserName,password) VALUES(?,?,?,?)";
    final String UPDATE ="UPDATE Usuarios SET rol=?,usserName=?,password=? WHERE idUsuario=?";
    final String DELETE ="DELETE FROM Usuarios WHERE idUsuarios= ?";
    final String GETALL ="SELECT idUsuario,rol,usserName,password FROM Usuarios";
    final String GETONE ="SELECT idUsuario,rol,Name,password FROM Usuarios WHERE idUsuario=?";
    
    Connection con;
    
    public UsuariosDAO(Connection con){
    }

    public UsuariosDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(Usuarios t) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat= con.prepareStatement(INSERT);
            stat.setInteger(1,t.getidUsuario());
            stat.setString(2,t.getrol());
            stat.setString(3,t.getusserName());
            stat.setString(4,t.getpassword());
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se guardo");
            }
            
        }catch(SQLException ex){
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
        }
    }
    
    private Usuarios convertir(ResultSet rs) throws SQLException{
        String rol =rs.getString("rol");
        String name =rs.getString("name");
        String password =rs.getString("password");
        Usuarios usuario = new Usuario(rol,name,password);
        usuario.setId(rs.getInteger("idUsuario"));
        return usuario;
            }

    @Override
    public void modificar(Usuarios t) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat=con.prepareStatement(UPDATE);
            stat.setInteger(1,t.getId());
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se guardo");
            }
            
        }catch(SQLException ex){
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
        } }

    @Override
    public void eliminar(Usuarios t) throws DAOException {
         PreparedStatement stat = null;
        try{
            stat=con.prepareStatement(DELETE);
            stat.setInteger(1,t.getId());
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se guardo");
            }
            
        }catch(SQLException ex){
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
        }
        }

    @Override
    public List<Usuarios> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs= null;
        List<Usuarios> usuarios=new ArrayList<>();
        try{
            stat=con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
            if(stat != null){
                try{
                    stat.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
        }
        return usuarios; 
    }

    @Override
    public Usuarioss obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs= null;
        Usuarios u=null;
        try{
            stat=con.prepareStatement(GETONE);
            stat.setInteger(1,id);
            rs = stat.executeQuery();
            if(rs.next()){
                u = convertir(rs);
            }else{
                throw new DAOException("No se encontro registro");
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
            if(stat != null){
                try{
                    stat.close();
                }catch (SQLException ex){
                   throw new DAOException("Error en SQL",ex); 
                }
            }
        }
        return u;
    }
    
    public static void main(String[] args) throws SQLException, DAOException{
    Connection con = null;
    try{
        con = DriverManager.getConnection("jdbc:sqlserver://NADIA:1433;databaseName=Sanitas;user=Nadia;password=16341078");
        UsuariosDAO dao = new UsuariosDAO(con);
        List<Usuarios> usuarios = dao.obtenerTodos();
        for(Usuarios u: usuarios){
            System.out.println(u.toString());
        }
    }finally{
        if( con != null){
            con.close();
    }
    }
    } 

    public void validarUsuarios(String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
