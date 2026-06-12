package ec.edu.uce.application.service;
import java.util.List;
import java.util.Optional;

import ec.edu.uce.domain.model.Oficina;
import ec.edu.uce.domain.model.Profesor;

public interface ProfesorService {
    Profesor guardar(Profesor profesor);
    List<Profesor> listarTodos();
    Optional<Profesor> buscarPorId(Long id);
    void eliminar(Long id);
    Profesor asignarOficina(Long profesorId, Oficina oficina);
}