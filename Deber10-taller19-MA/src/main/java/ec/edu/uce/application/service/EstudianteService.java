package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

//Programaremos todos los casos de uso del estudiante
//es decir, toda la logica de negocio
@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;
    
    public void guardarEstudiante(Estudiante estudiante){
        this.estudianteRepository.crearEstudiante(estudiante);
    }

    public Estudiante buscarEstudiante(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);
    }

    public void actualizarEstudiante(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);
    }

    public void eliminarEstudiante(Integer id){
        this.estudianteRepository.eliminar(id);
    }
}
