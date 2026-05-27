package ec.edu.uce.repository;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {
    public void crearEstudiante(Estudiante estudiante);
    public Estudiante seleccionarPorId(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);
}
