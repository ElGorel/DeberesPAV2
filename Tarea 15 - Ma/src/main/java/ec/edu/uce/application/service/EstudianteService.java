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

    public void guardarEstudiante(Estudiante estudiante) {
        this.estudianteRepository.crearEstudiante(estudiante);
    }

    public Estudiante buscarEstudiante(Integer id) {
        return this.estudianteRepository.seleccionarPorId(id);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        this.estudianteRepository.actualizar(estudiante);
    }

    public void eliminarEstudiante(Integer id) {
        this.estudianteRepository.eliminar(id);
    }

    public java.util.List<Estudiante> seleccionarTodos() {
        for (Estudiante estudiante : this.estudianteRepository.seleccionarTodos()) {
            System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Apellido: " + estudiante.getApellido() + ", Genero: " + estudiante.getGenero());
        }
        return this.estudianteRepository.seleccionarTodos();
    }

    public java.util.List<Estudiante> consultarPorNombre(String nombre) {
        System.out.println("Estudiantes con el nombre: " + nombre);
        return this.estudianteRepository.seleccionarPorNombre(nombre);
    }

    public Estudiante consultarPorCedula(String cedula) {
        System.out.println("Estudiante con la cedula: " + cedula);
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }

    public java.util.List<Estudiante> consultarPorApellido(String apellido) {
        System.out.println("Estudiantes con el apellido: " + apellido);
        return this.estudianteRepository.seleccionarPorApellido(apellido);
    }

    public java.util.List<Estudiante> consultarPorGenero(String genero) {
        System.out.println("Estudiantes con el genero: " + genero);
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }

    public java.util.List<Estudiante> constultarPorGeneroTyped(String genero) {
        System.out.println("Estudiantes con el generoTyped: " + genero);
        return this.estudianteRepository.seleccionarPorGeneroTyped(genero);
    }

    public java.util.List<Estudiante> consultarPorRangoFecha(java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin) {
        System.out.println("Estudiantes nacidos entre: " + fechaInicio + " y " + fechaFin);
        return this.estudianteRepository.seleccionarPorRangoFecha(fechaInicio, fechaFin);
    }

    public Long contarEstudiantes() {
        System.out.println("Total de estudiantes: " + this.estudianteRepository.seleccionarContar());
        return this.estudianteRepository.seleccionarContar();
    }

    public java.util.List<Estudiante> consultarTodosNative() {
        System.out.println("Consulta de todos por Native Query:");
        return this.estudianteRepository.seleccionarTodosNative();
    }

    public java.util.List<Estudiante> consultarTodosCriteria() {
        System.out.println("Consulta a todos con Criteria API:");
        return this.estudianteRepository.seleccionarTodosCriteria();
    }

    public java.util.List<Estudiante> consultarPorNombreCriteria(String nombre){
        System.out.println("Consulta por nombre con Criteria API: " + nombre);
        return this.estudianteRepository.seleccionarPorNombreCriteria(nombre);
    }

    public java.util.List<Estudiante> consultarDinamico(String nombre, String apellido){
        System.out.println("Consulta dinamica con Criteria API: " + nombre + " " + apellido);
        return this.estudianteRepository.seleccionarDinamico(nombre, apellido);
    }
}
