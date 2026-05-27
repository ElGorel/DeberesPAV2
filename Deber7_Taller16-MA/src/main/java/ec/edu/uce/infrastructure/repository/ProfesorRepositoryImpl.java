package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crearProfe(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override
    public Profesor buscarPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.buscarPorId(id));
    }

    @Override
    public List<Profesor> listar() {
        return this.em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
    }

    @Override
    public void eliminarTodos() {
        this.em.createQuery("DELETE FROM Profesor").executeUpdate();
    }

    @Override
    public void reiniciarSecuencia() {
        this.em.createNativeQuery("ALTER SEQUENCE seq_profesor RESTART WITH 1").executeUpdate();
    }

    @Override
    public Profesor seleccionarPorCedula(String cedula) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula1", Profesor.class);
        miQuery.setParameter("cedula1", cedula);
        //return miQuery.getSingleResult(); //Se debe utilizar en este caso de esperar un solo resultado (una cédula es única)
        //Lanza NoResultException si no hay nada o NonUniqueResultException si hay más de uno.
        return miQuery.getSingleResult();
    }

    @Override
    public Profesor seleccionarPorApellido(String apellido) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.apellido LIKE :apellido1", Profesor.class);
        //El % es para indicar que busque en cualquier parte del texto
        miQuery.setParameter("apellido1", "%" + apellido + "%");
        // return miQuery.getResultList().get(0); // Se utiliza si hay más de dos registros y quieres asegurar obtener el índice 0.
        // Ojo: Si la lista está vacía lanzará IndexOutOfBoundsException.
        return miQuery.getResultList().get(0);
    }

    @Override
    public Profesor seleccionarPrimeroPorEspecialidad(String especialidad) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.especialidad = :esp1 ORDER BY p.fechaNacimiento ASC", Profesor.class);
        miQuery.setParameter("esp1", especialidad);
        // return miQuery.getResultList().getFirst();  // Da el primer resultado de la lista, pero si no hay resultados lanza una excepcion NoSuchElementException, 
                                                        // por eso en un entorno real a veces es mejor validar si la lista está vacía antes.
        return miQuery.getResultList().getFirst();
    }

    @Override
    public Profesor seleccionarUltimoPorGenero(String genero) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.genero = :gen1 ORDER BY p.id ASC", Profesor.class);
        miQuery.setParameter("gen1", genero);
        // return miQuery.getResultList().getLast(); // Da el ultimo resultado de la lista, pero si no hay resultados lanza una excepcion NoSuchElementException.
        return miQuery.getResultList().getLast();
    }
}