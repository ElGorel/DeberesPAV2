package ec.edu.uce.repository;

import ec.edu.uce.domain.model.Profesor;
import java.util.List;

public interface ProfesorRepository {
    public void crearProfe(Profesor profesor);
    public Profesor buscarPorId(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);
    public List<Profesor> listar();
    public void eliminarTodos();
    public void reiniciarSecuencia();
    public Profesor seleccionarPorCedula(String cedula);
    public Profesor seleccionarPorApellido(String apellido);
    public Profesor seleccionarPrimeroPorEspecialidad(String especialidad);
    public Profesor seleccionarUltimoPorGenero(String genero);
}