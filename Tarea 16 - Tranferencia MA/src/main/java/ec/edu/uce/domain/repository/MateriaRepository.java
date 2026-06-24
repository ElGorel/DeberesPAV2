package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Materia;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface MateriaRepository {

    public void insertar (Materia materia);

    public Materia consultar (Integer id);
}
