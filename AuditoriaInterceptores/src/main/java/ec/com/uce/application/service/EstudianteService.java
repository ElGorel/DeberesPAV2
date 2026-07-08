package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Auditar;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.infrastructure.repository.EstudianteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepositoryImpl estudianteRepositoryImpl;

    @Auditar
    public void guardarEstudiante(Estudiante estudiante) {
        // Guardar estudiante
        this.estudianteRepositoryImpl.persist(estudiante);
    }

    @Auditar
    public void actualizarEstudiante(Estudiante estudiante) {
        // Buscar y actualizar los campos
        Estudiante entity = Estudiante.findById(estudiante.getId());
        if (entity != null) {
            entity.setNombre(estudiante.getNombre());
            entity.setApellido(estudiante.getApellido());
            entity.setCedula(estudiante.getCedula());
            entity.setCorreo(estudiante.getCorreo());
            this.estudianteRepositoryImpl.persist(entity);
        }
    }

    @Auditar
    public void eliminarEstudiante(Integer id) {
        // Eliminar por ID
        Estudiante.deleteById(id);
    }
}
