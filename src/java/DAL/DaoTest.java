/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Marcos
 */
public class DaoTest {
   private static EntityManagerFactory emf;
   private static IDatabaseConnection connection;
   private static IDataSet dataset;
 
   @BeforeClass
   public static void initDatabaseTest() {
      try {
         emf = Persistence.createEntityManagerFactory("biblioteca");
         Class.forName("com.mysql.jdbc.Driver");
         Connection jdbcConnection = (Connection) DriverManager
               .getConnection(
                     "jdbc:mysql://localhost:3306/biblioteca",
                     "root", "expertojava");
         connection = new DatabaseConnection(jdbcConnection);
 
         FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
         flatXmlDataSetBuilder.setColumnSensing(true);
         dataset = flatXmlDataSetBuilder.build(Thread.currentThread()
               .getContextClassLoader()
               .getResourceAsStream("test-dao-dataset.xml"));
      } catch (Exception ex) {
         ex.printStackTrace();
         fail("Exception during JPA EntityManager instanciation.");
      }
   }
 
   @AfterClass
   public static void closeEntityManagerFactory() throws Exception {
      DatabaseOperation.DELETE_ALL.execute(connection, dataset);      
      if (emf != null)
         emf.close();
   }
 
   @Before
   public void cleanDB() throws Exception {
      DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
   }
 
   @Test
   public void bibliotecarioDaoCreateTest() {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
 
      // Obtenemos el AdmiDao
      AdmiDao bibliotecarioDao = new AdmiDao(em);
 
      // Creamos un nuevo bibliotecario
      BibliotecarioDomain bibliotecario = new BibliotecarioDomain(
            "francisco.perez", "123456");
      bibliotecarioDao.create(bibliotecario);
      assertNotNull(bibliotecario.getId());
 
      // Guardamos su id y cerramos la transacción y el em
      Long id = bibliotecario.getId();
      em.getTransaction().commit();
      em.close();
 
      // Abrimos otro em para comprobar que el bibliotecario
      // está en la BD
      em = emf.createEntityManager();
      UsuarioDao = new UsuarioDao(em);
      //BibliotecarioDomain bib2 = bibliotecarioDao.find(id);
      assertNotNull(bib2);
      assertTrue(bib2.getLogin().equals(bibliotecario.getLogin())
            && bib2.getPassword().equals(bibliotecario.getPassword()));
      em.close();
   }
}