package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;
    
    public void guardarProfesor(Profesor profesor){
        this.profesorRepository.crearProfe(profesor);
    }

    public Profesor buscarProfesor(Integer id){
        return this.profesorRepository.buscarPorId(id);
    }

    public void actualizarProfesor(Profesor profesor){
        this.profesorRepository.actualizar(profesor);
    }

    public void eliminarProfesor(Integer id){
        this.profesorRepository.eliminar(id);
    }

    public List<Profesor> listarProfesores() {
        return this.profesorRepository.listar();
    }

    public void eliminarProfesores() {
        this.profesorRepository.eliminarTodos();
    }

    public void reiniciarSecuencia() {
        this.profesorRepository.reiniciarSecuencia();
    }
}
