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
        return this.profesorRepository.listar();
    }

    public java.util.List<Profesor> consultarPorNombre(String nombre) {
        System.out.println("Profesores con el nombre: " + nombre);
        return this.profesorRepository.seleccionarPorNombre(nombre);
    }
    
    public Profesor consultarPorCedula(String cedula) {
        System.out.println("Profesor con la cedula: " + cedula);
        return this.profesorRepository.seleccionarPorCedula(cedula);
    }

    public java.util.List<Profesor> consultarPorApellido(String apellido) {
        System.out.println("Profesores con el apellido: " + apellido);
        return this.profesorRepository.seleccionarPorApellido(apellido);
    }

    public java.util.List<Profesor> consultarPorEspecialidad(String especialidad) {
        System.out.println("Profesores con la especialidad: " + especialidad);
        return this.profesorRepository.seleccionarPorEspecialidad(especialidad);
    }

    public java.util.List<Profesor> consultarPorEspecialidadTyped(String especialidad){
        System.out.println("Profesores con la especialidad Typed: " + especialidad);
        return this.profesorRepository.seleccionarPorEspecialidadTyped(especialidad);
    }    

    public Long contarProfesores() {
        System.out.println("Total de profesores: " + this.profesorRepository.seleccionarContar());
        return this.profesorRepository.seleccionarContar();
    }

    public java.util.List<Profesor> consultarTodosNative() {
        System.out.println("Consulta de todos por Native Query:");
        return this.profesorRepository.seleccionarTodosNative();
    }

    public Profesor consultarPorCedulaNative(String cedula) {
        System.out.println("Consulta por Cédula vía Native Query: " + cedula);
        return this.profesorRepository.seleccionarPorCedulaNative(cedula);
    }

    public java.util.List<Profesor> consultarPorEspecialidadNative(String especialidad) {
        System.out.println("Consulta por Especialidad vía Native Query: " + especialidad);
        return this.profesorRepository.seleccionarPorEspecialidadNative(especialidad);
    }

    public java.util.List<Profesor> consultarPorApellidoNative(String apellido) {
        System.out.println("Consulta por Apellido vía Native Query: " + apellido);
        return this.profesorRepository.seleccionarPorApellidoNative(apellido);
    }
}
