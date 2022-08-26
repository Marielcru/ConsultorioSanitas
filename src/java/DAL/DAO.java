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


//abstract class Dao<T, K> {
//   EntityManager em; 
///**
//    * Constructor del DAO. Se pasa como parámetro un entity manager que va a
//    * utilizar en todas sus operaciones. El entity manager debe tener abierta
//    * una transacción. Quien llama al DAO es el responsable de abrir y cerrar la
//    * transacción y el entity manager.
//    * 
//    * @param em entity manager
//    * @throws TransactionRequiredException cuando se llama al constructor del
//    *            DAO sin que se haya abierto una transacción en el entity
//    *            manager
//    */
//   public Dao(EntityManager em) {
//      if (!em.getTransaction().isActive())
//         throw new TransactionRequiredException(
//               "Es necesaria una transacción activa para construir el DAO");
//      this.em = em;
//   }
// 
//   /**
//    * @return el entity manager asociado al DAO
//    */
//   public EntityManager getEntityManager() {
//      return this.em;
//   }
// 
//   /**
//    * Devuelve la entidad correspondiente a una clave primaria.
//    * 
//    * @param id clave primaria
//    * @return la entidad encontrada o null si la entidad no existe
//    */
//   public abstract T find(K id);
// 
//   /**
//    * Hace persistente una entidad, obteniéndose su clave primaria en el caso de
//    * que ésta sea generada. La entidad no debe estar gestionada por el entity
//    * manager.
//    * 
//    * @param t entidad que se quiere hacer persistente
//    * @return entidad persistente gestionada por el entity manager, con su clave
//    *         primaria generada
//    * @throws DaoException si la entidad que se pasa ya está creada
//    * @throws IllegalArgumentException si el objeto que se pasa no es una
//    *            entidad
//    */
//   public T create(T t) {
//      try {
//         em.persist(t);
//         em.flush();
//         em.refresh(t);
//         return t;
//      } catch (EntityExistsException ex) {
//         throw new DaoException("La entidad ya existe", ex);
//      }
//   }
// 
//   /**
//    * Actualiza los valores de una entidad en el gestor de persistencia. La
//    * entidad debe tener la clave primaria y puede no estar gestionada por el
//    * entity manager.
//    * 
//    * @param t la entidad persistente que se quiere actualizar
//    * @return la entidad persistente gestionada
//    * @throws IllegalArgumentException Si el objeto que se pasa no es una
//    *            entidad.
//    */
//   public T update(T t) {
//      return (T) em.merge(t);
//   }
// 
//   /**
//    * Elimina la entidad persistente que se pasa como parámetro. Debe tener la
//    * clave primaria y puede no estar gestionada por el entity manager.
//    * 
//    * @param t la entidad persistente que se quiere eliminar
//    * @throws IllegalArgumentException Si el objeto que se pasa no es una
//    *            entidad
//    */
//   public void delete(T t) {
//      t = em.merge(t);
//      em.remove(t);
//   }
//}