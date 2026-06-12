package ec.edu.uce.infrastructure.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Oficina;
import ec.edu.uce.domain.model.Profesor;

@ApplicationScoped // CRUCIAL para Quarkus: Permite inyectar esta clase con @Inject en el Main
@Transactional     // Asegura que todas las operaciones sean atómicas y seguras
public class ProfesorServiceImpl implements ProfesorService {

    @Inject // En Quarkus preferimos @Inject sobre @PersistenceContext
    EntityManager em;

    @Override
    public Profesor guardar(Profesor profesor) {
        if (profesor.getId() == null) {
            em.persist(profesor); // Crea un nuevo registro
            return profesor;
        } else {
            return em.merge(profesor); // Actualiza si ya existe
        }
    }

    @Override
    public List<Profesor> listarTodos() {
        return em.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.oficina", Profesor.class)
                 .getResultList();
        // Usamos 'LEFT JOIN FETCH' para traer al profesor junto con su oficina 
        // en una sola consulta eficiente (evita el problema de N+1 consultas).
    }

    @Override
    public Optional<Profesor> buscarPorId(Long id) {
        Profesor profesor = em.find(Profesor.class, id);
        return Optional.ofNullable(profesor);
    }

    @Override
    public void eliminar(Long id) {
        buscarPorId(id).ifPresent(profesor -> em.remove(profesor));
    }

    @Override
    public Profesor asignarOficina(Long profesorId, Oficina oficina) {
        Profesor profesor = em.find(Profesor.class, profesorId);
        if (profesor != null) {
            profesor.setOficina(oficina);
            return em.merge(profesor);
        }
        throw new IllegalArgumentException("No se encontró el profesor con ID: " + profesorId);
    }
}