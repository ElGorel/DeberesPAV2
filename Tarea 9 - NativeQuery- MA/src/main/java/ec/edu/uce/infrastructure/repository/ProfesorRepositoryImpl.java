package ec.edu.uce.infrastructure.repository;

import java.util.List;
import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crearProfe(Profesor profesor) { this.em.persist(profesor); }

    @Override
    public Profesor buscarPorId(Integer id) { return this.em.find(Profesor.class, id); }

    @Override
    public void actualizar(Profesor profesor) { this.em.merge(profesor); }

    @Override
    public void eliminar(Integer id) { this.em.remove(this.buscarPorId(id)); }

    @Override
    public List<Profesor> listar() {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return miQuery.getResultList();
    }

    @Override
    public void eliminarTodos() { this.em.createQuery("DELETE FROM Profesor").executeUpdate(); }

    @Override
    public void reiniciarSecuencia() { this.em.createNativeQuery("ALTER SEQUENCE seq_profesor RESTART WITH 1").executeUpdate(); }

    // --- JPQL / NamedQueries ---
    @Override
    public List<Profesor> seleccionarPorNombre(String nombre) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre1", Profesor.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorCedula(String cedula) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula1", Profesor.class);
        miQuery.setParameter("cedula1", cedula);
        return miQuery.getResultList().get(0); 
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorEspecialidad(String especialidad) {
        Query miQuery = this.em.createNamedQuery("Profesor.buscarPorEspecialidad");
        miQuery.setParameter("especialidad", especialidad);
        return (List<Profesor>) miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorEspecialidadTyped(String especialidad) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.buscarPorEspecialidad", Profesor.class);
        miQuery.setParameter("especialidad", especialidad);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorApellido(String apellido) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.buscarPorApellido", Profesor.class);
        miQuery.setParameter("apellido", apellido);
        return miQuery.getResultList();
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Profesor.contar", Long.class);
        return miQuery.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarTodosNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
        return myQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorCedulaNative(String cedula) {
        // En NativeQuery usamos placeholders con ?1, ?2 (o simplemente ?) en PostgreSQL/Hibernate
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_cedula = ?1", Profesor.class);
        myQuery.setParameter(1, cedula);
        return (Profesor) myQuery.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorEspecialidadNative(String especialidad) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_especialidad = ?1", Profesor.class);
        myQuery.setParameter(1, especialidad);
        return myQuery.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorApellidoNative(String apellido) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_apellido = ?1", Profesor.class);
        myQuery.setParameter(1, apellido);
        return myQuery.getResultList();
    }
}
