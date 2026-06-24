package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Alumno;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface AlumnoRepository {
    
    public void insertar (Alumno alumno);

    public Alumno consultar (Integer id);
}
