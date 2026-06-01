package ec.edu.uce.repository;

import java.util.List;
import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {
    public void crearProfe(Profesor profesor);
    public Profesor buscarPorId(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);
    public List<Profesor> listar();
    public void eliminarTodos();
    public void reiniciarSecuencia();
    
    public List<Profesor> seleccionarPorNombre(String nombre);
    public Profesor seleccionarPorCedula(String cedula);
    public List<Profesor> seleccionarPorEspecialidad(String especialidad);
    public List<Profesor> seleccionarPorEspecialidadTyped(String especialidad);
    public List<Profesor> seleccionarPorApellido(String apellido);
    public Long seleccionarContar();
}