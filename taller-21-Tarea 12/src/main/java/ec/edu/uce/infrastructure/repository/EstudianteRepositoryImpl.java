package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional //esta anotacion es para que el contenedor se encargue de manejar las transacciones, es decir, que cuando se ejecute un metodo de esta clase, el contenedor se encargue de abrir una transaccion, ejecutar el metodo
public class EstudianteRepositoryImpl implements EstudianteRepository {

    //1. Query (JPQL Query)
    //Principal que gestiona e implementa url (CRUD) de la clase Estudiante
    //1.1 TypedQuery
    @Inject
    //esta nos la provee el contenedor para que el pueda inyectar el EntityManager
    private EntityManager em;
    @Override
    public void crearEstudiante(Estudiante estudiante) {
        this.em.persist(estudiante);  //persist es el metodo que se encarga de insertar un nuevo registro en la base de datos
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {
       //find recibe dos atributos, el primero es la clase del objeto que queremos buscar y el segundo es el id del objeto que queremos buscar
       return this.em.find(Estudiante.class, id); 
    }

    @Override
    public void actualizar(Estudiante estudiante) {
       //cuando hago merge si o si debe tener el id del estudiante, porque si no seria un persist y no un merge
        this.em.merge(estudiante); //merge es el metodo que se encarga de actualizar un registro en la base de datos
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id)); //remove es el metodo que se encarga de eliminar un registro en la base de datos, pero para eliminar un registro primero debo buscarlo, por eso llamo al metodo seleccionarPorId
    }

    @Override
    public java.util.List<Estudiante> seleccionarTodos() {
      //esta consulta es una consulta JPQL, que es un lenguaje de consultas orientado a objetos, que se utiliza para consultar entidades en lugar de tablas, por eso se utiliza el nombre de la clase (Estudiante) en lugar del nombre de la tabla (estudiante)   
    TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
    return miQuery.getResultList();
    }

    @Override
    public java.util.List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre1", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula1", Estudiante.class);
        miQuery.setParameter("cedula1", cedula);
        //return miQuery.getSingleResult(); //Se debe utilizar en este caso de esperar un solo resultado    
        //return miQuery.getResultList().getFirst(); //Da el primer resultado de la lista, pero si no hay resultados lanza una excepcion, por eso es mejor utilizar el getResultList y luego obtener el primer elemento de la lista
        //return miQuery.getResultList().getLast(); //Da el ultimo resultado de la lista, pero si no hay resultados lanza una excepcion, por eso es mejor utilizar el getResultList y luego obtener el primer elemento de la lista
        return miQuery.getResultList().get(0);  //si hay mas de dos registros
    }

    //1.2 NamedQuery
    //En este caso, la consulta es una consulta JPQL, pero en lugar de escribir la consulta cada vez que quiero consultar por genero, utilizo la anotacion @NamedQuery en la clase Estudiante para definir la consulta una sola vez y luego reutilizarla cada vez que quiero consultar por genero
    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        //En este caso, la clase Estudiante con la anotacion @NamedQuery es mas corta y mas facil de leer, porque no tengo que escribir la consulta JPQL cada vez que quiero consultar por genero, sino que puedo reutilizar la consulta que ya esta definida en la clase Estudiante
        Query miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
        miQuery.setParameter("genero", genero);
        return (List<Estudiante>) miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        miQuery.setParameter("genero", genero);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorApellido(String apellido) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
        miQuery.setParameter("apellido", apellido);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        miQuery.setParameter("inicio", fechaInicio);
        miQuery.setParameter("fin", fechaFin);
        return miQuery.getResultList();         
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return miQuery.getSingleResult();
    }

    //1.3 Native Query
    //En este caso, la consulta es una consulta SQL nativa, que se utiliza para consultar tablas en lugar de entidades, por eso se utiliza el nombre de la tabla (estudiante) en lugar del nombre de la clase (Estudiante)
    @Override
    @SuppressWarnings("unchecked") //esta anotacion es para evitar la advertencia de que el resultado de la consulta no se puede convertir a una lista de estudiantes, porque el metodo getResultList devuelve una lista de objetos, pero como sabemos que la consulta devuelve una lista de estudiantes, podemos suprimir la advertencia
    public List<Estudiante> seleccionarTodosNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
        return myQuery.getResultList();
    }

    //3. Criteria API Query
    @Override
    public List<Estudiante> seleccionarTodosCriteria() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder(); //CriteriaBuilder es la clase que se encarga de construir las consultas criteria, es como un constructor de consultas criteria
        //definimos el tipo de objeto que va a retornar mi consulta (Criteria API Query))
        CriteriaQuery<Estudiante> myQuery= cb.createQuery(Estudiante.class); //CriteriaQuery es la clase que representa una consulta criteria, es como un objeto que representa una consulta criteria
        //definimos las entidades del FROM de la consulta
        Root<Estudiante> root = myQuery.from(Estudiante.class); //Root es la clase que representa la entidad del From de la consulta, es como un objeto que representa la entidad del From de la consulta
        //definimos con que tipo de SQL trabajo, en este caso SELECT
        myQuery.select(root);
        //ejecutamos la consulta luego de contruir el Query que podria tener un where, etc.
        //Trasnformo el query en un Query de JPA para poder ejecutarlo
        TypedQuery<Estudiante> typedQuery = this.em.createQuery(myQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery= cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        //Wherre e.nombre = "nombre"
        //equal 1. que voya  comparar, 2. contra que valor voy a comparar
        Predicate p1=cb.equal(root.get("nombre"), nombre); //root.get("nombre") es como decir e.nombre en JPQL, es decir, estoy accediendo al atributo nombre de la entidad Estudiante, y luego lo comparo con el valor del parametro nombre que recibo en el metodo
        myQuery.select(root).where(p1);

        TypedQuery<Estudiante> typedQuery = this.em.createQuery(myQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarDinamico(String nombre, String apellido){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery= cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);

        List<Predicate> condiciones = new ArrayList<>();
        if(nombre != null){
                Predicate p1=cb.equal(root.get("nombre"), nombre);
                condiciones.add(p1);
        }
        if(apellido != null){
                Predicate p2=cb.equal(root.get("apellido"), apellido);
                condiciones.add(p2);
        }
        myQuery.select(root).where(condiciones);
        TypedQuery<Estudiante> typedQuery = this.em.createQuery(myQuery);
        return typedQuery.getResultList();
    }
    
 }