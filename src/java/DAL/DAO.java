package DAL;
 
import java.util.List;

public interface DAO<T,K> { //T,K clases genericas Idao interfas generica XD espera dos datos 
                            //cuadno las implementas  K=tipo de dato int string
    
    void insertar(T t) throws DAOException;  //como se llama que devuelve
    
    void modificar(T t)throws DAOException;
    
    void eliminar(T t)throws DAOException;
    
    List<T> obtenerTodos()throws DAOException;
    
    T obtener(K id)throws DAOException;
}


