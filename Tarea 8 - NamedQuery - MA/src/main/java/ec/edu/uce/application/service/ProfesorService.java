package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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

    public java.util.List<Profesor> listarTodos() {
        for (Profesor p : this.profesorRepository.listar()) {
            System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido() + ", Especialidad: " + p.getEspecialidad() + ", Ingreso: " + p.getFechaDocencia());
        }
        return this.profesorRepository.listar();
    }

    public java.util.List<Profesor> consultarPorNombre(String nombre) {
        System.out.println("Docente: " + nombre);
        return this.profesorRepository.seleccionarPorNombre(nombre);
    }
    
    public Profesor consultarPorCedula(String cedula) {
        System.out.println("Docente con cedula: " + cedula);
        return this.profesorRepository.seleccionarPorCedula(cedula);
    }

    public java.util.List<Profesor> consultarPorApellido(String apellido) {
        System.out.println("Docente con apellido: " + apellido);
        return this.profesorRepository.seleccionarPorApellido(apellido);
    }

    public java.util.List<Profesor> consultarPorEspecialidad(String especialidad) {
        System.out.println("Docente con especialidad: " + especialidad);
        return this.profesorRepository.seleccionarPorEspecialidad(especialidad);
    }

    public java.util.List<Profesor> consultarPorEspecialidadTyped (String especialidad){
        System.out.println("(Typed)Docente con la especialidad: " + especialidad);
        return this.profesorRepository.seleccionarPorEspecialidadTyped(especialidad);
    }    

    public Long contarProfesores() {
        System.out.println("Total de docentes: " + this.profesorRepository.seleccionarContar());
        return this.profesorRepository.seleccionarContar();
    }
}