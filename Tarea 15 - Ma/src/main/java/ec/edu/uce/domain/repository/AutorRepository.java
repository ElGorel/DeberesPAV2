package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Autor;


public interface AutorRepository {

    public void insertar (Autor autor);
    public Autor consultar(Integer id);
}
