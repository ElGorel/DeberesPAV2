package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional //esta anotacion es para que el contenedor se encargue de manejar las transacciones, es decir, que cuando se ejecute un metodo de esta clase, el contenedor se encargue de abrir una transaccion, ejecutar el metodo
public class EstudianteRepositoryImpl implements EstudianteRepository {

    //Principal que gestiona e implementa url (CRUD) de la clase Estudiante
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

}
