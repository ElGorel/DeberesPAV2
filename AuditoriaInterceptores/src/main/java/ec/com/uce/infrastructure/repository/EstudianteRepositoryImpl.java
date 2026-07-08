package ec.com.uce.infrastructure.repository;

import ec.com.uce.domain.model.Estudiante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements PanacheRepositoryBase<Estudiante, Integer> {
    // Aquí se pueden agregar métodos específicos de consulta si son necesarios
}
